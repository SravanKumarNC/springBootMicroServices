package com.example.demo.controllers;


import com.example.demo.entities.CaseEntity;
import com.example.demo.services.CaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cases")

public class CaseController {

    @Autowired
    private CaseService caseService;

    @PostMapping
    public ResponseEntity<CaseEntity> createCase(@RequestBody CaseEntity caseEntity){
        CaseEntity savedCase =  caseService.createCase(caseEntity);

        return new ResponseEntity<>(savedCase, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseEntity> getCase(@PathVariable("id") Long id){
        CaseEntity caseEntity = caseService.getCase(id);
        return new ResponseEntity<>(caseEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaseEntity> updateCase(@PathVariable("id") Long id, @RequestBody CaseEntity caseEntity){
//        caseEntity.setId(id);
        caseService.updateCase(id, caseEntity);
        return new ResponseEntity<>(caseService.getCase(id), HttpStatus.OK);
//        todoService.updateTodo(todoId, todo);
//        return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCase(@PathVariable Long id){
        caseService.deleteCase(id);
        return new ResponseEntity<>("Case successfully deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CaseEntity>> getAllCases() {
        List<CaseEntity> cases = caseService.getAllCases();
        return new ResponseEntity<>(cases,HttpStatus.OK);
    }

    @GetMapping("/some")
    public ResponseEntity<List<CaseEntity>> getAllCasesByPagination(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "5")Integer pageSize
    ) {
        List<CaseEntity> cases = caseService.getAllCasesByPagination(pageNumber, pageSize);
        return new ResponseEntity<>(cases,HttpStatus.OK);
    }

}
