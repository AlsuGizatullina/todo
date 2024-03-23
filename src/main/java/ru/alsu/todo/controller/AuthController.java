package ru.alsu.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alsu.todo.dto.auth.JwtAuthResponseDTO;
import ru.alsu.todo.dto.auth.SignRequestDTO;
import ru.alsu.todo.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public JwtAuthResponseDTO signUp(@RequestBody @Valid SignRequestDTO request) {
        return authService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthResponseDTO signIn(@RequestBody @Valid SignRequestDTO request) {
        return authService.signIn(request);
    }
}
