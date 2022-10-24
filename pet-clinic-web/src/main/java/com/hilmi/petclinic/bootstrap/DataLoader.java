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

        Pet hilmisCat = Pet.builder()
                .name("Jerry")
                .petType(cat)
                .birthDate(LocalDate.of(2020, 5, 10))
                .build();

        Owner owner1 = Owner.builder()
                .firstName("Ahmad")
                .lastName("Hilmi")
                .address("Puri Lestari")
                .city("Bogor Regency")
                .telephone("088899990000")
                .build()
                .addPet(hilmisCat);

        ownerService.save(owner1);

        Pet hasansDog = Pet.builder()
                .name("Diamond")
                .petType(dog)
                .birthDate(LocalDate.of(2021, 9, 15))
                .build();

        Owner owner2 = Owner.builder()
                .firstName("Nur")
                .lastName("Hasan")
                .address("Depok Baru")
                .city("Depok")
                .telephone("081208591238")
                .build()
                .addPet(hasansDog);

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

        Vet vet1 = Vet.builder()
                .firstName("John")
                .lastName("Smith")
                .build()
                .addSpecialty(radiology);

        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Michael")
                .lastName("Jackson")
                .build()
                .addSpecialty(surgery)
                .addSpecialty(dentistry);

        vetService.save(vet2);

        Visit visit = Visit.builder()
                .description("Night Cough")
                .pet(hilmisCat)
                .date(LocalDate.of(2022, 11, 1))
                .build();

        visitService.save(visit);

        System.out.println("Bootstrap data loaded");
    }
}
