package com.aditya.jira.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Document(collection = "stories")
public class Story {

    @Id
    private ObjectId id ;
    private String title ;
    private String description;
    private LocalDateTime createdAt ;

}
