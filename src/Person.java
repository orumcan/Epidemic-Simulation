
public class Person implements DayCountInfertace {
	private boolean isSick;
	private boolean isInfected;
	private boolean isAlive;
	
	private int infectionDay;
	private int dayPassed;
	
	private Country currentCountry;
	
	public Person (Country currentCountry){
		isSick = false;
		isInfected = false;
		isAlive = true;
		infectionDay = 0;
		this.currentCountry = currentCountry;
		EventFiringSource.Instance().addDayEventListener(this);
		dayPassed = 0;
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

	public int getDayPassed() {
		return dayPassed;
	}

	public void setDayPassed(int dayPassed) {
		this.dayPassed = dayPassed;
	}

	public Country getCurrentCountry() {
		return currentCountry;
	}

	public void setCurrentCountry(Country currentCountry) {
		this.currentCountry = currentCountry;
	}
	@Override
	public void dayPassed() {
		System.out.println("Day passed!");
		
	}
	@Override
	public void manageInfectionStatus() {
		System.out.println("Infection managed!");
		
	}
	
}
