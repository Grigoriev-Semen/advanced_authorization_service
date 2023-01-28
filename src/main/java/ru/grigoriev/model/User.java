package ru.grigoriev.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @NotEmpty(message = "The user field cannot be empty")
    @Size(min = 2, max = 20, message = "Size must be between 2 and 20")
    private final String user;
    @NotEmpty(message = "The password field cannot be empty")
    @Size(min = 2, max = 20, message = "Size must be between 4 and 20")
    private final String password;
    private List<Authorities> authorities;
}

