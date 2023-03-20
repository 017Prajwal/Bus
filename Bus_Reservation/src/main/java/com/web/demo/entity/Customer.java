package com.web.demo.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;
@Table(name="Bus_Reservation")
@Entity
@ToString
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trip_id;
	private String name;
	private int age;
	private String From_Location;
	private String To_Location;
	private int Payment;
	@CreationTimestamp
	@Column(name="created_at")
	private Date created_at;
	@UpdateTimestamp
	@Column(name="Updated_At")
	private Date updated_at;
	
	public Long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFrom_Location() {
		return From_Location;
	}
	public void setFrom_Location(String from_Location) {
		From_Location = from_Location;
	}
	public String getTo_Location() {
		return To_Location;
	}
	public void setTo_Location(String to_Location) {
		To_Location = to_Location;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public int getPayment() {
		return Payment;
	}
	public void setPayment(int payment) {
		Payment = payment;
	}
	
	

}
