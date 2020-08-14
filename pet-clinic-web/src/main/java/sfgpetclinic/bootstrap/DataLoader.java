package sfgpetclinic.bootstrap;

import com.github.javafaker.Faker;
import it.burlac.sfgpetclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.services.*;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final PetService petService;
    private final OwnerService ownerService;
    private final SpecialityService specialityService;
    private final PetTypeService petTypeService;
    private final Faker faker;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService, SpecialityService specialityService, PetTypeService petTypeService) {
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.specialityService = specialityService;
        this.petTypeService = petTypeService;
        this.faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0){
          loadData();
        }
    }

    private void loadData(){
            PetType pt1 = new PetType();
            pt1.setName(faker.animal().name());
            PetType pt2 = new PetType();
            pt2.setName(faker.animal().name());
            PetType pt3 = new PetType();
            pt3.setName(faker.animal().name());

            petTypeService.save(pt1);
            petTypeService.save(pt2);
            petTypeService.save(pt3);

            Speciality s1 = new Speciality();
            s1.setDescription("Radiology");
            Speciality s2 = new Speciality();
            s2.setDescription("Anatomy");
            Speciality s3 = new Speciality();
            s3.setDescription("Surgery");

            s1 = specialityService.save(s1);
            s2 = specialityService.save(s2);
            s3 = specialityService.save(s3);

            Vet vet1 = new Vet();
            vet1.setFirstName(faker.name().firstName());
            vet1.setLastName(faker.name().lastName());
            vet1.getSpecialities().add(s1);

            Vet vet2 = new Vet();
            vet2.setFirstName(faker.name().firstName());
            vet2.setLastName(faker.name().lastName());
            vet2.getSpecialities().add(s1);
            vet2.getSpecialities().add(s3);

            Vet vet3 = new Vet();
            vet3.setFirstName(faker.name().firstName());
            vet3.setLastName(faker.name().lastName());
            vet3.getSpecialities().add(s2);

//            vetService.save(vet1);
//            vetService.save(vet2);
//            vetService.save(vet3);

            Owner o1 = new Owner();
            o1.setFirstName(faker.name().firstName());
            o1.setLastName(faker.name().lastName());
            o1.setAddress(faker.address().streetAddress());
            o1.setCity(faker.address().city());
            o1.setTelephone(faker.phoneNumber().cellPhone());

            Pet p1 = new Pet();
            p1.setName(faker.artist().name());
            p1.setBirthData(faker.date().birthday());
            p1.setPetType(pt1);

            o1.getPets().add(p1);
            p1.setOwner(o1);

            petService.save(p1);
            ownerService.save(o1);

//            Owner o2 = new Owner();
//            o2.setFirstName(faker.name().firstName());
//            o2.setLastName(faker.name().lastName());
//            o2.setAddress(faker.address().streetAddress());
//            o2.setCity(faker.address().city());
//            o2.setTelephone(faker.phoneNumber().cellPhone());


    }
}
