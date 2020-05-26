package com.tetra.eos.commom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
//	@Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		
    //        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/*","classpath:/META-INF/resources/*");
          //  registry.addResourceHandler("/img").addResourceLocations("classpath:/static/img");            
//    }
	

	@Autowired
	@Qualifier(value = "authenticationInterceptor")
	private HandlerInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/swagger-resources/**")
				.excludePathPatterns("/v2/api-docs")
				.excludePathPatterns("/resources/**")
				.excludePathPatterns("/error")
				.excludePathPatterns("/login");
				;
	}	
	
}
