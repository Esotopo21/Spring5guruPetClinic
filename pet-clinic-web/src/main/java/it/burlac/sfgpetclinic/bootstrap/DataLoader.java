package it.burlac.sfgpetclinic.bootstrap;

import com.github.javafaker.Faker;
import it.burlac.sfgpetclinic.model.*;
import it.burlac.sfgpetclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
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
        loadPetsAndOwners();
        loadVisits();
    }

    private void loadPetsAndOwners(){
        log.info("Loading pets and owners...");
        Owner owner1 = new Owner();
        owner1.setFirstName(faker.name().firstName());
        owner1.setLastName(faker.name().lastName());
        owner1.setAddress(faker.address().streetAddress());
        owner1.setCity(faker.address().city());
        owner1.setTelephone(faker.phoneNumber().cellPhone());

        Pet pet1 = new Pet();
        pet1.setName(faker.superhero().name());
        pet1.setBirthData(faker.date().birthday());

        PetType petType1 = new PetType();
        petType1.setName(faker.animal().name());

        pet1.setPetType(petType1);
        pet1.setOwner(owner1);

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName(faker.name().firstName());
        owner2.setLastName(faker.name().lastName());
        owner2.setAddress(faker.address().streetAddress());
        owner2.setCity(faker.address().city());
        owner2.setTelephone(faker.phoneNumber().cellPhone());

        Pet pet2 = new Pet();
        pet2.setName(faker.superhero().name());
        pet2.setBirthData(faker.date().birthday());

        PetType petType2 = new PetType();
        petType2.setName(faker.animal().name());

        pet2.setPetType(petType2);
        pet2.setOwner(owner2);

        Pet pet3 = new Pet();
        pet3.setName(faker.superhero().name());
        pet3.setBirthData(faker.date().birthday());

        PetType petType3 = new PetType();
        petType3.setName(faker.animal().name());

        pet3.setPetType(petType3);
        pet3.setOwner(owner2);

        owner2.getPets().add(pet3);

        ownerService.save(owner2);

        log.info("Pets and owners loaded.");
    }

    //Loading vets and specialties
    private void loadVets(){
        log.info("Loading vets....");
        Speciality s1 = new Speciality("Surgery");
        Speciality s2 = new Speciality("Radiology");
        Speciality s3 = new Speciality("Oncology");

        s1 = specialtyService.save(s1);
        s2 = specialtyService.save(s2);
        s3 = specialtyService.save(s3);

        Vet v1 = new Vet();
        v1.setFirstName(faker.name().firstName());
        v1.setLastName(faker.name().lastName());

        v1.getSpecialities().add(s1);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName(faker.name().firstName());
        v2.setLastName(faker.name().lastName());

        v2.getSpecialities().add(s1);
        v2.getSpecialities().add(s3);

        vetService.save(v2);

        Vet v3 = new Vet();
        v3.setFirstName(faker.name().firstName());
        v3.setLastName(faker.name().lastName());

        v3.getSpecialities().add(s2);

        vetService.save(v3);

        vetService.findById(2L).getSpecialities().forEach(System.out::println);
        log.info("Vets Loaded.");
    }

    private void loadVisits(){
        log.info("Loading visits");

        petService.findAll().forEach(pet -> {
            Visit visit = new Visit();
            visit.setDate(LocalDate.now());
            visit.setDescription(faker.lorem().paragraph(2));
            visit.setPet(pet);

            visitiService.save(visit);
        });
    }
}
