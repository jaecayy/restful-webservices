package com.rest.webservices.restfulwebservices.versioning;


import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //URL Type of Versioning
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionofPerson(){
        return new PersonV1("Jitesh Khatri");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionofPerson(){
        return new PersonV2(new Name("Jitesh","Khatri"));
    }

    //Request Params type of Versioning

//    @GetMapping("/person/{version}")
//    public PersonV1 getFirstversionOfPersonRequestParameter(){
//        return new PersonV1("Jitesh Khatri");
//    }
//    @GetMapping("/person", params="version=2")
//    public PersonV2 getSecondversionOfPersonRequestParameter(){
//        return new PersonV2(new Name("Jitesh","Khatri"));
//    }

    //Header Type Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeaders(){
        return new PersonV1("Jitesh Khatri");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeaders(){
        return new PersonV2(new Name("JItesh","Khatri"));
    }

    // Media Type Versioning
    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAceeptHeader(){
        return new PersonV1("Jitesh Khatri");
    }

    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAceeptHeader(){
        return new PersonV2(new Name("Jitesh","Khatri"));
    }
}
