package com.hilmi.petclinic.services.jpa;

import com.hilmi.petclinic.model.Specialty;
import com.hilmi.petclinic.repositories.SpecialtyRepository;
import com.hilmi.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class SpecialtyServiceJpa implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceJpa(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty entity) {
        return specialtyRepository.save(entity);
    }

    @Override
    public void delete(Specialty entity) {
        specialtyRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
