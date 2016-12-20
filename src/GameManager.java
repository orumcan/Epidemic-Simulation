import java.util.Random;
import java.util.Scanner;


public class GameManager {

	public static void main(String[] args) {		
		WorldMap worldMap = new WorldMap();	
		PersonController personController = new PersonController();
		Scanner reader = new Scanner(System.in);
		int dayCounter;
		
		getConstantsFromUser(reader);
		
		worldMap.createWorldMap();

		//randomly give sickness
		int counter = 0;
		
		Person [] population = worldMap.getPopulation();
		while (counter < Constants.initialSickPeopleSize) {
			Random random = new Random();
		    boolean isSick = random.nextBoolean();
		    int randomPersonID = random.nextInt(Constants.populationSize);
		    if(isSick && population[randomPersonID].isSick() == false){
		    	personController.becomeSick(population[randomPersonID]);
		    	counter++;
		    }
		}
		//test
		for (int i = 0; i < population.length; i++) {
			System.out.println(i +"th Person Status: " + population[i].isSick() +
					", CurrentCountry : "+population[i].getCurrentCountry().getName());
		}		
		
		//begin to simulation
		//simulation by clicking next button(?)
		
		
	}

	private static void getConstantsFromUser(Scanner reader) {
		System.out.println("Enter the world size: ");
		Constants.worldSize = reader.nextInt();
		
		System.out.println("Enter the population size: ");
		Constants.populationSize = reader.nextInt();
		
		System.out.println("Enter the initial sick population size: ");
		Constants.initialSickPeopleSize = reader.nextInt();		
	}
}
