package org.example.spring_jpa_3.Repository;

import org.example.spring_jpa_3.Entity.OneToMany.AuthorOneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorOneToManyRepo extends JpaRepository<AuthorOneToMany, Long> {
}
