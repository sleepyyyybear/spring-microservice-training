package com.brownfield.pss.baggage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Baggage {
    @Id
    @GeneratedValue
	long id;
    
	double weight;
	
	@Temporal(TemporalType.TIMESTAMP)
    Date createDate;
    long checkinId;
 
    public Baggage(){
    	
    }

	public Baggage(double weight, Date createDate, long checkinId) {
		this.weight = weight;
		this.createDate = createDate;
		this.checkinId = checkinId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}

	@Override
	public String toString() {
		return "Baggage [id=" + id + ", weight=" + weight + ", createDate=" + createDate + ", checkinId=" + checkinId
				+ "]";
	}

}
