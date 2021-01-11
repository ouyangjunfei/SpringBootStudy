package org.example.springboot06swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("个人开发的接口")
                .select()
                // 只扫描org.example包下的API，去掉后查看区别
                .apis(RequestHandlerSelectors.basePackage("org.example"))
                // 只扫描符合/api/**样式的API，去掉后查看区别
                //.paths(PathSelectors.ant("/api/**"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置文档的基础信息
     * <p>
     * 联系方式、版本、证书等
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Api文档",
                "Swagger2测试文档",
                "0.0.1",
                "urn:tos",
                contact(),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

    /**
     * 联系人的对象
     *
     * @return 联系人
     */
    private Contact contact() {
        return new Contact("欧阳",
                "https://github.com/ouyangjunfei",
                "1342597034@qq.com");
    }
}
