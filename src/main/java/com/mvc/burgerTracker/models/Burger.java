package com.mvc.burgerTracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Burger_tracker")
public class Burger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="This field can't be empty")
	@Size(min = 3, max = 100, message="Number of input characters must be inbetween 3 to 100")
	private String burgerName;
	
	@NotNull(message="This field can't be empty")
	@Size(min = 3, max = 100, message="Number of input characters must be inbetween 3 to 100")
	private String restaurantName;
	
	@NotNull(message="This field can't be empty")
	@Min(value=1, message="Rate must be from 1 to 5")
	@Max(value=5, message="Rate must be from 1 to 5")
	private Long rating;
	
	@NotNull(message="This field can't be empty")
	@Size(min = 5, max = 400)
	private String notes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updaeAt;
	
	
	public Burger() {}
	public Burger(Integer id
				, String burgerName
				, String restaurantName
				, Long rating
				, String notes) {
		this.id = id;
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}


	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updaeAt = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdaeAt() {
		return updaeAt;
	}
	public void setUpdaeAt(Date updaeAt) {
		this.updaeAt = updaeAt;
	}
	
	
}
