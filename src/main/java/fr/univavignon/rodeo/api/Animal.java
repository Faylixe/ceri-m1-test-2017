package fr.univavignon.rodeo.api;

public class Animal implements IAnimal {
	
	private String name;
	private int xps;
	private boolean secretAnimal;
	private boolean endangeredAnimal;
	private boolean boss;
	
	public Animal(String name, int xps, boolean s, boolean e, boolean b){
		this.name = name;
		this.xps = xps;
		secretAnimal = s;
		endangeredAnimal = e;
		boss = b;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getXP() {
		return this.xps;
	}

	@Override
	public boolean isSecret() {
		return secretAnimal;
	}

	@Override
	public boolean isEndangered() {
		return endangeredAnimal;
	}

	@Override
	public boolean isBoss() {
		return boss;
	}
}
