import java.util.ArrayList;
import java.util.Random;

public class PersonController implements DayCountInfertace{	
		
	private static PersonController instance;
	Random random = new Random();
	private boolean isAirways;
	
	private PersonController(){
	
	}
	
	public static PersonController Instance(){
		if(instance == null){
			instance = new PersonController();			
		}
		return instance;
	}
	
	public void changeStatus(Person person, Status status) {
		
		person.setStatus(status);
		
		switch (status) {

		case Infected:
			person.getCurrentCountry().addInfectedPerson(person);
			break;
			
		case Sick:
			person.getCurrentCountry().addSickPerson(person);
			break;
			
		case Immune:
			person.getCurrentCountry().addSImmunePerson(person);
			break;			
		default:
			break;
		}
	}
		
	public void move(Person person){
		isAirways = random.nextInt(100) < Constants.airwayProbability;	
		
		if(isAirways && person.getMoveDay() <= 0){	
			Country selectedCountry = randomlySelectCountry();			
			updateCountry(person, selectedCountry);
			person.setMoveDay(decideMoveDay());	
		}
			
		else if(person.getMoveDay() <= 0){
			ArrayList<Country> possibleNeighbors = new ArrayList<Country>();
			for (Country neighbor : person.getCurrentCountry().getNeighbors()) {
				if(neighbor.getSickCitizens().size() == 0 && neighbor.getDeadPeople().size() == 0){
					possibleNeighbors.add(neighbor);
				}
			}
			
			if(possibleNeighbors.size() <= 0){				
				person.setMoveDay(decideMoveDay());
			} 
			else if(possibleNeighbors.size() != 0){
				int index = random.nextInt(possibleNeighbors.size());
				Country selectedCountry = possibleNeighbors.get(index);			
				updateCountry(person, selectedCountry);									
				person.setMoveDay(decideMoveDay());						 
			}										
		}		
	}

	private void infectedByMove(Person person) {
		boolean infectionChance = (random.nextInt(100) < 40);
		Country country = person.getCurrentCountry();
		if((country.getInfectedCitizens().size() != 0 
				|| country.getDeadPeople().size() != 0 
				|| country.getSickCitizens().size() != 0)
				&& infectionChance && (person.getStatus() == Status.Healthy)){
			changeStatus(person, Status.Infected);
		}
	}
	
	public void vaccinate(Person person){
		
		if(person.getDoctor() && (person.getStatus() == Status.Healthy || person.getStatus() == Status.Immune)){			
			ArrayList<Person> currentCountryPop = person.getCurrentCountry().getCitizens();			
			ArrayList<Person> healthyPeople = new ArrayList<Person>();
			
			for (Person healthyPerson : currentCountryPop) {
				if(healthyPerson.getStatus() == Status.Healthy){
					healthyPeople.add(healthyPerson);
				}
			}	
			
			if (healthyPeople.size() > 0) {
				for (int i = 0; i < Constants.vaccinateNumber; i++) {
					int index = random.nextInt(healthyPeople.size());
					Person currentPerson = healthyPeople.get(index);
					changeStatus(currentPerson, Status.Immune);
				} 
			}														
		}
	}

	
	private void updateCountry(Person person, Country selectedCountry) {		
		person.getCurrentCountry().removeCitizen(person);		
		person.setCurrentCountry(selectedCountry);
		selectedCountry.addCitizen(person);	
		infectedByMove(person);
	}

	private Country randomlySelectCountry() {
		int row = random.nextInt(Constants.worldSize);
		int col = random.nextInt(Constants.worldSize);	
		
		Country selectedCountry = WorldMap.Instance().getCountries()[row][col];
		return selectedCountry;
	}

	@Override
	public void dayPassed(Person person) {
		person.incrementDay();			
	}
	
	public int decideMoveDay() {
		return random.nextInt(4) + 1;				
	}
	
	@Override
	public void manageInfectionStatus(Person person) {	
		Status personStat = person.getStatus();
		
		if(personStat == Status.Infected || personStat == Status.Sick){
						
			switch (person.getInfectionDay()) {
			
			//Get sick after 6 days from infection
			case Constants.daysRequiredToGetSick:		
				changeStatus(person, Status.Sick);
				person.getCurrentCountry().removeInfectedPerson(person);
				break;
				
			//Die or live after 14 days from infection
			case Constants.daysRequiredToDie:
				boolean isAlive = random.nextInt(100) < 75;				
				person.setStatus(isAlive ? Status.Sick : Status.Dead);
				
				if(!isAlive){
					person.setMoveDay(0);					
					person.getCurrentCountry().addDeadPeople(person);
					person.getCurrentCountry().removeSickPerson(person);
					person.getCurrentCountry().removeCitizen(person);
				}	
				
				break;
				
			//Get rid of sickness after 16 days
			case Constants.daysRequiredToRecover:
				changeStatus(person, Status.Infected);
				person.getCurrentCountry().removeSickPerson(person);
				break;
				
			//Get healed in 18 days
			case Constants.daysRequiredToGetHealthy:
				changeStatus(person, Status.Healthy);
				person.getCurrentCountry().removeInfectedPerson(person);
				person.setInfectionDay(0);
				break;
		}			
	}					
	}
	
}
