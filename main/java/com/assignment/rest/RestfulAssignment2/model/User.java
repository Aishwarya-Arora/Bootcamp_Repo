package com.assignment.rest.RestfulAssignment2.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

//it is telling that the root element of the jackson should be user
@JacksonXmlRootElement(localName = "user")
@Schema(description = "User details")
@Getter
@Setter
@JsonFilter("UserFilter")
public class User {


    //adding the description and passing the example value
    @Schema(description = "Unique ID of the user", example = "1")
    private int id;
    //adding the description and passing the example value
    @Schema(description = "Name of the user", example = "Aishwarya")
    private String name;
    //adding the description and passing the example value
    @Schema(description = "Email address", example = "aish@example.com")
    private String email;
    //Ignoring the value of password like we can send it in request body but in response we are ignoring

    //directly adding it to the user class hence it is static filtering
    @JsonIgnore
    private String password;
    public User() {}

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(int id, String name, String email,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
    }
}