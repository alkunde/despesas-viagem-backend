package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateUserDTO;
import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionResponseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public ResponseEntity<List<Users>> list() {
        List<Users> users = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<SessionResponseDTO> create(@RequestBody CreateUserDTO createUserDTO) {
        Optional<Users> userExistent = repository.findByEmail(createUserDTO.getEmail());

        if (userExistent.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Users user = new Users(
                createUserDTO.getName(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword(),
                "user",
                "active"
        );

        repository.save(user);

        SessionResponseDTO responseDTO = new SessionResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().equals("admin"),
                user.getActive().equals("active")
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
