package com.barclays.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.social.domain.User;
import com.barclays.social.drools.model.SocialModel;
import com.barclays.social.repositories.ScoreRepository;
import com.barclays.social.repositories.UserRepository;


@Service
public class ScoringServiceImpl implements ScoringService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ScoreRepository scoreRepository;

    @Autowired
    public void setScoreRepository(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }
    
	@Override
	public User getScoreById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public SocialModel getScoreByEmail(String email) {
		return scoreRepository.findByEmail(email);
	}

	@Override
	public SocialModel saveScore(SocialModel sm) {
		return scoreRepository.save(sm);
	}
 
}