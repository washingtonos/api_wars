package br.com.washington.api.wars.api_wars.document;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Result {
	private String name;
	private String rotationPeriod;
	private String orbitalPeriod;
	private String diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private String surfaceWater;
	private String population;
	private List<String> residents;
	private List<String> films;
	private String created;
	private String edited;
	private String url;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String value) {
		this.name = value;
	}

	@JsonProperty("rotation_period")
	public String getRotationPeriod() {
		return rotationPeriod;
	}

	@JsonProperty("rotation_period")
	public void setRotationPeriod(String value) {
		this.rotationPeriod = value;
	}

	@JsonProperty("orbital_period")
	public String getOrbitalPeriod() {
		return orbitalPeriod;
	}

	@JsonProperty("orbital_period")
	public void setOrbitalPeriod(String value) {
		this.orbitalPeriod = value;
	}

	@JsonProperty("diameter")
	public String getDiameter() {
		return diameter;
	}

	@JsonProperty("diameter")
	public void setDiameter(String value) {
		this.diameter = value;
	}

	@JsonProperty("climate")
	public String getClimate() {
		return climate;
	}

	@JsonProperty("climate")
	public void setClimate(String value) {
		this.climate = value;
	}

	@JsonProperty("gravity")
	public String getGravity() {
		return gravity;
	}

	@JsonProperty("gravity")
	public void setGravity(String value) {
		this.gravity = value;
	}

	@JsonProperty("terrain")
	public String getTerrain() {
		return terrain;
	}

	@JsonProperty("terrain")
	public void setTerrain(String value) {
		this.terrain = value;
	}

	@JsonProperty("surface_water")
	public String getSurfaceWater() {
		return surfaceWater;
	}

	@JsonProperty("surface_water")
	public void setSurfaceWater(String value) {
		this.surfaceWater = value;
	}

	@JsonProperty("population")
	public String getPopulation() {
		return population;
	}

	@JsonProperty("population")
	public void setPopulation(String value) {
		this.population = value;
	}

	@JsonProperty("residents")
	public List<String> getResidents() {
		return residents;
	}

	@JsonProperty("residents")
	public void setResidents(List<String> value) {
		this.residents = value;
	}

	@JsonProperty("films")
	public List<String> getFilms() {
		return films;
	}

	@JsonProperty("films")
	public void setFilms(List<String> value) {
		this.films = value;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String value) {
		this.created = value;
	}

	@JsonProperty("edited")
	public String getEdited() {
		return edited;
	}

	@JsonProperty("edited")
	public void setEdited(String value) {
		this.edited = value;
	}

	@JsonProperty("url")
	public String getURL() {
		return url;
	}

	@JsonProperty("url")
	public void setURL(String value) {
		this.url = value;
	}

	@Override
	public String toString() {
		return "Result [name=" + name + ", rotationPeriod=" + rotationPeriod + ", orbitalPeriod=" + orbitalPeriod
				+ ", diameter=" + diameter + ", climate=" + climate + ", gravity=" + gravity + ", terrain=" + terrain
				+ ", surfaceWater=" + surfaceWater + ", population=" + population + ", residents=" + residents
				+ ", films=" + films + ", created=" + created + ", edited=" + edited + ", url=" + url + "]";
	}

}