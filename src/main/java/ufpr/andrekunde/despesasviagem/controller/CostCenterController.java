package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.CostCenter;
import ufpr.andrekunde.despesasviagem.service.CostCenterService;

@RestController
@RequestMapping("cost_centers")
@RequiredArgsConstructor
public class CostCenterController {

    private final CostCenterService costCenterService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(costCenterService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CostCenter> findById(@PathVariable Long id) {
        return ResponseEntity.ok(costCenterService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<CostCenter> save(@RequestBody CostCenter costCenter) {
        return new ResponseEntity<>(costCenterService.save(costCenter), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costCenterService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CostCenter costCenter) {
        costCenterService.replace(costCenter);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
