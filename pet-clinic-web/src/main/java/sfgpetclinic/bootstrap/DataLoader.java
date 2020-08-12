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
        List<Speciality> specialityList = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(10); i++){
            Speciality speciality = new Speciality(faker.animal().name());
            speciality = specialityService.save(speciality);
            specialityList.add(speciality);
        }

        for(int i=0; i < /*new Random().nextInt(6)*/ 6; i++){
            Vet vet = new Vet();
            vet.setFirstName(faker.name().firstName());
            vet.setLastName(faker.name().lastName());
            for(int j=0; j < /*new Random().nextInt(3)*/ 3; j++){
                vet.getSpecialities().add(specialityList.get(new Random().nextInt(specialityList.size())));
            }
            vetService.save(vet);
        }

        List<PetType> petTypes = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            PetType petType = new PetType();
            petType.setName(faker.animal().name());
            petType = petTypeService.save(petType);
            petTypes.add(petType);
        }

        for (int i = 0; i < /*new Random().nextInt(10)*/ 10; i++){
            Set<Pet> petSet = new HashSet<>();

            Owner owner = new Owner(faker.name().firstName(), faker.name().lastName(), faker.address().streetAddress(),
                    faker.address().city(), String.valueOf(faker.phoneNumber().cellPhone()), new HashSet<>());

            for(int j = 0; j < /*new Random().nextInt(4)*/ 2; j++){
                Pet pet = new Pet(faker.funnyName().name(), faker.date().birthday(), petTypes.get(new Random().nextInt(8)), owner);
                pet.setOwner(owner);
                petSet.add(pet);
                petService.save(pet);
            }

            owner.setPets(petSet);
            ownerService.save(owner);
        }
    }
}
