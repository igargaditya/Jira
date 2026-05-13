package com.aditya.jira.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Stories {

    private Long id ;
    private String title ;
    private String description ;
    private Date createdAt ;

}
