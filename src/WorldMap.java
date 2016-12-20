import java.util.ArrayList;
import java.util.Random;

public class WorldMap {
	private Country[][] countryList;
	private int worldSize;
	private Person[] population;
	
	public void createWorldMap(){
		initializeVariables();
		initializeCountries();		
		initializeNeighbors();
		initializePopulation();
	}

	private void initializeVariables() {
		worldSize   = Constants.worldSize;
		countryList = new Country[worldSize][worldSize];
		population  = new Person[Constants.populationSize];
	}

	private void initializeCountries() {
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList[i].length; j++) {				
				countryList[i][j] = new Country(i + "," + j);				
			}
		}
	}
	
	private void initializePopulation(){
		Random random = new Random();		
		for (int i = 0; i < Constants.populationSize; i++) {
			int row = random.nextInt(worldSize);
			int col = random.nextInt(worldSize);
			population[i] = new Person(countryList[row][col]);
			countryList[row][col].addCitizen(population[i]);
		}
	}
	
	private void initializeNeighbors(){
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList.length; j++) {	
				if(i > 0)
					countryList[i][j].addNeighbor(countryList[i - 1][j]); //north
				if(j > 0)
					countryList[i][j].addNeighbor(countryList[i][j - 1]); //west
				if(i < worldSize - 1) 
					countryList[i][j].addNeighbor(countryList[i + 1][j]); // south
				if(j < worldSize - 1)
					countryList[i][j].addNeighbor(countryList[i][j + 1]); //east				
			}			
		}
	}
	
	public Country[][] getCountries(){
		return countryList;
	}
	
	public Person[] getPopulation(){
		return population;
	}
	
	 public boolean getIsThereSickPerson(Country country){
		 return country.getIsThereSickPerson();
	 }
}
