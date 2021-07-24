package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufpr.andrekunde.despesasviagem.service.ApprovalService;

@RestController
@RequestMapping("approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService service;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.listAll());
    }
}
