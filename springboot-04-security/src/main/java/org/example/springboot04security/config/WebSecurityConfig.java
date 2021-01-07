package org.example.springboot04security.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        /*
         *         ===非常重要===
         * 请查看loginPage()方法的文档说明以及源码
         * 在请求登录页面时，是通过Get /toLogin
         * 登录页面的表单提交action的填写也是/toLogin，但是必须使用Post方法
         * 如果有自定义验证登录的URL，请设置loginProcessingUrl(String url)并修改html页面表单的action
         * 登录页面的表单的提交需要有username和password参数
         * 记住我对应的名称为remember-me
         */
        http.formLogin().loginPage("/toLogin").usernameParameter("username").passwordParameter("password");

        //http.logout().deleteCookies("remove").invalidateHttpSession(true);
        //注销成功返回首页
        //http.csrf().disable();    不建议关闭防止CSRF攻击的功能
        http.logout().logoutSuccessUrl("/");

        http.rememberMe().tokenValiditySeconds(3 * 24 * 3600);
    }

    //认证
    //必须添加对明文密码的散列
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Spring Security 5以后新增即便是基于内存认证也必须对密码实现加密
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("root").password(encoder.encode("root")).roles("VIP1", "VIP2", "VIP3")
                .and()
                .withUser("andy").password(encoder.encode("andy")).roles("VIP2", "VIP3")
                .and()
                .withUser("guest").password(encoder.encode("guest")).roles("VIP1");
    }

}
