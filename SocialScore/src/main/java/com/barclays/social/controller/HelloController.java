package com.barclays.social.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.social.drools.model.SocialModel;
import com.barclays.social.service.ScoringService;
import com.barclays.social.util.Utils;

@Controller
@RequestMapping("/")
public class HelloController {

	private Facebook facebook;
	private ConnectionRepository connectionRepository;

	@Inject
	private ScoringService service;

	@Inject
	public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String helloFacebook(Model model, HttpServletRequest request) throws Exception {

		try {
			Connection<Facebook> con = connectionRepository.findPrimaryConnection(Facebook.class);

			if (con == null) {
				return "redirect:/connect/facebook";
			}

			model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
			PagedList<Post> feed = facebook.feedOperations().getFeed();
			User user = facebook.userOperations().getUserProfile();

			//			user.getFirstName();
			//			user.getMiddleName();
			//			user.getLastName();
			//			user.getGender();//male
			//			user.getBirthday();//12/24/1990
			//			user.getRelationshipStatus();
			//			user.getReligion();
			//			user.getEmail();
			//			user.getWork().get(0);
			//			user.getHometown();
			//			user.getLocation();
			//			user.getWebsite();
			//			user.getBio();
			//			user.getEducation();
			//			user.isVerified();
			//			user.isIdentityVerified();
			//			user.getId();//10204851335602134


			System.out.println(user);
			System.out.println(user.getEmail());
			model.addAttribute("feed", feed);

			connectionRepository.removeConnection(con.getKey());


			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-dtables");

			SocialModel sm=new SocialModel();

			Utils.populateEmail(sm, user);
			Utils.populateAge(sm, user);
			Utils.populateGender(sm, user);
			Utils.populateRelationshipStatus(sm, user);
			Utils.populateOccupation(sm, user);
			Utils.populateWorkLocation(sm, user);
			Utils.populateHomeLocation(sm, user);
			Utils.populateDomain(sm, user);
			Utils.populateNoOfYearsInFb(sm, feed);
			Utils.populateHasOtherSocialConnection(sm, user);
			Utils.populateSickCount(sm, feed);
			Utils.populateVisitCount(sm, feed);
			Utils.populateStressCount(sm, feed);

			model.addAttribute("missingInfoCount", sm.getMissingInfoCount());
			
			kSession.insert(sm);
			kSession.fireAllRules();
			System.out.println(sm);

			model.addAttribute("sm", sm);


			model.addAttribute("profile", "http://graph.facebook.com/"+user.getId()+"/picture?type=large");

			com.barclays.social.domain.User u = new com.barclays.social.domain.User();
			u.setId(user.getEmail());
			u.setScore(sm.getScore());
			u.setTimestamp(new Date());
			service.saveUser(u);
			service.saveScore(sm);
			
			return "hello";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/connect/facebook";
		}
	}



}
