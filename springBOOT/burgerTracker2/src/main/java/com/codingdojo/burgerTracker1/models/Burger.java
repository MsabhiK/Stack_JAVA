package com.codingdojo.burgerTracker1.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgertable")
public class Burger {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(min = 3, max = 50, message="Burger name must be at least 3 and max 50 characters.")
	private String burgerName;
	
	@NotNull
    @Size(min = 3, max = 50, message="Restaurant name must be at least 3 and max 50 characters.")
	private String restaurantName;
	
	@NotNull(message="Must not be blank")
    @Max(value=5, message="Rating must be at least 5.")
	//@Min(value=1, message="Rating must be at greater than 0.")
	private int rating;
	
	@NotNull
    @Size(min = 5, max = 200, message="Note must be at least 5 and max 200 characters.")
	private String note;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {}

	public Burger(String burgerName, String restaurantName, int rating) {
		this.burgerName=burgerName;
		this.restaurantName=restaurantName;
		this.rating=rating;
	}
	
	public Burger(String burgerName, String restaurantName, int rating, String note) {
		this.burgerName=burgerName;
		this.restaurantName=restaurantName;
		this.rating=rating;
		this.note=note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
