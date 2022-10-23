package com.hilmi.petclinic.bootstrap;

import com.hilmi.petclinic.model.*;
import com.hilmi.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

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
        owner1.addPet(hilmisCat);
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
        owner2.addPet(hasansDog);
        ownerService.save(owner2);

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("Surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("Dentistry");
        specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Lia");
        vet1.setLastName("Amanda");
        vet1.addSpecialty(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Aulia");
        vet2.setLastName("Rahmah");
        vet2.addSpecialty(surgery);
        vet2.addSpecialty(dentistry);
        vetService.save(vet2);

        Visit visit = new Visit();
        visit.setDescription("Visit for Fur Bug");
        visit.setPet(hilmisCat);
        visit.setDate(LocalDate.of(2022, 11, 1));
        visitService.save(visit);

        System.out.println("Bootstrap data loaded");
    }
}
