package com.arabadzhiev.lambda;

import java.util.List;
import java.util.stream.Stream;

public class Country {
	
	private String continent;
	private int population;
	
	
	public static int getPopulation(List<Country> countries, String continent) {
		Stream<Country> filteredCountries = countries.stream().filter(
				country -> {return country.getContinent().equals(continent);
		});
		
		Stream<Integer> populations = filteredCountries.map(c -> c.getPopulation());
		
		return populations.reduce(0, (a,b) -> a + b);
		
		
	}
	
	
	public Country(String continent, int population) {
		this.continent = continent;
		this.population = population;
	}
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
}
