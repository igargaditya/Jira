package com.aditya.jira.controller;

import com.aditya.jira.entity.Story;
import com.aditya.jira.service.StoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/jira")
public class StoryController {

    @Autowired
    private StoryService storyService ;

    @GetMapping("/story")
    public ResponseEntity<List<Story>> getAllStory(){
        List<Story> stories =  storyService.getAllStory();
        if(stories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stories,HttpStatus.OK);
    }

    @PostMapping("/story")
    public ResponseEntity<Story> createStory(@RequestBody Story story){
        try {
            story.setCreatedAt(LocalDateTime.now());
            return new ResponseEntity<>(storyService.createStory(story), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/story/id/{id}")
    public ResponseEntity<Story> getStoryById(@PathVariable ObjectId id){
        Optional<Story> story = storyService.findStoryById(id);
        if(story.isPresent()){
            return new ResponseEntity<>(story.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/story/id/{id}")
    public ResponseEntity<Story> deleteStoryById(@PathVariable ObjectId id){
        Story story = storyService.deleteStoryById(id);
        if(story!=null){
            return new ResponseEntity<>(story, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/story/id/{id}")
    public ResponseEntity<Story> updateStoryById(@PathVariable ObjectId id, @RequestBody Story newStory){
        Story updateStory = storyService.updateStoryById(id,newStory);
        if(updateStory!=null){
            return new ResponseEntity<>(updateStory,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
