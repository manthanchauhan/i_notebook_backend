package com.example.i_notebook_backend.note.repositories;

import com.example.i_notebook_backend.note.models.Note;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoteRepository extends JpaRepository<Note, Long>, JpaSpecificationExecutor<Note> {
    static Specification<Note> hasUserId(Long userId){
        return (note, cq, cb) -> cb.equal(note.get("userId"), userId);
    }
}
