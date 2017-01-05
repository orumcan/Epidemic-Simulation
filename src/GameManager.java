import java.util.Random;
import java.util.Scanner;


public class GameManager {
	 WorldMap worldMap;
	 PersonController personController;
	 Scanner reader;
	 int dayCounter;
	 Random random;
	 WorldMapView view;
	
	public GameManager(){
		initializeVariables();
		getConstantsFromUser(reader);
		worldMap.createWorldMap();		
		randomlyGiveInfection(worldMap.getPopulation());
		view.initializeView(worldMap.getCountries());
	}
	
	public static void main(String args[]){
		new GameManager();
	}

	private  void initializeVariables() {
		worldMap = WorldMap.Instance();	
		personController = new PersonController();
		reader = new Scanner(System.in);
		random = new Random();
		view = new WorldMapView();
	}

	public void randomlyGiveInfection(Person [] population) {
		int calculatedRate = (int) population.length * Constants.initialSickPeopleRate / 100;
		int counter = 0;
		while (counter < calculatedRate) {			
		    boolean isInfected = random.nextBoolean();
		    int randomPersonID = random.nextInt(Constants.populationSize);
		    if(isInfected && population[randomPersonID].isInfected() == false){
		    	personController.becomeInfected(population[randomPersonID]);		    		    
		    	counter++;
		    }
		}
	}

	private void getConstantsFromUser(Scanner reader) {
		System.out.println("Enter the world size: ");
		Constants.worldSize = reader.nextInt();
		
		System.out.println("Enter the population size: ");
		Constants.populationSize = reader.nextInt();
		
		System.out.println("Enter the initial sick population size: ");
		Constants.initialSickPeopleRate = reader.nextInt();		
	}
}
