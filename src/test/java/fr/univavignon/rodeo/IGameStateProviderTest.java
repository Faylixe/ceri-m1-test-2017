package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

/**
 * La classe IGameStateProviderTest sert à tester la classe IGameStateProvider en utilisant les objets mock.
 * 
 * @author Alexandra Moshina
 * @version 1.0
 */
public class IGameStateProviderTest{
	
	static IGameState gs;
	
	protected static IGameStateProvider getTestInstance(){
		IGameStateProvider gameStateProvider = Mockito.mock(IGameStateProvider.class);
		gs = IGameStateTest.getTestInstance();
		Mockito.when(gameStateProvider.get("gsp")).thenReturn(gs);	
		return gameStateProvider;
	}

	@Test
	public void testGet(){
		final IGameStateProvider gsprov = getTestInstance();
		final IGameState g = gsprov.get("gsp");
		assertEquals(gs, g);
	}		
}
