package fr.univavignon.rodeo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import fr.univavignon.rodeo.api.Animal;
import fr.univavignon.rodeo.api.Specie;

public class SpecieTest extends ISpecieTest{

	@Test
	public void testSpecie(){
		final Specie specie = new Specie("Giraffe", 11);
		Assert.assertEquals("Giraffe", specie.getName());
		Assert.assertEquals(11, specie.getArea());
		final Animal animal = new Animal("Giraffe", 200, true, true, true);
		Assert.assertEquals(true, specie.addAnimal(animal));
		List<Animal> listAnimals = new ArrayList<Animal>();
		listAnimals.add(animal);
		Assert.assertEquals(listAnimals, specie.getAnimals());	
	}
}
