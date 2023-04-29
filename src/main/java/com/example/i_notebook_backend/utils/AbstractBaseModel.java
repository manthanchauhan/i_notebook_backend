package com.example.i_notebook_backend.utils;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class AbstractBaseModel {
    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "active")
    private Boolean active;

    @PrePersist
    protected void onCreate() {
        if (null == this.createdAt) {
            this.createdAt = Instant.now().toEpochMilli();
        }

        if (null == this.active){
            this.active = Boolean.TRUE;
        }

       this.onUpdate();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now().toEpochMilli();
    }
}
