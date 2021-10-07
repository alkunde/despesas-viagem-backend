package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateCostCenterDTO;
import br.ufpr.andrekunde.travelexpenses.entities.CostCenter;
import br.ufpr.andrekunde.travelexpenses.repositories.CostCentersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cost_centers")
public class CostCentersController {

    @Autowired
    private CostCentersRepository repository;

    @GetMapping
    public ResponseEntity<List<CostCenter>> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenter> find(@PathVariable Long id) {
        Optional<CostCenter> costCenter = repository.findById(id);

        if (!costCenter.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(costCenter.get());
    }

    @PostMapping
    public ResponseEntity<CostCenter> create(@RequestBody CreateCostCenterDTO createCostCenterDTO) {
        CostCenter costCenter = new CostCenter(
                createCostCenterDTO.getCode(),
                createCostCenterDTO.getDescription()
        );

        repository.save(costCenter);

        return ResponseEntity.ok(costCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenter> update(
            @PathVariable Long id,
            @RequestBody CreateCostCenterDTO createCostCenterDTO
    ) {
        Optional<CostCenter> costCenter = repository.findById(id);

        if (!costCenter.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        CostCenter newCostCenter = costCenter.get();
        newCostCenter.setCode(createCostCenterDTO.getCode());
        newCostCenter.setDescription(createCostCenterDTO.getDescription());

        repository.save(newCostCenter);

        return ResponseEntity.ok(newCostCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<CostCenter> costCenter = repository.findById(id);

        if (!costCenter.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(costCenter.get());

        return ResponseEntity.ok().build();
    }
}
