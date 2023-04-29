package com.example.i_notebook_backend.user.repositories;

import com.example.i_notebook_backend.user.models.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    // https://www.baeldung.com/spring-data-criteria-queries
    static Specification<User> hasEmail(String email){
        return (user, cq, cb) -> cb.equal(user.get("email"), email);
    }
}
