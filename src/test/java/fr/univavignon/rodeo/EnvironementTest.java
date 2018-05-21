package fr.univavignon.rodeo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univavignon.rodeo.api.Environment;
import fr.univavignon.rodeo.api.Specie;

public class EnvironementTest extends IEnvironmentTest{
		
	@Test
	public void testSpecie(){
		
		final Environment env = new Environment("Savannah", 12);
		Assert.assertEquals("Savannah", env.getName());
		Assert.assertEquals(12, env.getAreas());
		Assert.assertEquals(true, env.availability());

		final Specie specie = new Specie("Giraffe", 11);
		List<Specie> listSpecies = new ArrayList<Specie>();
		Assert.assertEquals(true, env.addSpecie(specie));
		
		listSpecies.add(specie);
		Assert.assertEquals(listSpecies, env.getSpecies());	
	}
}
