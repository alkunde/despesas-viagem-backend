package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.Company;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPostRequest;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPutRequest;
import ufpr.andrekunde.despesasviagem.service.CompanyService;

@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(companyService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody CompanyPostRequest companyPostRequest) {
        return new ResponseEntity<>(companyService.save(companyPostRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CompanyPutRequest companyPutRequest) {
        companyService.replace(companyPutRequest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
