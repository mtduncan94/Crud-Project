package com.config;

import com.dao.RaceDAO;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.controller"})
@EnableWebMvc
public class RaceConfig {
    
    
    @Bean
    public DataSource getDataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://bmlx3df4ma7r1yh4.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/r7qbm3iper7c071g");
    dataSource.setUsername("hafel2tqe526iemz");
    dataSource.setPassword("xzx3juy4uiaoit3d");
        return dataSource;
            }
    
   @Bean
    public RaceDAO getRaceDAO(){
    return new RaceDAO(getDataSource());
    }

}