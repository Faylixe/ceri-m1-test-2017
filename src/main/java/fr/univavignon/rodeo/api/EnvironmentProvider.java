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
			if(name.equals(null)){
				throw new IllegalArgumentException("Illegal argument");
			}
		
			for(IEnvironment env : listEnv){
				if(env.getName().equals(name)){
					return env;
				}	
			}
		return null;
	}
	
}
