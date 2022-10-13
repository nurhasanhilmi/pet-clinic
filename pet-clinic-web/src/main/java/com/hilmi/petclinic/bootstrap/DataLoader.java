package com.hilmi.petclinic.bootstrap;

import com.hilmi.petclinic.model.Owner;
import com.hilmi.petclinic.model.Vet;
import com.hilmi.petclinic.services.OwnerService;
import com.hilmi.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Ahmad");
        owner1.setLastName("Hilmi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nur");
        owner2.setLastName("Hasan");
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
