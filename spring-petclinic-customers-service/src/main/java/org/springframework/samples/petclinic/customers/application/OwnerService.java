package org.springframework.samples.petclinic.customers.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.customers.domain.model.owner.Owner;
import org.springframework.samples.petclinic.customers.domain.model.owner.OwnerRepository;
import org.springframework.samples.petclinic.monitoring.Monitored;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author mszarlinski on 2016-10-30.
 */
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional(readOnly = true)
    public Owner findOwnerById(int id) throws DataAccessException {
        return ownerRepository.findOne(id);
    }

    @Monitored
    @Transactional(readOnly = true)
    public Collection<Owner> findAll() throws DataAccessException {
        return ownerRepository.findAll();
    }

    @Monitored
    @Transactional
    public void saveOwner(Owner owner) throws DataAccessException {
        ownerRepository.save(owner);
    }

}
