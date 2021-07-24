package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.requests.travel.TravelPostRequest;
import ufpr.andrekunde.despesasviagem.service.TravelService;

@RestController
@RequestMapping("travels")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(travelService.listAll());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<?> listByUser(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.listAllByUser(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Travel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Travel> save(@RequestBody TravelPostRequest travelPostRequest) {
        return new ResponseEntity<>(travelService.save(travelPostRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        travelService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody Travel travel) {
        travelService.replace(travel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}/to-approval")
    public ResponseEntity<?> travelToApproval(@PathVariable Long id) {
        Travel travel = travelService.findByIdOrThrowBadRequestException(id);
        travel.setStatus("em aprovacao");

        travelService.replace(travel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
