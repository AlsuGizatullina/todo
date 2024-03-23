package ru.alsu.todo.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignRequestDTO {
    @Size(min = 5, max = 20, message = "Имя пользователя должно быть не меньше 5 и не больше 20 символов")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @Size(min = 8, max = 50, message = "Пароль должен быть не меньше 5 и не больше 50 символов")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
