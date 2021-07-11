package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ufpr.andrekunde.despesasviagem.domain.Session;
import ufpr.andrekunde.despesasviagem.domain.User;
import ufpr.andrekunde.despesasviagem.repository.UserRepository;
import ufpr.andrekunde.despesasviagem.requests.session.SessionPostRequest;
import ufpr.andrekunde.despesasviagem.service.UserService;

@RestController
@RequestMapping("sessions")
@RequiredArgsConstructor
public class SessionController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SessionPostRequest sessionPostRequest) {

        User user = userService.find(sessionPostRequest.getEmail());

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }

        Session session = new Session();
        session.setUser(user);
        session.setToken("Teste");

        return new ResponseEntity<>(session, HttpStatus.OK);
    }
}
