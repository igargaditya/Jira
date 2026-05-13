package com.aditya.jira.controller;

import com.aditya.jira.entity.Story;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jira")
public class JiraController {
    private Map<Long, Story> storyMap = new HashMap<>();

    @GetMapping("/story")
    public List<Story> getAllStory(){
        return new ArrayList<>(storyMap.values());
    }

    @PostMapping("/story")
    public boolean createStory(@RequestBody Story newStory){
        newStory.setCreatedAt(new Date());
        storyMap.put(newStory.getId(), newStory);
        return true ;
    }

    @GetMapping("/story/id/{myId}")
    public Story getStoryById(@PathVariable Long myId){
        return storyMap.get(myId);
    }
}
