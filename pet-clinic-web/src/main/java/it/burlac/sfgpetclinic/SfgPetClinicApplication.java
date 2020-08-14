package it.burlac.sfgpetclinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "it.burlac.sfgpetclinic.model")
@ComponentScan(basePackages = "it.burlac.sfgpetclinic")
public class SfgPetClinicApplication{

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(SfgPetClinicApplication.class);

}
