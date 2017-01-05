import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTests {

	@Test
	public void initialCountryTest() {		
		Country country = new Country();
		Person person = new Person(country);
		
		assertEquals("Person's initial country", country, person.getCurrentCountry());
		
	}
	@Test
	public void personIsSickTest() {		
		Country country = new Country();
		Person person = new Person(country);
		
		assertEquals("Person's sickness status",false, person.isSick());
		assertEquals("Person's sickness status",true, person.isAlive());
		assertEquals("Person's sickness status",false, person.isInfected());
	}
	@Test
	public void aliveTest() {		
		Country country = new Country();
		Person person = new Person(country);
		person.setAlive(false);		
		assertFalse("Person's initial country", person.isAlive());
		
	}
	@Test
	public void sicknessTest() {		
		Country country = new Country();
		Person person = new Person(country);
		person.setSick(true);
		assertTrue("Person became sick", person.isSick());
		
	}
	
	
	
}
