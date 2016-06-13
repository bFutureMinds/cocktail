package com.barclays.social.service;

import com.barclays.social.domain.User;
import com.barclays.social.drools.model.SocialModel;

public interface ScoringService
{
	User getScoreById(String id);

	User saveUser(User user);
	
	SocialModel getScoreByEmail(String email);

	SocialModel saveScore(SocialModel sm);
}

