package sfgpetclinic.bootstrap;

import com.github.javafaker.Faker;
import it.burlac.sfgpetclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetService;
import sfgpetclinic.services.VetService;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final PetService petService;
    private final OwnerService ownerService;
    private final Faker faker;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService) {
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        List<Speciality> specialityList = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(10); i++){
            specialityList.add(new Speciality(faker.animal().name()));
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

        for (int i = 0; i < /*new Random().nextInt(10)*/ 10; i++){
            Set<Pet> petSet = new HashSet<>();

            Owner owner = new Owner(faker.name().firstName(), faker.name().lastName(), faker.address().streetAddress(),
                    faker.address().city(), String.valueOf(faker.phoneNumber().cellPhone()), new HashSet<>());

            for(int j = 0; j < /*new Random().nextInt(4)*/ 2; j++){
                Pet pet = new Pet(faker.funnyName().name(), faker.date().birthday(), new PetType(faker.animal().name()), owner);
                pet.setOwner(owner);
                petSet.add(pet);
                petService.save(pet);
            }

            owner.setPets(petSet);
            ownerService.save(owner);
        }
    }
}
