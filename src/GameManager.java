import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


public class GameManager {
	 WorldMap worldMap;
	 Scanner reader;
	 public static int dayCounter;
	 Random random;
	private ActionListener actionListener;
	
	public GameManager(){
		initializeVariables();
		getConstantsFromUser(reader);
		worldMap.createWorldMap();		
		randomlyGiveInfection(worldMap.getPopulation());
		WorldMapView.Instance().initializeView(worldMap.getCountries(), actionListener);
	}
	
	public static void main(String args[]){
		new GameManager();
	}

	private  void initializeVariables() {
		dayCounter = 1;
		worldMap = WorldMap.Instance();			
		reader = new Scanner(System.in);
		random = new Random();		
		
		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				simulate();
				
			}
		};		 
	}

	public void randomlyGiveInfection(Person [] population) {
		int calculatedRate = (int) population.length * Constants.initialSickPeopleRate / 100;
		int counter = 0;
		
		
		while (counter < calculatedRate) {			
		    boolean isInfected = random.nextBoolean();
		    int randomPersonID = random.nextInt(Constants.populationSize);
		    if(isInfected && population[randomPersonID].isInfected() == false){
		    	PersonController.Instance().becomeInfected(population[randomPersonID]);		    		    
		    	counter++;
		    }
		}
	}

	private void getConstantsFromUser(Scanner reader) {
		System.out.println("Enter the world size: ");
		Constants.worldSize = reader.nextInt();
		
		System.out.println("Enter the population size: ");
		Constants.populationSize = reader.nextInt();
		
		System.out.println("Enter the initial sick population size percent: ");
		Constants.initialSickPeopleRate = reader.nextInt();
		
		System.out.println("Enter the airway option probability: ");
		Constants.airwayProbability = reader.nextInt();
	}
	
	private void simulate(){
		System.out.println(dayCounter);		
		EventFiringSource.Instance().startDayEvent();				
		WorldMapView.Instance().updateGUI();
		dayCounter++;
	}
	
}
