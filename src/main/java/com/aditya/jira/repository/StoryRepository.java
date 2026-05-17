package com.aditya.jira.repository;

import com.aditya.jira.entity.Story;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, ObjectId> {


}
