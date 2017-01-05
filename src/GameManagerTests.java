import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameManagerTests {
	
	@Test
	public void percentOfPopulationSick() {
		int testPopulation = 10;
		int sickCounter = 0;
		GameManager manager = new GameManager();
		Country country = new Country();
		Person [] population = new Person[testPopulation];
		for (int i = 0; i < testPopulation; i++) {
			 population[i] = new Person(country);			 
		} 						
		manager.randomlyGiveInfection(population);
		for (int i = 0; i < testPopulation; i++) {
			if(population[i].isSick() == true){
				sickCounter++;
			}
		}
		int calculatedRate = (int)Constants.initialSickPeopleRate * testPopulation / 100;
		assertEquals(calculatedRate, sickCounter);
	}

}
