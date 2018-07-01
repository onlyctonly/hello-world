package com.bashfan.config;

import com.bashfan.mapper.UserOrderMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@ComponentScan("com.bashfan")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource getDatasource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/?useSSL=false&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        return comboPooledDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(getDatasource());
        try {
            sqlSessionFactory.setMapperLocations(new FileSystemResource[]{new FileSystemResource("src/main/java/com/bashfan/mapper/UserOrderMapper.xml")});
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSessionFactory.setTypeAliasesPackage("com.bashfan.domain");
        return sqlSessionFactory.getObject();

    }
//
//    @Bean
//    public UserOrderMapper userMapper(SqlSessionTemplate sqlSessionTemplate) throws Exception {
//        return sqlSessionTemplate.getMapper(UserOrderMapper.class);
//    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mScannerConfigurer = new MapperScannerConfigurer();
        mScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mScannerConfigurer.setBasePackage("com.bashfan.mapper");
        return mScannerConfigurer;
    }
}
