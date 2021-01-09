package org.example.springboot05shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ShiroConfig {

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
}
