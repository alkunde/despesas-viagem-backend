package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionDTO;
import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionResponseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionsController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public ResponseEntity<SessionResponseDTO> create(
            @RequestBody SessionDTO sessionDTO
    ) {
        Optional<Users> user = repository.findByEmail(sessionDTO.getEmail());

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (user.get().getActive().equals("inactive")) {
            return ResponseEntity.notFound().build();
        }

        if (!user.get().getPassword().equals(sessionDTO.getPassword())) {
            return  ResponseEntity.notFound().build();
        }

        SessionResponseDTO responseDTO = new SessionResponseDTO();
        responseDTO.setId(user.get().getId());
        responseDTO.setName(user.get().getName());
        responseDTO.setEmail(user.get().getEmail());
        responseDTO.setAdmin(user.get().getRole().equals("admin"));
        responseDTO.setActive(user.get().getActive().equals("active"));

        return ResponseEntity.ok(responseDTO);
    }
}
