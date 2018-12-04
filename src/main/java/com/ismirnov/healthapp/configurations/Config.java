package com.ismirnov.healthapp.configurations;

import com.ismirnov.healthapp.persist.DoctorEntityDAO;
import com.ismirnov.healthapp.persist.UserEntityDAO;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
public class Config {
    @Bean
    DataSource healthappDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/healthapp");
        ds.setUsername("postgres");
        ds.setPassword("123454321");
        return ds;
    }

/*    @Bean(name = "healthappSessionFactory")
    public SessionFactory healthappSessionFactory() {
        LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(healthappDataSource());
        sfb.scanPackages("com.ismirnov.healthapp.persist");
        sfb.addProperties(hibernateProperties());
        return sfb.buildSessionFactory();
    }*/


    @Bean(name = "healthappSessionFactory")
    LocalSessionFactoryBean healthappSessionFactory() {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(healthappDataSource());
        sf.setHibernateProperties(hibernateProperties());
        sf.setPackagesToScan("com.ismirnov.healthapp.persist");
        return sf;
    }

/*    @Bean(name = "transactionManager")
    public HibernateTransactionManager getManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(healthappSessionFactory());
        return manager;
    }*/

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        hibernateProperties.setProperty("hibernate.connection.pool_size", "1");
//        hibernateProperties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.internal.NoCachingRegionFactory");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
        return hibernateProperties;
    }

    @Bean
    UserEntityDAO userEntityDAO(SessionFactory sf) {
        UserEntityDAO userDAO = new UserEntityDAO();
        userDAO.setSessionFactory(sf);
        return userDAO;
    }

    @Bean
    DoctorEntityDAO doctorEntityDAO(SessionFactory sf) {
        DoctorEntityDAO doctorDAO = new DoctorEntityDAO();
        doctorDAO.setSessionFactory(sf);
        return doctorDAO;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
