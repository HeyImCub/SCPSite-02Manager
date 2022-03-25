package com.cub.idk.service;

import com.cub.idk.model.Employee;
import com.cub.idk.model.SCPentity;
import com.cub.idk.repository.EmployeeRepository;
import com.cub.idk.repository.SCPentityrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCPentityServiceImpl implements SCPService{
    @Autowired
    private SCPentityrepository scpentityRepository;

    @Override
    public List<SCPentity> getAllSCPs() {
        return scpentityRepository.findAll();
    }

    @Override
    public void saveSCP(SCPentity scp) {
        this.scpentityRepository.save(scp);
    }

    @Override
    public SCPentity getSCPById(long id) {
        Optional< SCPentity > optional = scpentityRepository.findById(id);
        SCPentity scp = null;
        if (optional.isPresent()) {
            scp = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return scp;
    }

    @Override
    public void deleteSCPById(long id) {
        this.scpentityRepository.deleteById(id);
    }




}
