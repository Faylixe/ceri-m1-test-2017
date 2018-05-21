package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;

public class Environment implements IEnvironment{
	private String name;
	private int areas;
	private List<ISpecie> listSpecies;
	private boolean available;
	
	public Environment(String name, int areas){
		this.name = name;
		this.areas = areas;
		listSpecies = new ArrayList<ISpecie>();
		available = true;
	}
	
	public boolean addSpecie(Specie s){
			listSpecies.add(s);
			return true;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getAreas() {
		return this.areas;
	}
	@Override
	public boolean availability() {
		return this.available;
	}

	@Override
	public List<ISpecie> getSpecies() {
		return this.listSpecies;
	}
}
