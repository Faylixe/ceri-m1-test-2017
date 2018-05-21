package fr.univavignon.rodeo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univavignon.rodeo.api.Environment;
import fr.univavignon.rodeo.api.EnvironmentProvider;

public class EnvironmenetProviderTest {
	
	@Test
	public void testEnvProv() throws IllegalArgumentException{
		final EnvironmentProvider envPr = new EnvironmentProvider();
		Assert.assertNotNull(envPr);
		final Environment env = new Environment("Savannah", 12);
		Assert.assertNotNull(env);
		Assert.assertEquals(true, envPr.addEnv(env));
		List<String> listEnvs = new ArrayList<String>();
		listEnvs.add(env.getName());
		Assert.assertEquals(listEnvs, envPr.getAvailableEnvironments());	
		
		Assert.assertEquals(env, envPr.getEnvironment("Savannah"));
		Assert.assertEquals(null, envPr.getEnvironment("Sa"));

	}

}
