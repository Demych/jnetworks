package com.example.jnetworks.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DozerConfig {

    @Bean
    public Mapper getMapper() {
        List<String> mappingFiles = Arrays.asList(
                "dozer_mapping.xml"
        );
        return new DozerBeanMapper(mappingFiles);
    }
}
