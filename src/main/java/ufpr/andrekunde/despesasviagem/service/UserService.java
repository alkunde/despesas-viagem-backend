package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufpr.andrekunde.despesasviagem.domain.User;
import ufpr.andrekunde.despesasviagem.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByIdOrThrowBadRequestException(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Expense not found")
                );
    }

    public User find(String email) {
        return userRepository.findByEmail(email);
    }
}
