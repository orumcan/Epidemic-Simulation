import static org.junit.Assert.*;

import org.junit.Test;

public class CountryTests {
	
	@Test
	public void neighborTest() {		
		WorldMap.Instance().createWorldMap();
		Country [][] countries = WorldMap.Instance().getCountries();
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries[0].length; j++) {
				
					//North
					if(i > 0)
						assertTrue(countries[i][j].getNeighbors().contains(countries[i - 1][j])); //regular N
					else if(i == 0)
						assertTrue(countries[i][j].getNeighbors().contains(countries[Constants.worldSize - 1][j])); //vertical first is connected to last
					
					//South
					if(i < Constants.worldSize - 1) 
						assertTrue(countries[i][j].getNeighbors().contains(countries[i + 1][j])); //regular S
					else if(i == Constants.worldSize - 1)
						assertTrue(countries[i][j].getNeighbors().contains(countries[0][j])); //vertical last is connected to first
					
					//West
					if(j > 0)
						assertTrue(countries[i][j].getNeighbors().contains(countries[i][j - 1])); //regular W
					else if(j == 0)
						assertTrue(countries[i][j].getNeighbors().contains(countries[i][Constants.worldSize - 1])); //horizontal first is connected to last
					
					//East
					if(j < Constants.worldSize - 1)
						assertTrue(countries[i][j].getNeighbors().contains(countries[i][j + 1])); //regular E		
					else if(j == Constants.worldSize - 1)
						assertTrue(countries[i][j].getNeighbors().contains(countries[i][0])); //horizontal last is connected to first		

					/*
						if(i > 0)
							assertTrue(countries[i][j].getNeighbors().contains(countries[i - 1][j])); ; //north
						if(j > 0)
							assertTrue(countries[i][j].getNeighbors().contains(countries[i][j - 1])); //west
						if(i < Constants.worldSize - 1) 
							assertTrue(countries[i][j].getNeighbors().contains(countries[i + 1][j])); // south
						if(j < Constants.worldSize - 1)
							assertTrue(countries[i][j].getNeighbors().contains(countries[i][j + 1])); //east		
					*/
			}
		}
	}

	@Test
	public void numberOfCitizenSicknessTest(){
		WorldMap.Instance().createWorldMap();
		Country [][] countries = WorldMap.Instance().getCountries();
		int counter = 0;
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries[0].length; j++) {
				for (Person citizen : countries[i][j].getCitizens()) {
					if(citizen.isSick() == true){
						counter++;
					}
				}
			}			
		}
		assertEquals(Constants.initialSickPeopleRate, counter);
	}
	
}
