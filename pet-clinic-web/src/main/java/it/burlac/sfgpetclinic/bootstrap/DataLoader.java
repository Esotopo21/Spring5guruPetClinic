package it.burlac.sfgpetclinic.bootstrap;

import com.github.javafaker.Faker;
import it.burlac.sfgpetclinic.model.*;
import it.burlac.sfgpetclinic.services.*;
import it.burlac.sfgpetclinicservices.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final PetService petService;
    private final OwnerService ownerService;
    private final SpecialtyService specialtyService;
    private final PetTypeService petTypeService;
    private final VisitiService visitiService;
    private final Faker faker;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService, SpecialtyService specialityService, PetTypeService petTypeService, VisitiService visitiService) {
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.specialtyService = specialityService;
        this.petTypeService = petTypeService;
        this.visitiService = visitiService;
        this.faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0){
          loadData();
        }
    }

    private void loadData(){
        loadVets();
    }

    private void loadVets(){
        System.out.println("Loading vets and specialties");
        Speciality s1 = new Speciality("Surgery");
        Speciality s2 = new Speciality("Radiology");
        Speciality s3 = new Speciality("Oncology");

        s1 = specialtyService.save(s1);
        s2 = specialtyService.save(s2);
        s3 = specialtyService.save(s3);

        Vet v1 = new Vet(faker.name().firstName(), faker.name().lastName());

        v1.getSpecialities().add(s1);

        vetService.save(v1);


        Vet v2 = new Vet(faker.name().firstName(), faker.name().lastName());

        v2.getSpecialities().add(s1);
        v2.getSpecialities().add(s3);

        vetService.save(v2);

        Vet v3 = new Vet(faker.name().firstName(), faker.name().lastName());

        v3.getSpecialities().add(s2);

        vetService.save(v3);

        vetService.findById(2L).getSpecialities().forEach(System.out::println);
    }

}
