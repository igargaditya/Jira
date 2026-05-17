package com.aditya.jira.service;


import com.aditya.jira.entity.Story;
import com.aditya.jira.repository.StoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class StoryService {

    @Autowired
    private StoryRepository storyRepository ;


    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public List<Story> getAllStory() {
        return storyRepository.findAll();
    }

    public Optional<Story> findStoryById(ObjectId id) {
        return storyRepository.findById(id);
    }

    public Story deleteStoryById(ObjectId id) {
        Story story = storyRepository.findById(id).orElse(null);
        if(story!=null){
            storyRepository.deleteById(id);
            return story;
        }
        return null ;

    }

    public Story updateStoryById(ObjectId id, Story newStory) {
        Story oldStory = storyRepository.findById(id).orElse(null);
        if(oldStory!=null){
            if(newStory.getTitle()!=null){
                oldStory.setTitle(newStory.getTitle());
            }
            if(newStory.getDescription()!=null){
                oldStory.setDescription(newStory.getDescription());
            }
           return storyRepository.save(oldStory);
        }
        return null ;
    }
}
