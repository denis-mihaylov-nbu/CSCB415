package com.nbu.ap.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket", catalog = "amusement_park")
public class Ticket {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "amusement_park_id")
	private AmusementPark amusementPark;
	
	@Column(name = "price")
	private Double price;

	public Ticket() {
		super();
	}

	public Ticket(AmusementPark amusementPark, Double price) {
		super();
		this.amusementPark = amusementPark;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public AmusementPark getAmusementPark() {
		return amusementPark;
	}

	public void setAmusementPark(AmusementPark amusementPark) {
		this.amusementPark = amusementPark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

}
