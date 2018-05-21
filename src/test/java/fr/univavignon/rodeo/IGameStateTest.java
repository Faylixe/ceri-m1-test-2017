package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest{
		
	private static ISpecie specie;

	protected static IGameState getTestInstance(){
		IGameState gs = Mockito.mock(IGameState.class);
		Mockito.when(gs.getProgression()).thenReturn(10);
		specie = ISpecieTest.getTestInstance();
		Mockito.when(gs.getSpecieLevel(specie)).thenReturn(SpecieLevel.NOVICE);
		return gs;
	}
	
	@Test
	public void testSpecieLevel(){
		final IGameState gameS = getTestInstance();
		final SpecieLevel specLev = gameS.getSpecieLevel(specie);
		assertEquals(SpecieLevel.NOVICE, specLev);
	}	
	
	@Test
	public void testProgression(){
		final IGameState gameS = getTestInstance();
		final int progression = gameS.getProgression();
		assertEquals(10, progression);
	}
}

