package com.example.demo.services;

import com.example.demo.entities.CaseEntity;

import com.example.demo.repositories.CaseRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CaseServiceImpl implements CaseService{

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public CaseEntity createCase(CaseEntity caseEntity) {
        return caseRepository.save(caseEntity);
    }

    @Override
    public CaseEntity getCase(Long id) {
        Optional<CaseEntity> optionalCaseEntity = caseRepository.findById(id);
        return optionalCaseEntity.get();
    }

    @Override
    public boolean deleteCase(Long id) {
        CaseEntity caseEntity = caseRepository.findById(id).get();
        caseRepository.delete(caseEntity);
        return true;
    }

    @Override
    public CaseEntity updateCase(Long id, CaseEntity caseEntity) {
        CaseEntity newcaseEntity = caseRepository.findById(id).get();

        newcaseEntity.setAddress(caseEntity.getAddress());
        newcaseEntity.setAge(caseEntity.getAge());
        newcaseEntity.setName(caseEntity.getName());
        newcaseEntity.setEmail(caseEntity.getEmail());
        newcaseEntity.setDescription(caseEntity.getDescription());
        newcaseEntity.setDepartment(caseEntity.getDepartment());
        newcaseEntity.setPhone(caseEntity.getPhone());
        newcaseEntity.setRole(caseEntity.getRole());
        newcaseEntity.setYearOfExperience(caseEntity.getYearOfExperience());

        caseRepository.save(newcaseEntity);
       
        return newcaseEntity;

    }

    @Override
    public List<CaseEntity> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public List<CaseEntity> getAllCasesByPagination(Integer pageNumber, Integer pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        Page<CaseEntity> pageCases = caseRepository.findAll(page);
        return pageCases.hasContent() ? pageCases.getContent() : new ArrayList<>();
    }
}
