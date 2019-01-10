package com.nbu.ap.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javafx.collections.ObservableList;

@Entity
@Table(name = "amusement_park", catalog = "amusement_park")
public class AmusementPark {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column
	@ElementCollection(targetClass = Attraction.class)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "amusement_park_attraction", catalog = "amusement_park", joinColumns = {
			@JoinColumn(name = "amusement_park_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "attraction_id", nullable = false, updatable = false) })
	private Set<Attraction> attractions = new HashSet<Attraction>(0);

	@Column
	@ElementCollection(targetClass = Ticket.class)
	@OneToMany(mappedBy = "amusementPark", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	@ManyToOne(targetEntity = Manager.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@Column(name = "income_treshold")
	private Double incomeTreshold;

	public AmusementPark() {
		super();
	}

	public AmusementPark(String name, Double incomeTreshold, Manager manager, ObservableList<Attraction> items) {
		this.id = 0;
		this.name = name;
		this.incomeTreshold = incomeTreshold;
		this.manager = manager;
		setAttractions(items);
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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Attraction> getAttractions() {
		return this.attractions;
	}

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

	public void setAttractions(ObservableList<Attraction> items) {
		attractions = new HashSet<Attraction>(0);
		for (Attraction attraction : items) {
			attractions.add(attraction);
		}
	}

	public Double getCurrentIncome() {
		double income = 0;
		for (Ticket ticket : tickets) {
			income += ticket.getPrice();
		}
		return income;
	}

	public Double getIncomeTreshold() {
		return incomeTreshold;
	}

	public void setIncomeTreshold(Double incomeTreshold) {
		this.incomeTreshold = incomeTreshold;
	}

	@Override
	public String toString() {
		return name + ", " + manager.getName() + ", " + getCurrentIncome() + " / " + incomeTreshold;
	}

}
