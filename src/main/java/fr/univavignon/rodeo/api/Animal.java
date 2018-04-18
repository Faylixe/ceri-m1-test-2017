package fr.univavignon.rodeo.api;


public class Animal implements IAnimal {
	
	String name;
	int xps;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEndangered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBoss() {
		// TODO Auto-generated method stub
		return false;
	}

}
