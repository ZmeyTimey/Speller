package by.timey.speller.main.config;

import by.timey.speller.dao.config.SpringDaoConfig;
import by.timey.speller.service.config.SpringServiceConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.timey.speller.main")
@Import({SpringServiceConfig.class, SpringDaoConfig.class})
public class SpringMainConfig {
}
