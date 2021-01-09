# SpringMVC学习记录

*参考视频*

[【狂神说Java】SpringBoot最新教程IDEA版通俗易懂](https://www.bilibili.com/video/BV1PE411i7CV)

## 资源

- [Spring Boot官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)

- [Spring Security官方文档](https://docs.spring.io/spring-security/site/docs/5.4.2/reference/html5/)

- 以及B站视频下方**评论区**

- [Maven仓库官网](https://mvnrepository.com/)

- [Bootstrap 4.5.x Examples](https://getbootstrap.com/docs/4.5/examples/)
    - 员工管理系统的资源，包括Bootstrap样例所需的`HTML`、`CSS`和`JS`文件
    - [Bootstrap4 中文文档](https://v4.bootcss.com/docs/getting-started/introduction/) 部分汉化
    - [Bootstrap3 中文文档](https://v3.bootcss.com/css/) 完全汉化
    - [Feather Icons](https://github.com/feathericons/feather) Bootstrap样例中使用的图标Icon
    - [Chart.js Github](https://github.com/chartjs/Chart.js/releases/tag/v2.9.4) Bootstrap样例中使用的图表JS库
- [jQuery Github下载](https://github.com/jquery/jquery/releases)
    - [jQuery 国内CDN](https://www.bootcdn.cn/jquery/)
- [MyBatis官方文档](https://mybatis.org/mybatis-3/zh/index.html)
- [Semantic-UI Github下载](https://github.com/semantic-org/semantic-ui)
    - [Semantic-UI Icon文档](https://semantic-ui.com/elements/icon.html)
    - Semantic-UI的使用略有麻烦，建议使用CDN
    - 如果像我一样本地提供资源，则需要提供`JS`、`CSS`和`themes`文件夹对应的字体，不提供字体Icon会变为方块

**以上所有的资源在本项目中都已经引入，并且可以正常运行，嫌麻烦的同学可以直接从我的Repo下载**

## 项目环境

- Java : 1.8 (要求)
- IDEA : 2020.3 Ultimate (建议)
- Maven : Bundled (3.6.3)
- Spring Boot : 2.4.x (建议)
    - Spring Security : 5.4.x (使用SpringSecurity5以上的版本无需降级SpringBoot)
- BootStrap : 4.5.x
- jQuery : 3.5.x
- Chart.js : 2.9.x
- feather.js : 4.28.0
- Semantic-UI ：2.4.2

## 注意事项

本项目与狂神的项目模块数量有所不同，我保留下了个人认为价值较高的模块

值得提出的是，`Spring Boot`以及`Spring Security`等系列组件更新迭代速度非常快，一切的参考一定**以官方文档为准**

当前版本的运行我已经调试完成，没有任何问题，但是不保证将来的新版本可以成功运行

此项目要求对前端有**一点点**了解，包括HTML、CSS、JavaScript

## 模块与视频章节的对应

外层模块使用Maven管理，内部SpringBoot模块为其子模块

每一个`springboot-0*-***`都是单独的SpringBoot模块，使用Spring Initializr创建

- `shiro-quickstart`
    - [Apache Shiro](https://shiro.apache.org/index.html) 的快速入门
    - 简单Java程序，体验认证、授权的流程
- `springboot-01-basic`
    - P1-P29
    - 员工管理部分整理了MyBatis
    - 没有实现增加、修改、删除员工的功能，意义不大
    - 员工和部门的表结构和数据位于`sql`目录下
- `springboot-02-druid`
    - P30-P32
- `springboot-03-mybatis`
    - P33
- `springboot-04-security`
    - P34-P37
    - 包含所有的资源文件
    - 文件中存在问题的地方应该都有注释，可以自行查看
- `springboot-05-shiro`
    - P38-P45
    - 这部分的说明文档请查看[这里](./springboot-05-shiro/README.md)，略有点复杂