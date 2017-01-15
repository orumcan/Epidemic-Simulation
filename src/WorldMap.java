import java.util.ArrayList;
import java.util.Random;

public class WorldMap {
	private Country[][] countryList;
	private int worldSize;
	private Person[] population;
	
	private static WorldMap instance;
	
	private WorldMap(){
		
	}
	
	public static WorldMap Instance(){
		if(instance == null){
			instance = new WorldMap();			
		}
		return instance;
	}
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
				countryList[i][j] = new Country();	
				countryList[i][j].setCountryName(i+","+j);
			}
		}
	}
	
	private void initializePopulation(){
		Random random = new Random();		
		for (int i = 0; i < Constants.populationSize; i++) {
			int row = random.nextInt(worldSize);
			int col = random.nextInt(worldSize);
			population[i] = new Person(countryList[row][col]);
			population[i].setID(i);
			countryList[row][col].addCitizen(population[i]);
		}
	}
	
	private void initializeNeighbors(){
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList[i].length; j++) {	
				
				//North
				if(i > 0)
					countryList[i][j].addNeighbor(countryList[i - 1][j]); //regular N
				else if(i == 0)
					countryList[i][j].addNeighbor(countryList[worldSize - 1][j]); //vertical first is connected to last
				
				//South
				if(i < worldSize - 1) 
					countryList[i][j].addNeighbor(countryList[i + 1][j]); //regular S
				else if(i == worldSize - 1)
					countryList[i][j].addNeighbor(countryList[0][j]); //vertical last is connected to first
				
				//West
				if(j > 0)
					countryList[i][j].addNeighbor(countryList[i][j - 1]); //regular W
				else if(j == 0)
					countryList[i][j].addNeighbor(countryList[i][worldSize - 1]); //horizontal first is connected to last
				
				//East
				if(j < worldSize - 1)
					countryList[i][j].addNeighbor(countryList[i][j + 1]); //regular E		
				else if(j == worldSize - 1)
					countryList[i][j].addNeighbor(countryList[i][0]); //horizontal last is connected to first				
				
			}			
		}
	}
	
	public Country[][] getCountries(){
		return countryList;
	}
	
	public Person[] getPopulation(){
		return population;
	}	
}
