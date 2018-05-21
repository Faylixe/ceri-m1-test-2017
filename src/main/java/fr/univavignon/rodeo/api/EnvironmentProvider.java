package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentProvider implements IEnvironmentProvider{
	
	private List<IEnvironment> listEnv = new ArrayList<IEnvironment>();

	public boolean addEnv(Environment a){
		listEnv.add(a);
		return true;
	}
	
	@Override
	public List<String> getAvailableEnvironments() {
		List<String> listEnvNames = new ArrayList<String>();
		
		for(IEnvironment env : listEnv){
			if(env.availability()){
				listEnvNames.add(env.getName());
			}
		}		
		return listEnvNames;
	}

	@Override
	public IEnvironment getEnvironment(String name)
			throws IllegalArgumentException {
		try{
			for(IEnvironment env : listEnv){
				if(env.getName().equals(name)){
					return env;
				}	
			}
		}catch(IllegalArgumentException e){
			System.out.println("Illegal arguement exception");
			return null;
		}
		return null;
	}
	
}
