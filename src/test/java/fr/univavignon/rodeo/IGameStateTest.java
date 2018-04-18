package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest{
		
	protected static IGameState getTestInstance(){
		IGameState gs = Mockito.mock(IGameState.class);
		Mockito.when(gs.getProgression()).thenReturn(10);
		return gs;
	}
	
	@Test
	public void testProgression(){
		final IGameState gameS = getTestInstance();
		final int progression = gameS.getProgression();
		assertEquals(10, progression);
	}
	
	
}

