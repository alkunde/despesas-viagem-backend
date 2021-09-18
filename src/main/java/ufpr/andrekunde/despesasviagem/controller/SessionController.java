package ufpr.andrekunde.despesasviagem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sessions")
public class SessionController {

    @GetMapping
    public ResponseEntity<?> index() {

        return new ResponseEntity<>("Sucesso", HttpStatus.OK);
    }
}
