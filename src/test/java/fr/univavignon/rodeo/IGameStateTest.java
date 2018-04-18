package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest{
	
	static ISpecie is;
	static SpecieLevel sl;
	
	protected static IGameState getTestInstance(){
		IGameState gs = Mockito.mock(IGameState.class);
		Mockito.when(gs.getProgression()).thenReturn(10);
		is = ISpecieTest.getTestInstance();
		//sl = Mockito.mock(SpecieLevel.class);
		//Mockito.when(gs.getSpecieLevel(is)).thenReturn(sl);
		return gs;
	}
		
	/*@Test
	public void testSpecieLevel(){
		final IGameState gameS = getTestInstance();
		final SpecieLevel progression = gameS.getSpecieLevel(is);
		assertEquals(is, progression);
	}	*/	
	
	@Test
	public void testProgression(){
		final IGameState gameS = getTestInstance();
		final int progression = gameS.getProgression();
		assertEquals(10, progression);
	}
	
	
}

