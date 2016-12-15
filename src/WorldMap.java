import java.util.Random;

public class WorldMap {
	private Country[][] countryList;
	int worldSize; //to be implemented as a Constant
	private Person[] population;
	
	public void createWorldMap(){
		worldSize = Constants.worldSize;
		countryList = new Country[worldSize][worldSize];
		population = new Person[Constants.populationSize];
		initializeCountries();		
		initializeNeighbors();
		initializePopulation();
	}

	private void initializeCountries() {
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList[i].length; j++) {
				countryList[i][j] = new Country();
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
		Country [] neighbors = new Country[4];
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList.length; j++) {				
				if(j > 0) {
					neighbors[3] = countryList[i][j - 1]; //west					
				}
				else {
					neighbors[3] = null;
				}
				if(i > 0) {
					neighbors[0] = countryList[i - 1][j]; //north				
				}
				else {
					neighbors[0] = null;
				}
				if(j < worldSize - 1) {
					neighbors[1] = countryList[i][j + 1]; //east					
				}
				else {
					neighbors[1] = null;
				}
				if(i < worldSize - 1) {				
					neighbors[2] = countryList[i + 1][j]; // south					
				}
				else {
					neighbors[2] = null;
				}							
				setNeighborList(countryList[i][j], neighbors);
			}
			
		}
	}

	public void setNeighborList(Country country, Country[] neighbors){
		country.setNeighborList(neighbors);
	}
	
	public Country[][] getCountries(){
		return countryList;
	}
	
	 public boolean getIsThereSickPerson(Country country){
		 return country.getIsThereSickPerson();
	 }
}
