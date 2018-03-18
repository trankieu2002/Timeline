package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="treatment")
public class Treatment implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int capacity;
	private String specialty;
	private int time;
	private int timeplus;
	
	public Treatment(){}
	
	public Treatment(String name, int capacity, String specialty, int time, int timeplus) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.specialty = specialty;
		this.time = time;
		this.timeplus = timeplus;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTimeplus() {
		return timeplus;
	}
	public void setTimeplus(int timeplus) {
		this.timeplus = timeplus;
	}
	
	@Override
	public String toString() {
		return "Treatment [id=" + id + ", name=" + name + ", capacity=" + capacity + ", specialty=" + specialty
				+ ", time=" + time + ", timeplus=" + timeplus + "]";
	}

}
