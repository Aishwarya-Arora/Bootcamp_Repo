package com.assignment.rest.RestfulAssignment2.controllers;


import com.assignment.rest.RestfulAssignment2.model.UserV1;
import com.assignment.rest.RestfulAssignment2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserVersionController {

    //this is like hitting to different version url
    @GetMapping("/v1/uri")
    public UserV1 userV1Uri() {
        return new UserV1("Aishwarya");
    }
    //hitting /v2/uri for another version
    @GetMapping("/v2/uri")
    public UserV2 userV2Uri() {
        return new UserV2("Aishwarya", "aish@gmail.com");
    }

   //request param is used to give the version in the parameter and based on that version the specific url is hit
    @GetMapping(params = "version=1")
    public UserV1 userV1Param() {
        return new UserV1("Aishwarya");
    }

    @GetMapping(params = "version=2")
    public UserV2 userV2Param() {
        return new UserV2("Aishwarya", "aish@gmail.com");
    }
    //setting a custom header for particular version instead of giving in url
    @GetMapping(headers = "X-API-VERSION=1")
    public UserV1 userV1Header() {
        return new UserV1("Aishwarya");
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public UserV2 userV2Header() {
        return new UserV2("Aishwarya", "aish@gmail.com");
    }

    //mime type is used to give accept key in header to tell which version is this
    @GetMapping(produces = "application/vnd.company.app-v1+json")
    public UserV1 userV1Mime() {
        return new UserV1("Aishwarya");
    }

    @GetMapping(produces = "application/vnd.company.app-v2+json")
    public UserV2 userV2Mime() {
        return new UserV2("Aishwarya", "aish@gmail.com");
    }
}
