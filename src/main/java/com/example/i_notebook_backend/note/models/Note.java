package com.example.i_notebook_backend.note.models;

import com.example.i_notebook_backend.utils.AbstractBaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
public class Note extends AbstractBaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Long userId;

    public Note(String title, String description, Long userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }
}
