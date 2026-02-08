package com.demo.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "todos")
public class Todo {

    @Id
    private String id;

    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private boolean isCompleted;
    @Email
    String email;
}

