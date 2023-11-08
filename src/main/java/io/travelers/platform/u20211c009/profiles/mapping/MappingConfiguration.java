package io.travelers.platform.u20211c009.profiles.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profilesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AgencyMapper agencyMapper(){ return new AgencyMapper(); }
}
