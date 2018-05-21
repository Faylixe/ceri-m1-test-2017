package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.Animal;
import org.junit.Assert;

import org.junit.Test;

public class AnimalTest extends IAnimalTest{

	@Test
	public void testAnimalOnCreate(){
		final Animal animal = new Animal("Giraffe", 200, true, true, true);
		Assert.assertNotNull(animal);
		Assert.assertEquals(200, animal.getXP());
		Assert.assertEquals("Giraffe", animal.getName());
		Assert.assertTrue(animal.isBoss());
		Assert.assertTrue(animal.isEndangered());
		Assert.assertTrue(animal.isSecret());
	}
}   
