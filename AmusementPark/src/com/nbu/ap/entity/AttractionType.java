package com.nbu.ap.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attraction_type", catalog = "amusement_park")
public class AttractionType {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "min_age")
	private int minAge;

	public AttractionType() {
		super();
	}

	public AttractionType(int id, String name, int minAge) {
		super();
		this.id = id;
		this.name = name;
		this.minAge = minAge;
	}

	public AttractionType(String name, int minAge) {
		super();
		this.id = 0;
		this.name = name;
		this.minAge = minAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	@Override
	public String toString() {
		return name + ", " + minAge;
	}

}
