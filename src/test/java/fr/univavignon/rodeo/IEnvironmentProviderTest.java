package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

/**
 * La classe IEnvironmentProviderTest sert à tester la classe IEnvironmentProvider en utilisant les objets mock.
 * 
 * @author Alexandra Moshina
 * @version 1.0
 */
public class IEnvironmentProviderTest{
	
	private static List<String> environments;
	private static IEnvironment ie;
	
	protected IEnvironmentProvider getTestInstance(){
		environments  = new ArrayList<String>();
		environments.add("env");
		environments.add("env2");
		environments.add("env3");
		
		ie = IEnvironmentTest.getTestInstance();
		
		IEnvironmentProvider environmentProvider = Mockito.mock(IEnvironmentProvider.class);
		Mockito.when(environmentProvider.getEnvironment("env")).thenReturn(ie);
		Mockito.when(environmentProvider.getAvailableEnvironments()).thenReturn(environments);
		return environmentProvider;
	}
	
	@Test
	public void testEnvironment(){
		final IEnvironmentProvider environmentp = getTestInstance();
		final IEnvironment env = environmentp.getEnvironment("env");
		assertEquals(ie, env);
	}	
	
	@Test
	public void testSpecies(){
		final IEnvironmentProvider environmentp = getTestInstance();
		final List<String> listA = environmentp.getAvailableEnvironments();
		assertEquals(environments, listA);
	}	
	
}
