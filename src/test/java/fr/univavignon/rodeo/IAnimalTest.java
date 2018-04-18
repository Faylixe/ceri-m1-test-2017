package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IAnimal;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.junit.Test;

/**
 * La classe IAnimalTest sert à tester la classe IAnimal en utilisant les objets mock.
 * 
 * @author Alexandra Moshina
 * @version 1.0
 */
public class IAnimalTest{
	
	protected static IAnimal getTestInstance(){
		IAnimal animal = Mockito.mock(IAnimal.class);
		Mockito.when(animal.getXP()).thenReturn(0);
		Mockito.when(animal.isSecret()).thenReturn(true);
		Mockito.when(animal.isEndangered()).thenReturn(true);
		Mockito.when(animal.isBoss()).thenReturn(true);
		return animal;
	}

	@Test
	public void testXP(){
		final IAnimal animal = getTestInstance();
		final int xp = animal.getXP();
		assertEquals(0, xp);
	}	
	
	@Test
	public void testSecret(){
		final IAnimal animal = getTestInstance();
		final boolean secret = animal.isSecret();
		assertEquals(true, secret);
	}
	
	@Test
	public void testEndangered(){
		final IAnimal animal = getTestInstance();
		final boolean endangered = animal.isEndangered();
		assertEquals(true, endangered);
	}
	
	@Test
	public void testBoss(){
		final IAnimal animal = getTestInstance();
		final boolean boss = animal.isBoss();
		assertEquals(true, boss);
	}
}
