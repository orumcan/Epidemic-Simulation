
public class Person  {
	
	private int infectionDay;
	private int moveDay;
	private int id;
	
	private Country currentCountry;	
	private Status status;
	
	private boolean isDoctor;
	
	public Person (Country currentCountry){

		infectionDay 		= 0;
		moveDay 			= 0;
		this.currentCountry = currentCountry;
		status 				= Status.Healthy;
		EventFiringSource.Instance().addDayEventListener(this);		
		isDoctor = false;
	}
	
	public void incrementDay() {
		moveDay--;
		if(status == Status.Infected || status == Status.Sick){
			infectionDay++;
		}		
	}
		
	public Status getStatus(){
		return status;
	}
	
	public void setDoctor(boolean isDoctor){
		this.isDoctor = isDoctor;
		if(isDoctor)
			currentCountry.addDoctor(this);
	}
	
	public boolean getDoctor(){
		return isDoctor;
	}	

	public void setStatus(Status status){
		this.status = status;
	}
	
	public int getInfectionDay() {
		return infectionDay;
	}

	public void setInfectionDay(int infectionDay) {
		this.infectionDay = infectionDay;
	}

	public int getMoveDay() {
		return moveDay;
	}

	public void setMoveDay(int moveDay) {
		this.moveDay = moveDay;
	}

	public Country getCurrentCountry() {
		return currentCountry;
	}

	public void setCurrentCountry(Country currentCountry) {
		this.currentCountry = currentCountry;
	}

	public void setID(int id) {
		this.id = id;		
	}
	
	public int getID(){
		return id;
	}	
}
