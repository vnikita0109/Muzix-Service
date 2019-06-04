package com.stackroute.config;

import com.stackroute.controller.MuzixController;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan("com.stackroute.*")
public class MuzixConfiguration {
   /* @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }*/
   @Autowired
   private Environment environment;

    @Bean("dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");

        return dataSource;
    }

}
