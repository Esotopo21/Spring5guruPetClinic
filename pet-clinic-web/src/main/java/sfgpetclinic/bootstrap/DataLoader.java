package sfgpetclinic.bootstrap;

import com.github.javafaker.Faker;
import it.burlac.sfgpetclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetService;
import sfgpetclinic.services.VetService;
import sfgpetclinic.services.map.OwnerMapService;
import sfgpetclinic.services.map.PetMapService;
import sfgpetclinic.services.map.VerMapService;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final PetService petService;
    private final OwnerService ownerService;
    private final Faker faker;
    private static long id;

    public DataLoader() {
        vetService = new VerMapService();
        petService = new PetMapService();
        ownerService = new OwnerMapService();
        faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        List<Speciality> specialityList = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(10); i++){
            specialityList.add(new Speciality(id++, faker.funnyName().name()));
        }

        for(int i=0; i < /*new Random().nextInt(6)*/ 6; i++){
            Vet vet = new Vet();
            vet.setId(id++);
            vet.setFirstName(faker.name().firstName());
            for(int j=0; j < /*new Random().nextInt(3)*/ 3; j++){
                vet.getSpecialities().add(specialityList.get(new Random().nextInt(specialityList.size())));
            }
            vetService.save(vet);
        }

        for (int i = 0; i < /*new Random().nextInt(10)*/ 10; i++){
            Set<Pet> petSet = new HashSet<>();

            Owner owner = new Owner(id++, faker.name().firstName(), faker.name().lastName(), faker.address().streetAddress(),
                    faker.address().city(), String.valueOf(faker.phoneNumber().cellPhone()), new HashSet<>());

            for(int j = 0; j < /*new Random().nextInt(4)*/ 2; j++){
                Pet pet = new Pet(id++, faker.funnyName().name(), faker.date().birthday(), new PetType(id++, faker.animal().name()), owner);
                pet.setOwner(owner);
                petSet.add(pet);
                petService.save(pet);
            }

            owner.setPets(petSet);
            ownerService.save(owner);
        }
        System.out.println("------ VETS ------");
        System.out.println(vetService.findAll());
        System.out.println("------ PETS ------");
        System.out.println(petService.findAll());
        System.out.println("------ OWNS ------");
        System.out.println(ownerService.findAll());





    }

  //  long id, String firstName, String lastName, String address, String city, String telephone
}
