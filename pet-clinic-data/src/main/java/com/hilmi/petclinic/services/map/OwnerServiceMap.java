package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Owner;
import com.hilmi.petclinic.services.OwnerService;
import com.hilmi.petclinic.services.PetService;
import com.hilmi.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public Owner save(Owner entity) {
        if (entity == null)
            return null;

        entity.getPets().forEach(pet -> {
            if (pet.getPetType() == null)
                throw new RuntimeException("Pet type is required");

            petTypeService.save(pet.getPetType());

            pet.setOwner(entity);
            petService.save(pet);
        });

        return super.save(entity);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
