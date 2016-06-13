package com.barclays.social.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.social.domain.User;
import com.barclays.social.drools.model.SocialModel;

@Repository
public interface ScoreRepository extends CrudRepository<SocialModel, Integer>{
	SocialModel findByEmail(String email);
}
