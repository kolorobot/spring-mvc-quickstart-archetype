package ${package}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { JpaConfig.class, MongoConfig.class})
class PersistenceConfig {}