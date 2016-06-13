package com.barclays.social.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;

import com.barclays.social.drools.model.SocialModel;


public class Utils 
{
	private static final String  DEFAULT="NA" ;



	public static int calculateAge(String string) throws ParseException
	{
		Calendar cal = Calendar.getInstance();  
		cal.setTime(getDateFromString(string));  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR);  
		if (today.get(Calendar.MONTH) < cal.get(Calendar.MONTH)) {
			age--;  
		} else if (today.get(Calendar.MONTH) == cal.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)) {
			age--;  
		}

		return age;
	}

	public static int calculateAge(Date date) throws ParseException
	{
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR);  
		if (today.get(Calendar.MONTH) < cal.get(Calendar.MONTH)) {
			age--;  
		} else if (today.get(Calendar.MONTH) == cal.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)) {
			age--;  
		}

		return age;
	}

	public static Date getDateFromString(String dob) throws ParseException, java.text.ParseException
	{
		if(dob == null)
			return null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.parse(dob);
	}

	public static void populateEmail(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getEmail())) {
			sm.setEmail(user.getEmail());
		} else {
			//to discuss about default age
			sm.setEmail(DEFAULT);
			sm.incrementCounter();
		}

	}

	public static void populateAge(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getBirthday())) {
			sm.setAge(calculateAge(user.getBirthday())) ;
		} else {
			//to discuss about default age
			sm.setAge(0);
			sm.incrementCounter();
		}

	}
	public static void populateGender(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getGender()))   {
			sm.setGender(user.getGender());
		} else {
			sm.setGender(DEFAULT);
			sm.incrementCounter();
		}
	}
	public static void populateRelationshipStatus(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getRelationshipStatus()))   {
			sm.setRelationshipStatus(user.getRelationshipStatus());
		} else {
			sm.setRelationshipStatus(DEFAULT);
		}
	}
	public static void populateOccupation(SocialModel sm, User user) throws ParseException
	{
		if(user.getWork() != null && user.getWork().size() > 0)
		{		
			sm.setOccupation("Employed");
		}
		else {
			sm.setOccupation("Unemployed");
			sm.incrementCounter();
		}
	}
	public static void populateWorkLocation(SocialModel sm, User user) throws ParseException
	{
		if(user.getWork()  != null  && user.getWork().size() > 0 && user.getWork().get(0).getLocation() != null) {
			sm.setWorkLocation(user.getWork().get(0).getLocation().getCurrentLocation());
		} else {
			sm.setWorkLocation(DEFAULT);
			sm.incrementCounter();

		}
	}
	public static void populateHomeLocation(SocialModel sm, User user) throws ParseException
	{
		if(user.getHometown()  != null  && user.getHometown().getName() != null) {
			sm.setHomeLocation(user.getHometown().getName());
		} else {
			sm.setHomeLocation(DEFAULT);
			sm.incrementCounter();

		}
	}
	public static void populateDomain(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getWebsite())) {
			sm.setHasDomain(true);
		} else {
			sm.setHasDomain(false);
			sm.incrementCounter();

		}
	}
	public static void populateNoOfYearsInFb(SocialModel sm, PagedList<Post> feed) throws ParseException
	{   
		if(feed!=null && feed.size()>0)
		{
			Post firstPost = feed.get(feed.size()-1);
			if(firstPost != null)
			{
				sm.setNoOfYearsInFb(calculateAge(firstPost.getCreatedTime()));
			}
		}
	}

	public static void populateHasOtherSocialConnection(SocialModel sm, User user) throws ParseException
	{
		if(StringUtils.isNotEmpty(user.getWebsite())) {
			sm.setHasDomain(true);
		} else {
			sm.setHasDomain(false);
			sm.incrementCounter();
		}
	}

	public static void populateSickCount(SocialModel sm, PagedList<Post> feed) throws ParseException
	{ 
		int count=0;
		for (Post post : feed) 
		{
			if(post.getMessage()!=null && post.getMessage().contains("feeling sick"))
			{
				count++;
			}
		}
		sm.setSickCount(count);
	}

	public static void populateVisitCount(SocialModel sm, PagedList<Post> feed) throws ParseException
	{ 
		int count=0;
		for (Post post : feed) 
		{
			if(post.getPlace() != null)
			{
				count++;
			}
		}
		sm.setVisitCount(count);
	}

	public static void populateStressCount(SocialModel sm, PagedList<Post> feed) throws ParseException
	{ 
		int count=0;
		for (Post post : feed) 
		{
			String msg = post.getMessage();
			if(post.getMessage()!=null && (msg.contains("worried")||msg.contains("weak")||msg.contains("upset")||msg.contains("terrible")||msg.contains("stressed")||msg.contains("scared")||msg.contains("pained")||msg.contains("pissed")||msg.contains("horrible")||msg.contains("frustrated")||msg.contains("disappointed")||msg.contains("depressed")||msg.contains("broken")||msg.contains("hopeless")))
			{
				count++;
			}
		}
		sm.setStressCount(count);
	}
}
