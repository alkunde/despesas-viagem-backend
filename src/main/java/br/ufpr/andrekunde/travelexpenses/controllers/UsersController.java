package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateUserDTO;
import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionResponseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Role;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.RolesRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Users> list() {
        return usersRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<SessionResponseDTO> create(@RequestBody CreateUserDTO createUserDTO) {
        Optional<Users> userExistent = usersRepository.findByEmail(createUserDTO.getEmail());

        if (userExistent.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Users user = new Users(
                createUserDTO.getName(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword()
        );

        usersRepository.save(user);

        Role role = new Role(user, "user");

        rolesRepository.save(role);

        SessionResponseDTO responseDTO = new SessionResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                role.getRole().equals("admin")
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
