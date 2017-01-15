import java.util.ArrayList;
import java.util.Random;

public class PersonController implements DayCountInfertace{	
		
	private static PersonController instance;
	Random random = new Random();
	private boolean isAirwaysOn;
	private int counter = 0;
	private PersonController(){
		
	}
	
	public static PersonController Instance(){
		if(instance == null){
			instance = new PersonController();			
		}
		return instance;
	}
	
	public void becomeSick(Person person){
		person.setSick(true);
		person.getCurrentCountry().addSickPerson(person);
	}
	
	public void becomeImmuned(Person person){
		person.setSick(false);
		person.setImmune(true);
		person.getCurrentCountry().removeSickPerson(person);
	}
	
	public void becomeInfected(Person person){
		person.setInfected(true);
		person.getCurrentCountry().addInfectedPerson(person);
	}
	
	public void becomeHealthy(Person person){
		person.setInfected(false);
		person.setImmune(false);
		person.getCurrentCountry().removeInfectedPerson(person);
	}
		
	public void move(Person person){
		if(person.getMoveDay() <= 0){
			ArrayList<Country> possibleNeighbors = new ArrayList<Country>();
			for (Country neighbor : person.getCurrentCountry().getNeighbors()) {
				if(neighbor.getSickCitizens().size() == 0 && neighbor.getDeadPeople().size() == 0){
					possibleNeighbors.add(neighbor);
				}
			}
			
			if (!person.isAlive()) {
				person.setMoveDay(0);
			}
			else if(possibleNeighbors.size() <= 0){				
				person.setMoveDay(decideMoveDay());
			} 
			else if(possibleNeighbors.size() != 0 && person.isAlive()){
				int index = random.nextInt(possibleNeighbors.size());
				Country selectedCountry = possibleNeighbors.get(index);			
				updateCountry(person, selectedCountry);									
				person.setMoveDay(decideMoveDay());						 
			}										
		}		
		
	
//		isAirways = random.nextInt(100) < Constants.airwayProbability;		
//		if(isAirways){	
//			System.out.println("Previous Country :" + person.getCurrentCountry().getCountryName());
//			while(true){
//				Country selectedCountry = randomlySelectCountry();
//				if(selectedCountry.getSickCitizens().size() == 0){
//					updateCountry(person, selectedCountry);
//					break;
//				}
//			}
//			
//		}else {		
//		System.out.println("Previous Country Name:" + person.getCurrentCountry().getCountryName());
//		System.out.println("Previous Country Population:" + person.getCurrentCountry().getCitizens().size());
//		}		
		
//////////infection after moving!!//////////////////

//////////////////////////////////////////////////

	}

	private void infectedByMove(Person person) {
		boolean infectionChance = (random.nextInt(100) < 40);
		if(person.getCurrentCountry().getInfectedCitizens().size() != 0 
				&& infectionChance && !person.isInfected() && !person.isImmune()){
			becomeInfected(person);
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
		
		if(person.isInfected()){		
			
			switch (person.getInfectionDay()) {
			
			//Get sick after 6 days from infection
			case Constants.daysRequiredToGetSick:
				becomeSick(person);		
				break;
				
			//Die or live after 14 days from infection
			case Constants.daysRequiredToDie:
				boolean isAlive = random.nextInt(100) < 25;
				person.setAlive(isAlive);
				
				if(!isAlive){
					person.getCurrentCountry().seeDeadPeople(person);
					person.getCurrentCountry().removeSickPerson(person);
					person.getCurrentCountry().removeInfectedPerson(person);
					person.getCurrentCountry().removeCitizen(person);
				}	
				
				break;
				
			//Get rid of sickness after 16 days
			case Constants.daysRequiredToGetImmuned:
				if(person.isAlive())
					becomeImmuned(person);
				break;
				
//			Get healed in 18 days
			case Constants.daysRequiredToGetHealthy:
				if(person.isAlive())
				{
					becomeHealthy(person);	
					person.setInfectionDay(0);
				}
				break;
			}
		}
		//WorldMapView.Instance().updateConsole();		
	}
	
}
