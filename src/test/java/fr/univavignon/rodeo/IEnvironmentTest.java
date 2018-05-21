package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

/**
 * La classe IEnvironmentTest sert à tester la classe IEnvironment en utilisant les objets mock.
 * 
 * @author Alexandra Moshina
 * @version 1.0
 */
public class IEnvironmentTest{
	
	private static List<ISpecie> species;
	
	protected static IEnvironment getTestInstance(){	
		species  = new ArrayList<ISpecie>();
		final ISpecie s1 = ISpecieTest.getTestInstance();
		final ISpecie s2 = ISpecieTest.getTestInstance();
		final ISpecie s3 = ISpecieTest.getTestInstance();
		species.add(s1);
		species.add(s2);
		species.add(s3);
		
		IEnvironment environment = Mockito.mock(IEnvironment.class);
		Mockito.when(environment.getAreas()).thenReturn(10);
		Mockito.when(environment.getSpecies()).thenReturn(species);
		return environment;
	}
	
	@Test
	public void testAreas(){
		final IEnvironment environment = getTestInstance();
		final int areas = environment.getAreas();
		assertEquals(10, areas);
	}	
	
	@Test
	public void testSpecies(){
		final IEnvironment environment = getTestInstance();
		final List<ISpecie> listA = environment.getSpecies();
		assertEquals(species, listA);
	}	
}
