package com.epam.data.homework2;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CsvMapper csvMapper() {
        return new CsvMapper();
    }
}
