package fr.univavignon.rodeo;

import org.junit.Assert;
import org.junit.Test;

import fr.univavignon.rodeo.api.SpecieLevel;

public class SpecieLevelTest extends ISpecieTest{

	@Test
	public void testLevel(){
		Assert.assertEquals(150, SpecieLevel.CHAMPION.getRequiredXP());
	}
}
