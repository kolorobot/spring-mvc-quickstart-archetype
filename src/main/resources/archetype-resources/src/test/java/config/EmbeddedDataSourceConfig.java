package ${package}.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Profile("test")
public class EmbeddedDataSourceConfig implements DataSourceConfig {

    public static final Logger LOG = LoggerFactory.getLogger(EmbeddedDataSourceConfig.class);

    @PostConstruct
    public void postConstruct() {
        LOG.info("Initialized embedded data source");
    }

    @Override
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }
}
