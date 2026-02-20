package org.example.spring_jpa_3.Entity.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuthorOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //performing one to one mapping using @OneToOne and giving CascaseType.all so that if there is any change in the parent table then child table will also get affected
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookOneToOne book;
}