package org.example.spring_jpa_3;

import org.example.spring_jpa_3.Entity.Embedded.Address;
import org.example.spring_jpa_3.Entity.Embedded.Author;
import org.example.spring_jpa_3.Entity.ManyToMany.AuthorManyToMany;
import org.example.spring_jpa_3.Entity.ManyToMany.BookManyToMany;
import org.example.spring_jpa_3.Entity.OneToMany.AuthorOneToMany;
import org.example.spring_jpa_3.Entity.OneToMany.BookOneToMany;
import org.example.spring_jpa_3.Entity.OneToOne.AuthorOneToOne;
import org.example.spring_jpa_3.Entity.OneToOne.BookOneToOne;
import org.example.spring_jpa_3.Repository.AuthorRepository;
import org.example.spring_jpa_3.Repository.AuthorManyToManyRepo;
import org.example.spring_jpa_3.Repository.AuthorOneToManyRepo;
import org.example.spring_jpa_3.Repository.AuthorOneToOneRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpa3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpa3Application.class, args);
    }


    @Bean
    CommandLineRunner run(
            AuthorRepository authorRepository,
            AuthorOneToOneRepo authorOneToOneRepo,
            AuthorOneToManyRepo authorOneToManyRepo,
            AuthorManyToManyRepo authorManyToManyRepo
    ) {
        return args -> {

            //CREATING A EMBEDDABLE CLASS OBJECT BECAUSE IT IS INDEPENDENT

            Address address = new Address();
            address.setStreetNumber(2);
            address.setLocation("Shahdara");
            address.setState("Delhi");

            //now creating a author class object and passing the address object using setter
            Author author = new Author();
            author.setName("Aishwarya");
            author.setAddress(address);
            author.setSubjects(List.of("Java", "DSA", "CPP"));

            authorRepository.save(author);


            // Q6 OneToOne mapping
            BookOneToOne bookOneToOne = new BookOneToOne();
            bookOneToOne.setBookName("Spring Boot");

            AuthorOneToOne authorOneToOne = new AuthorOneToOne();
            authorOneToOne.setName("Author1");
            authorOneToOne.setBook(bookOneToOne);

            authorOneToOneRepo.save(authorOneToOne);

            // Q7 OneToMany
            BookOneToMany bm1 = new BookOneToMany();
            bm1.setBookName("Hibernate");

            AuthorOneToMany a2 = new AuthorOneToMany();
            a2.setName("Author2");
            a2.setBooks(List.of(bm1));

            authorOneToManyRepo.save(a2);

            // Q8 ManyToMany
            BookManyToMany mm1 = new BookManyToMany();
            mm1.setBookName("Microservices");

            BookManyToMany mm2 = new BookManyToMany();
            mm2.setBookName("Docker");

            AuthorManyToMany a3 = new AuthorManyToMany();
            a3.setName("Author3");
            a3.setBooks(List.of(mm1, mm2));

            authorManyToManyRepo.save(a3);
        };
    }
}
