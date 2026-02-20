package org.example.spring_jpa_3.Repository;

import org.example.spring_jpa_3.Entity.Embedded.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
