package com.hilmi.petclinic.repositories;

import com.hilmi.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
