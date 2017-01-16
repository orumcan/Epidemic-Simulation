import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


public class GameManager {
	
	WorldMap worldMap;
	Scanner reader;
	Random random;
	
	public static int dayCounter;
	private Person [] population;
	
	private ActionListener actionListener;
	
	public GameManager(){
		initializeVariables();
		getConstantsFromUser(reader);
		worldMap.createWorldMap();
		
		population = WorldMap.Instance().getPopulation();
		
		giveRandomInitialStatus(Constants.initialInfectedPeopleRate, Status.Infected, false);
		giveRandomInitialStatus(Constants.initialImmunePeopleRate, Status.Immune, false);
		giveRandomInitialStatus(Constants.initialDoctorRate, Status.Healthy, true);
		
		WorldMapView.Instance().initializeView(worldMap.getCountries(), actionListener);
	}

	public static void main(String args[]){
		new GameManager();
	}

	private  void initializeVariables() {
		dayCounter 		= 1;
		worldMap		= WorldMap.Instance();			
		reader			= new Scanner(System.in);
		random			= new Random();		
		actionListener 	= new ActionListener() {	    
			@Override
			public void actionPerformed(ActionEvent e) {				
				simulate();				
			}
		};		 
	}

	public void giveRandomInitialStatus(int popRate, Status status, boolean isDoctor) {
		
		int calculatedRate = (int) population.length * popRate / 100;
		int counter = 0;
		while (counter < calculatedRate) {			
		    int randomPersonID = random.nextInt(Constants.populationSize);	
		    Person selectedPerson = population[randomPersonID];
		    
		    if(selectedPerson.getStatus() == Status.Healthy){		    	
		    	PersonController.Instance().changeStatus(selectedPerson, status);
		    	
		    	if(isDoctor){
		    		selectedPerson.setDoctor(true);		    		
		    	}
		    	
		    	counter++;
		    }
		}
	}


	private void getConstantsFromUser(Scanner reader) {
		System.out.println("Enter the world size: ");
		Constants.worldSize = reader.nextInt();
		
		System.out.println("Enter the population size: ");
		Constants.populationSize = reader.nextInt();
		
		System.out.println("Enter the initial immune population size percent: ");
		Constants.initialImmunePeopleRate = reader.nextInt();
		
		System.out.println("Enter the initial infected population size percent: ");
		Constants.initialInfectedPeopleRate = reader.nextInt();
		
		System.out.println("Enter the initial doctor population size percent: ");
		Constants.initialDoctorRate = reader.nextInt();
		
		System.out.println("Enter the vaccinatable person number per doctor/day: ");
		Constants.vaccinateNumber = reader.nextInt();
		
		System.out.println("Enter the airway option probability: ");		
		Constants.airwayProbability = reader.nextInt();
		
		System.out.println("Would you like to see the console? (0 for no)");
		Constants.showConsole = reader.nextInt();
			
	}
	
	private void simulate(){
		EventFiringSource.Instance().startDayEvent();		
		WorldMapView.Instance().updateGUI();
		dayCounter++;
	}
	
}
