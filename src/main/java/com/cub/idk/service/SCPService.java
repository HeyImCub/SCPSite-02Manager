package com.cub.idk.service;

import com.cub.idk.model.SCPentity;

import java.util.List;

public interface SCPService {
    List<SCPentity> getAllSCPs();
    void saveSCP(SCPentity scp);
    SCPentity getSCPById(long id);
    void deleteSCPById(long id);
}
