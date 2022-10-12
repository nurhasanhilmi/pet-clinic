package com.hilmi.petclinic.bootstrap;

import com.hilmi.petclinic.model.Owner;
import com.hilmi.petclinic.model.Vet;
import com.hilmi.petclinic.services.OwnerService;
import com.hilmi.petclinic.services.VetService;
import com.hilmi.petclinic.services.map.OwnerServiceMap;
import com.hilmi.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ahmad");
        owner1.setFirstName("Hilmi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Nur");
        owner2.setFirstName("Hasan");
        ownerService.save(owner2);

        System.out.println("Load Owners Data");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Lia");
        vet1.setLastName("Amanda");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Aulia");
        vet2.setLastName("Rahmah");
        vetService.save(vet2);

        System.out.println("Load Vets Data");
    }
}
