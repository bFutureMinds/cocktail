package com.barclays.social.drools.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocialModel
{
	@Id
	private String email;
	private int age;
	private String ageGroup;
	private String gender;
	private int score=0;
	private String relationshipStatus;
	private String occupation;
	private String homeLocation;
	private String workLocation;
	private String currentLocation;
	private int visitCount;
	private int stressCount;
	private String employer;
	@ElementCollection
	private List<String> listPositive=new ArrayList<String>();
	@ElementCollection
	private List<String> listNegative=new ArrayList<String>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public int getStressCount() {
		return stressCount;
	}

	public void setStressCount(int stressCount) {
		this.stressCount = stressCount;
	}

	public int getMissingInfoCount() {
		return missingInfoCount;
	}

	public void setMissingInfoCount(int missingInfoCount) {
		this.missingInfoCount = missingInfoCount;
	}




	private int missingInfoCount;



	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}



	private boolean hasDomain;
	private boolean hasBlogSite;
	private int noOfYearsInFb;
	private boolean hasOtherSocialConnection;
	private int loginFrequency;
	private boolean doesStatusUpdates;
	private int statusUpdatesFrequency;
	private boolean doesPhotoPosts;
	private int photoPostsFrequency;
	private boolean hasAlumni;
	private boolean hasMutualFriends;
	private boolean hasGroup;
	private int taggedCount;
	private boolean hasBirthdayWishes;
	private boolean isEmailExist;
	//		 private boolean hasGoodHealth;
	private int sickCount;
	private int friendsCount;
	private int counter ;

	public void incrementCounter() {
		counter++;
	}	 

	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getHomeLocation() {
		return homeLocation;
	}
	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public boolean isHasDomain() {
		return hasDomain;
	}
	public void setHasDomain(boolean hasDomain) {
		this.hasDomain = hasDomain;
	}
	public boolean isHasBlogSite() {
		return hasBlogSite;
	}
	public void setHasBlogSite(boolean hasBlogSite) {
		this.hasBlogSite = hasBlogSite;
	}
	public int getNoOfYearsInFb() {
		return noOfYearsInFb;
	}
	public void setNoOfYearsInFb(int noOfYearsInFb) {
		this.noOfYearsInFb = noOfYearsInFb;
	}
	public boolean isHasOtherSocialConnection() {
		return hasOtherSocialConnection;
	}
	public void setHasOtherSocialConnection(boolean hasOtherSocialConnection) {
		this.hasOtherSocialConnection = hasOtherSocialConnection;
	}
	public int getLoginFrequency() {
		return loginFrequency;
	}
	public void setLoginFrequency(int loginFrequency) {
		this.loginFrequency = loginFrequency;
	}
	public boolean isDoesStatusUpdates() {
		return doesStatusUpdates;
	}
	public void setDoesStatusUpdates(boolean doesStatusUpdates) {
		this.doesStatusUpdates = doesStatusUpdates;
	}
	public int getStatusUpdatesFrequency() {
		return statusUpdatesFrequency;
	}
	public void setStatusUpdatesFrequency(int statusUpdatesFrequency) {
		this.statusUpdatesFrequency = statusUpdatesFrequency;
	}
	public boolean isDoesPhotoPosts() {
		return doesPhotoPosts;
	}
	public void setDoesPhotoPosts(boolean doesPhotoPosts) {
		this.doesPhotoPosts = doesPhotoPosts;
	}
	public int getPhotoPostsFrequency() {
		return photoPostsFrequency;
	}
	public void setPhotoPostsFrequency(int photoPostsFrequency) {
		this.photoPostsFrequency = photoPostsFrequency;
	}
	public boolean isHasAlumni() {
		return hasAlumni;
	}
	public void setHasAlumni(boolean hasAlumni) {
		this.hasAlumni = hasAlumni;
	}
	public boolean isHasMutualFriends() {
		return hasMutualFriends;
	}
	public void setHasMutualFriends(boolean hasMutualFriends) {
		this.hasMutualFriends = hasMutualFriends;
	}
	public boolean isHasGroup() {
		return hasGroup;
	}
	public void setHasGroup(boolean hasGroup) {
		this.hasGroup = hasGroup;
	}
	public int getTaggedCount() {
		return taggedCount;
	}
	public void setTaggedCount(int taggedCount) {
		this.taggedCount = taggedCount;
	}

	public boolean isHasBirthdayWishes() {
		return hasBirthdayWishes;
	}
	public void setHasBirthdayWishes(boolean hasBirthdayWishes) {
		this.hasBirthdayWishes = hasBirthdayWishes;
	}
	public boolean isEmailExist() {
		return isEmailExist;
	}
	public void setEmailExist(boolean isEmailExist) {
		this.isEmailExist = isEmailExist;
	}

	public int getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}



	public List<String> getListPositive() {
		return listPositive;
	}

	public void setListPositive(List<String> listPositive) {
		this.listPositive = listPositive;
	}

	public List<String> getListNegative() {
		return listNegative;
	}

	public void setListNegative(List<String> listNegative) {
		this.listNegative = listNegative;
	}

	public int getSickCount() {
		return sickCount;
	}

	public void setSickCount(int sickCount) {
		this.sickCount = sickCount;
	}

	public int getGeographicScore() {
		return geographicScore;
	}

	public void setGeographicScore(int geographicScore) {
		this.geographicScore = geographicScore;
	}

	public int getSychographicScore() {
		return sychographicScore;
	}

	public void setSychographicScore(int sychographicScore) {
		this.sychographicScore = sychographicScore;
	}

	public int getDemographicScore() {
		return demographicScore;
	}

	public void setDemographicScore(int demographicScore) {
		this.demographicScore = demographicScore;
	}

	public void  updateScore(int scr){
		score+=scr;
	}
	int geographicScore;
	int sychographicScore;
	int demographicScore;

	public void  updateGeographicScore(int scr){
		geographicScore+=scr;
	}

	public void  updatePsychographicScore(int scr){
		sychographicScore+=scr;
	}

	public void  updateDemographicScore(int scr){
		demographicScore+=scr;
	}

	public void  updatePositiveMessage(String strMsg){
		listPositive.add(strMsg);
	}

	public void  updateNegativeMessage(String strMsg){
		listNegative.add(strMsg);
	}




	@Override
	public String toString() {
		return "SocialModel [score=" + score + ", geographicScore=" + geographicScore + ", sychographicScore="
				+ sychographicScore + ", demographicScore=" + demographicScore + "]";
	}

	public boolean checkNegativeEmployer(String empList){

		if(empList.indexOf(employer)>0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	String NegativeEmployer;
	public String getNegativeEmployer() {
		return NegativeEmployer;
	}

	public void setNegativeEmployer(String negativeEmployer) {
		NegativeEmployer = negativeEmployer;
	}

}
