package co.com.alura.challenge.config;

import co.com.alura.challenge.services.IApiConsumptionService;
import co.com.alura.challenge.services.implementations.ApiConsumptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public IApiConsumptionService apiConsumptionService() {
        return new ApiConsumptionService();
    }
}
