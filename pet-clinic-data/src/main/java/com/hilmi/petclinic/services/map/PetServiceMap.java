package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Pet;
import com.hilmi.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }

    @Override
    public Pet save(Pet entity) {
        if (entity == null)
            return null;

        if (entity.getOwner() == null)
            throw new RuntimeException("Owner cannot be null");

        return super.save(entity);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
