package org.example.spring_jpa_3.Repository;

import org.example.spring_jpa_3.Entity.OneToOne.AuthorOneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorOneToOneRepo extends JpaRepository<AuthorOneToOne, Long> {
}
