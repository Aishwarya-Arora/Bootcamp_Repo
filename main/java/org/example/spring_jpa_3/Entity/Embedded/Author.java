package org.example.spring_jpa_3.Entity.Embedded;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    //embedded is used to embed into a class
    @Embedded
    private Address address;
    //it is used to create a collection  in different table that is dependent on author
    @ElementCollection
    private List<String> subjects;

    public Author(String name, Address address, List<String> subjects) {
        this.name = name;
        this.address = address;
        this.subjects = subjects;
    }
}
