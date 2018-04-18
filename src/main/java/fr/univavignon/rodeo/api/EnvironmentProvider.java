package fr.univavignon.rodeo.api;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentProvider implements IEnvironmentProvider{

	/*private List<IEnvironment> listAllEvironments;
	private List<String> listAvailbaleEvironments;

	
	public EnvironmentProvider(){
		listAllEvironments = new ArrayList<IEnvironment>();
		listAvailbaleEvironments = new ArrayList<String>();
	}*/

	@Override
	public List<String> getAvailableEnvironments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEnvironment getEnvironment(String name)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Override
	public List<String> getAvailableEnvironments() {
		for(IEnvironment e : listAllEvironments){
			if(e.availability()){
				listAvailbaleEvironments.add(e.getName());
			}
		}
		return listAvailbaleEvironments;
	}

	@Override
	public IEnvironment getEnvironment(String name){
		
		return null;
	}*/
}
