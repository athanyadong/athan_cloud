//package com.athan.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@EnableSwagger2
//@Configuration
//@Primary
//public class SwaggerConfig implements SwaggerResourcesProvider {
//
//    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
//    @Value(value =  "${swagger.enabled}")
//    Boolean swaggerEnabled;
//    @Autowired
//    RouteLocator routeLocator;
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                // 是否开启
//                .enable(swaggerEnabled).select()
//                // 扫描的路径包
//                .apis(RequestHandlerSelectors.basePackage("com.athan"))
//                // 指定路径处理PathSelectors.any()代表所有的路径
//                .paths(PathSelectors.any()).build().pathMapping("/");
//    }
//
//    //设置api信息
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("路由网关(Zuul)：利用swagger2聚合API文档")
//                .description("测试接口文档")
//                // 作者信息
//                .contact(new Contact("MarlonBrando", "https://blog.csdn.net/qq_37248504/article/details/106750307", "1924086063@qq.com"))
//                .version("1.0.0")
//                .termsOfServiceUrl("https://blog.csdn.net/qq_37248504/")
//                .build();
//    }
//
//    @Override
//    public List<SwaggerResource> get() {
//        //利用routeLocator动态引入微服务
//        List<SwaggerResource> resources = new ArrayList<>();
//        resources.add(swaggerResource("athan-gateway","/v2/api-docs","1.0"));
//        //循环 使用Lambda表达式简化代码
//        routeLocator.getRoutes().toStream().forEach(route ->{
//            //动态获取
//            resources.add(swaggerResource(route.getId(),route.getUri().getPath().replace("**", "v2/api-docs"), "1.0"));
//        });
//        return resources;
//    }
//    private SwaggerResource swaggerResource(String name,String location, String version) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion(version);
//        return swaggerResource;
//    }
//}
