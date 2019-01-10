package com.nbu.ap.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attraction", catalog = "amusement_park")
public class Attraction {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = AttractionType.class, fetch = FetchType.EAGER)
	@JoinColumn(name="attraction_type_id")
	private AttractionType attractionType;

	public Attraction() {
		super();
	}

	public Attraction(String name, AttractionType attractionType) {
		super();
		this.id = 0;
		this.name = name;
		this.attractionType = attractionType;
	}

	@Override
	public String toString() {
		return name + ", " + attractionType;
	}

	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Attraction) {
			isEqual = o.toString().equals(this.toString());
		}
		return isEqual;
	}

	
	
}
