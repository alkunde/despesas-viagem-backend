package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionDTO;
import br.ufpr.andrekunde.travelexpenses.controllers.dto.SessionResponseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Role;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.RolesRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionsController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @PostMapping
    public ResponseEntity<SessionResponseDTO> create(
            @RequestBody SessionDTO sessionDTO
    ) {
        Optional<Users> user = usersRepository.findByEmail(sessionDTO.getEmail());

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (!user.get().getPassword().equals(sessionDTO.getPassword())) {
            return  ResponseEntity.notFound().build();
        }

        Role role = rolesRepository.findByUser(user.get());

        SessionResponseDTO responseDTO = new SessionResponseDTO();
        responseDTO.setId(user.get().getId());
        responseDTO.setName(user.get().getName());
        responseDTO.setEmail(user.get().getEmail());
        responseDTO.setIsAdmin(role.getRole().equals("admin"));

        return ResponseEntity.ok(responseDTO);
    }
}
