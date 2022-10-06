package com.hilmi.petclinic.services;

import com.hilmi.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
