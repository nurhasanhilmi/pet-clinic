package com.hilmi.petclinic.bootstrap;

import com.hilmi.petclinic.model.Owner;
import com.hilmi.petclinic.model.Pet;
import com.hilmi.petclinic.model.PetType;
import com.hilmi.petclinic.model.Vet;
import com.hilmi.petclinic.services.OwnerService;
import com.hilmi.petclinic.services.PetTypeService;
import com.hilmi.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Load Pet Types Data");


        Pet hilmisCat = new Pet();
        hilmisCat.setName("Jerry");
        hilmisCat.setPetType(cat);
        hilmisCat.setBirthDate(LocalDate.of(2020, 5, 10));

        Owner owner1 = new Owner();
        owner1.setFirstName("Ahmad");
        owner1.setLastName("Hilmi");
        owner1.setAddress("Puri Lestari");
        owner1.setCity("Bogor Regency");
        owner1.setTelephone("088899990000");
        owner1.getPets().add(hilmisCat);
        ownerService.save(owner1);


        Pet hasansDog = new Pet();
        hasansDog.setName("Diamond");
        hasansDog.setPetType(dog);
        hasansDog.setBirthDate(LocalDate.of(2021, 9, 15));

        Owner owner2 = new Owner();
        owner2.setFirstName("Nur");
        owner2.setLastName("Hasan");
        owner2.setAddress("Depok Baru");
        owner2.setCity("Depok");
        owner2.setTelephone("081208591230");
        owner2.getPets().add(hasansDog);
        ownerService.save(owner2);

        System.out.println("Load Owners Data");


        Vet vet1 = new Vet();
        vet1.setFirstName("Lia");
        vet1.setLastName("Amanda");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Aulia");
        vet2.setLastName("Rahmah");
        vetService.save(vet2);

        System.out.println("Load Vets Data");
    }
}
