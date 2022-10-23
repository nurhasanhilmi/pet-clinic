package com.hilmi.petclinic.services.map;

import com.hilmi.petclinic.model.Visit;
import com.hilmi.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit entity) {
        super.delete(entity);
    }

    @Override
    public Visit save(Visit entity) {
        if (entity.getPet() == null
                || entity.getPet().getId() == null
                || entity.getPet().getOwner() == null
                || entity.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit Object");
        }

        return super.save(entity);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
