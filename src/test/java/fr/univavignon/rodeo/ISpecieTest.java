package fr.univavignon.rodeo;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.junit.Test;

/**
 * La classe ISpecieTest sert à tester la classe ISpecie en utilisant les objets mock.
 * 
 * @author Alexandra Moshina
 * @version 1.0
 */
public class ISpecieTest{
	
	static List<IAnimal> animals;
	 	
	protected static ISpecie getTestInstance(){
		animals  = new ArrayList<IAnimal>();
		final IAnimal animal1 = IAnimalTest.getTestInstance();
		final IAnimal animal2 = IAnimalTest.getTestInstance();
		final IAnimal animal3 = IAnimalTest.getTestInstance();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		
		ISpecie specie = Mockito.mock(ISpecie.class);
		Mockito.when(specie.getArea()).thenReturn(10);
		Mockito.when(specie.getAnimals()).thenReturn(animals);
		return specie;
	}
	
	@Test
	public void testArea(){
		final ISpecie specie = getTestInstance();
		final int area = specie.getArea();
		assertEquals(10, area);
	}	
	
	@Test
	public void testAnimals(){
		final ISpecie specie = getTestInstance();
		final List<IAnimal> listA = specie.getAnimals();
		assertEquals(animals, listA);
	}
}

