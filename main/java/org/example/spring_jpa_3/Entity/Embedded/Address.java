package org.example.spring_jpa_3.Entity.Embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//embeddable is used to mark a class that needs to be embedded
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int StreetNumber;
    private String location;
    private String state;
}
