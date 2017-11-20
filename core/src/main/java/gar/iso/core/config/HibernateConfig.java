package gar.iso.core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Gor on 11/17/2017.
 */
@Configuration
@ComponentScan("gar.iso.core.dto")
@EnableTransactionManagement
public class HibernateConfig {

//    database url and name
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sexshop";

//    database dialect
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";

//    database Driver
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

//    database username
    private static final String DATABASE_USERNAME = "root";

//    database password
    private static final String DATABASE_PASSWORD = "Myroot@1987!";


    //    Intantiating DataSource Bean and returning its object
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

//        Setting database connection information
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

//    Intantiating SessionFactory Bean with DataSource and returning its object
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("gar.iso.core.dto");
        return builder.buildSessionFactory();
    }

//    All Hibernate properties is returned via this method
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }

//    Instantiating HibernateTransactionManager Bean with SessionFactory and returning its object
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

}
