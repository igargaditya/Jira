package com.aditya.jira.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Story {

    private Long id ;
    private String title ;
    private String description;
    private Date createdAt ;

}
