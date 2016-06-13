package com.barclays.social.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.social.domain.User;
import com.barclays.social.drools.model.SocialModel;
import com.barclays.social.service.ScoringService;

@RestController
public class UserController {

    @Inject
    private ScoringService service;
    
    @RequestMapping("/socialscore/{id}")
    public SocialModel getScore(@PathVariable("id") String id) {
    	
    	System.out.println(service.getScoreById(id+".com"));
        
        return service.getScoreByEmail(id+".com");
    }
}
