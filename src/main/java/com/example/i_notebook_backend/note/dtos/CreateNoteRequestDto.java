package com.example.i_notebook_backend.note.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteRequestDto {
    @NotBlank
    @Size(max = 100, min = 3)
    private String title;

    @NotBlank
    @Size(max = 1000, min = 3)
    private String description;
}
