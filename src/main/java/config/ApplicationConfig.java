package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({mvcConfig.class, WebSecurityConfig.class})
public class ApplicationConfig {

}
