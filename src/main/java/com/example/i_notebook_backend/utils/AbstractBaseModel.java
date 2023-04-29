package com.example.i_notebook_backend.utils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class AbstractBaseModel {
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "active")
    private Boolean active;

    @PrePersist
    protected void onCreate() {
        if (null == this.createdAt) {
            this.createdAt = Timestamp.from(Instant.now());
        }

        if (null == this.active){
            this.active = Boolean.TRUE;
        }

       this.onUpdate();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}
