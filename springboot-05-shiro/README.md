# Spring Boot 整合 Shiro 安全框架

*同时整合 Druid 数据源、MyBatis 框架*

**建议按照介绍顺序整合**

值得一提的是，三个框架并没有依赖关系，所以其实按照任何顺序整合都是可以的

但此章主要是关于 Shiro 的整合摸索，所以我将首先整合 Shiro

---

## 整合 Shiro

### Shiro 的基本功能和概念

此部分对应 `shiro-quickstart` 模块

这是一个单独的 Maven 项目，本质上就是 Shiro 官网的[10分钟快速上手](https://shiro.apache.org/10-minute-tutorial.html)

主要参考代码是[Github 样例](https://github.com/apache/shiro/tree/master/samples/quickstart)

因为 Shiro 属于开源项目，所以文档的维护并不是很及时与准确

**一定要以最新版的源码为准**

**必须了解的关于安全的概念**
- 基于角色的访问控制
- 基于权限的访问控制
- [一个简单样例](https://www.cnblogs.com/zhexiu/p/7816055.html)

这两个概念不理解，后面Shiro的授权一定会云里雾里

- **Authentication**：认证、鉴权
- **Authorization**：授权

### 尝试与Spring Boot整合

值得一提的是，目前网上的很多整合教程都是导入`shiro-spring`包

我们知道，这个`shiro-spring`包本质上只是和Spring整合的包，导入之后我们还需要写一个`@Configuration`用以和Spring Boot整合

事实上，已经有`shiro-spring-boot-web-starter`包发布，就像`mybatis-spring-boot-starter`一样，它已经帮助我们完成了部分配置

导入之后我们还需要进行少量的配置就可以了

### 需要我们配置的部分

由于安全策略与具体的业务会有联系，就比如说不同的项目所含有的角色和权限定义是完全不同的，所以这部分必定是我们自己配置

并不存在完全自动配置的情况

参考 [官网对Shiro和Spring Boot应用整合的说明](https://shiro.apache.org/spring-boot.html#web-applications)

目前存在两者需要我们配置的部分

#### Realm

这个词的中文翻译是`领域`，Shiro在 [前面的文档](https://shiro.apache.org/architecture.html) 部分也对其做了解释

我个人的理解是由于不同业务被认证和授权的主体不同，这里就是要定义这个主体是什么，以及如何对它进行授权和认证

Shiro 为我们提供了现成的Realm可以直接使用，本样例中我使用类全限定名是`org.apache.shiro.realm.jdbc.JdbcRealm`

也就是从数据库读取用户的信息 (用户名、密码、角色、权限)，然后进行认证

在`JdbcRealm`中定义了默认的查询语句，我们根据查询语句建立对应的数据库表

```java
protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";

protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";

protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";

protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";
```

当然，`JdbcRealm`是支持覆写SQL语句的，你可以用`set***Query`方法覆写内置的SQL语句

不过这里对SQL语句查询结果应该还会有其他要求，具体的我还没有研究，我使用的就是默认的

同时还需要设置一个数据源

```java
private DataSource dataSource;

@Autowired
public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
}

@Bean
public Realm realm() {
    JdbcRealm realm = new JdbcRealm();
    realm.setDataSource(dataSource);
    // 基于权限的资源访问默认是关闭的
    realm.setPermissionsLookupEnabled(true);
    return realm;
}
```

那么由于我使用的是自带提供的`JdbcRealm`，所以认证、授权的过程都不用我来具体实现，其还支持加盐功能


#### ShiroFilterChainDefinition

定义完进行认证和授权的 Subject，下一步就是定义应该按照什么样的规则进行认证和授权

[官网关于认证的文档](https://shiro.apache.org/authentication.html)

[官网关于授权的文档](https://shiro.apache.org/authorization.html)

Shiro框架支持通过URL或者注解配置认证和授权，这两种方式没有好坏之分，参考网上的说法，往往两种结合才更有效

关于过滤器可以参考[默认过滤器](https://shiro.apache.org/web.html#default-filters)

这里贴出我写的过滤规则

```java
@Bean
public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    // 登出功能
    chainDefinition.addPathDefinition("/logout", "logout");
    // 错误页面无需认证
    chainDefinition.addPathDefinition("/error", "anon");
    // druid连接池的角色控制，只有拥有admin角色的admin用户可以访问，不理解可以先不管
    chainDefinition.addPathDefinition("/druid/**", "authc, roles[admin]");
    // 静态资源无需认证
    chainDefinition.addPathDefinition("/static/**", "anon");
    // 其余资源都需要认证
    chainDefinition.addPathDefinition("/**", "authc");
    return chainDefinition;
}
```

大体思想是在URL中配置认证规则 (鉴权)，在Controller中使用注解配置授权，这样的优势：

1. 减少代码量，不必为每个Controller都写上鉴权规则
2. 利用注解可以细粒度设置基于角色或者基于资源的权限

##### 基于角色的访问控制

现在我们来看这一条规则

```java
chainDefinition.addPathDefinition("/druid/**", "authc, roles[admin]");
```

由于在配置完Shiro后，我为项目整合了 Druid 数据源，如果你对它不是很了解，建议去查看[Github 文档](https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)

这里无需对 Druid 有很详细的了解，我想阐述的最关键的一点是，当你整合成功 Druid 框架，并且开启了 Web 统计功能 (参考我的`application.yml`)

访问你的 `项目URL/druid` 会进入 Druid 数据源的管理界面，这里需要输入你之前设置的用户名和密码才能查看项目对每一条执行过的SQL的统计情况

显然这个功能我不希望普通角色的用户也能查看，所以我将其设置为所有匹配规则 `/druid/**` 的URL都需要**登录**并且需要有**admin**角色

对应的，你可以尝试使用`admin`用户去登录并访问`/druid`页面，我已经将admin用户设置为admin角色 (这里可能有一些绕，原谅我是为了省事才把两个名字设置相同的，这里的用户名完全可以修改为你自己的名字！)

之后，再尝试使用`andy67123`用户去登录并访问`/druid`页面，它的角色仅仅是`访客`，看看会有什么不同

**类似的**，还有一处使用注解来控制角色访问

在`AccountInfoController`中，有这么一段代码表明这处的资源需要admin角色才能访问

```java
    @RequiresRoles("admin")
    @RequestMapping("/account-info")
    public String accountInfoTemplate(Model model) {
    ...
    }
```

##### 基于权限的访问控制

最后，我们来聊Shiro中常用功能同样也很重要的一部分——**Permissions**

先上[官方文档 Understanding Permissions in Apache Shiro](https://shiro.apache.org/permissions.html)

这部分我也是想了很久，什么时候需要使用基于角色的访问控制，什么时候需要使用基于资源的访问控制，什么时候可以两者合并使用

诚然，你的系统完全可以只使用基于角色的访问控制，在此样例中就只需要`users`和`user_roles`两张表，然后在Controller使用`@RequiresRoles("role")`注解去指定角色

也可以只使用基于权限的访问控制 (依然需要角色，但是不再通过角色控制访问)，在此样例中需要`users`、`user_roles`和`roles_permissions`三张表，然后在Controller使用`@RequiresPermissions("perm")`注解去指定权限

这一部分关于如何设计以及谁优谁劣先暂且不讨论，因为我也不知道

此处先把 Shiro 的 Permissions 样例展示一下

