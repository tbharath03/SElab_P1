package reviewer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppNameConfig {

    @Value("${app.name}")
    private String appName;

    public String getAppName() {
        return appName;
    }
}
