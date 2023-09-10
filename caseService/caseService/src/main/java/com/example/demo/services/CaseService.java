package com.example.demo.services;



import com.example.demo.entities.CaseEntity;



import java.util.List;

public interface CaseService {

    CaseEntity createCase(CaseEntity caseEntity);

    CaseEntity getCase(Long id);

    boolean deleteCase(Long id);

    CaseEntity updateCase(Long id, CaseEntity caseEntity);

    List<CaseEntity> getAllCases();


}
