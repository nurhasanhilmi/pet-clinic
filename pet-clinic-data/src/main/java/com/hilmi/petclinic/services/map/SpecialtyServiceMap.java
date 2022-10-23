package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Specialty;
import com.hilmi.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map-service"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty entity) {
        super.delete(entity);
    }

    @Override
    public Specialty save(Specialty entity) {
        return super.save(entity);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
