package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Vet;
import com.hilmi.petclinic.services.SpecialtyService;
import com.hilmi.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public Vet save(Vet entity) {
        if (entity == null)
            return null;

        if (entity.getSpecialties() != null)
            entity.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null)
                    specialtyService.save(specialty);
            });

        return super.save(entity);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
