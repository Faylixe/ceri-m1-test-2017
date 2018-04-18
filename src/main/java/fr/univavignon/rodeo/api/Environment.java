package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;

public class Environment implements IEnvironment{
	private String name;
	private int areas;
	private List<ISpecie> listSpecies;
	
	public Environment(String name, int areas){
		this.name = name;
		this.areas = areas;
		listSpecies = new ArrayList<ISpecie>();
	}
	
	public void addAnimal(Specie s){
		if(s != null) {
			listSpecies.add(s);
		}
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
	public List<ISpecie> getSpecies() {
		return this.listSpecies;
	}
}
