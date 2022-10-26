package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap serviceMap;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        serviceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        serviceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = serviceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = serviceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = serviceMap.save(owner2);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner savedOwner = serviceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        serviceMap.delete(serviceMap.findById(ownerId));

        assertEquals(0, serviceMap.findAll().size());
    }

    @Test
    void deleteById() {
        serviceMap.deleteById(ownerId);

        assertEquals(0, serviceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = serviceMap.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId, smith.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = serviceMap.findByLastName("foo");

        assertNull(smith);
    }
}