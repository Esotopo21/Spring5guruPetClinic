package sfgpetclinic;

import it.burlac.sfgpetclinic.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgPetClinicApplication{

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(SfgPetClinicApplication.class);

}
