package com.sjmahavidyalaya.sj.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {
    @Bean
    public Cloudinary getCloudinary() {
        Map config = new HashMap();
        config.put("cloud_name", "amandb");
        config.put("api_key", "938553971614247");
        config.put("api_secret", "dA1UZKiQpf8gp9C3tRddBFpopJ0");
        config.put("secure", true);
        return new Cloudinary(config);
    }
}
