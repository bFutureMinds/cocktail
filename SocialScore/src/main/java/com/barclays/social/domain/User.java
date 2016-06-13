package com.barclays.social.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class User
{
    @Id
    private String id;

    private Integer score;
    @ElementCollection
    private List<String> acceptList=new ArrayList<>();
    @ElementCollection
    private List<String> referList=new ArrayList<>();
    private Date timestamp;
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

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public List<String> getAcceptList() {
		return acceptList;
	}
	public void setAcceptList(List<String> acceptList) {
		this.acceptList = acceptList;
	}
	public List<String> getReferList() {
		return referList;
	}
	public void setReferList(List<String> referList) {
		this.referList = referList;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    
}
