
public class Person  {
	
	private boolean isSick;
	private boolean isInfected;
	private boolean isAlive;
	private boolean isImmune;
	
	private int infectionDay;
	private int moveDay;
	
	private Country currentCountry;
	private int id;
	
	public Person (Country currentCountry){
		isSick = false;
		isInfected = false;
		isAlive = true;
		isImmune = false; //for super person or vaccinated
		infectionDay = 0;
		this.currentCountry = currentCountry;
		EventFiringSource.Instance().addDayEventListener(this);
		moveDay = 0;
	}
	
	public void incrementDay() {
		moveDay--;
		if(isInfected){
			infectionDay++;
		}		
	}
	
	public boolean isSick() {
		return isSick;
	}

	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}

	public boolean isInfected() {
		return isInfected;
	}

	public void setInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
	public boolean isImmune() {
		return isImmune;
	}
	public void setImmune(boolean isImmune) {
		this.isImmune = isImmune;
	}

	public void setID(int id) {
		this.id = id;		
	}
	
	public int getID(){
		return id;
	}	
}
