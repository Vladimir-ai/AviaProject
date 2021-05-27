package service;

import avia.DbConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(DbConfig.class)
@ComponentScan(basePackageClasses = ServicesConfig.class)
public class ServicesConfig {
}
