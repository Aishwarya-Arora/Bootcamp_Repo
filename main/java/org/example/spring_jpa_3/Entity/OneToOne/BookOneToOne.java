package org.example.spring_jpa_3.Entity.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Entity
public class BookOneToOne {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String BookName;

        public BookOneToOne(String book_Name) {
            this.BookName = book_Name;
        }
    }
