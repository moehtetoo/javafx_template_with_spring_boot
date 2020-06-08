package com.pos.databases;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.SqliteDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SingletonConfig
public class AppConfig implements Config {
    private static final AppConfig CONFIG = new AppConfig();

    public static AppConfig singleton()
    {
        return CONFIG;
    }

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    @Bean
    @ConfigurationProperties( prefix="spring.datasource" )
    private DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    private AppConfig() {
        dialect = new SqliteDialect();
        dataSource = new LocalTransactionDataSource( dataSource() );

        transactionManager = new LocalTransactionManager(
                dataSource.getLocalTransaction(getJdbcLogger()));
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
}
