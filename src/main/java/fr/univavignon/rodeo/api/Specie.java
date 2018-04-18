package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;

public class Specie implements ISpecie{
	
	private String name;
	private int area;
	private List<IAnimal> listAnimals;
	
	public Specie(String name, int area){
		this.name = name;
		this.area = area;
		listAnimals = new ArrayList<IAnimal>();
	}
	
	public void addAnimal(Animal a){
		if(a != null) {
			listAnimals.add(a);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getArea() {
		return this.area;
	}

	@Override
	public List<IAnimal> getAnimals() {
		return this.listAnimals;
	}

}
