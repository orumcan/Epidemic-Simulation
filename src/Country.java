import java.util.ArrayList;

public class Country  {
	private ArrayList<Country> neighbors;	
	private ArrayList<Person> citizens;
	private String countryName;
	private ArrayList<Person> infectedCitizens;
	private ArrayList<Person> sickCitizens;
	private ArrayList<Person> immunedCitizens;
	private ArrayList<Person> deadPeople;
	private ArrayList<Person> doctors;
	
	public Country(){
		neighbors 			= new ArrayList<Country>();
		citizens 			= new ArrayList<Person>();	
		infectedCitizens 	= new ArrayList<Person>();	
		sickCitizens 		= new ArrayList<Person>();
		immunedCitizens		= new ArrayList<Person>();
		deadPeople			= new ArrayList<Person>();
		doctors 			= new ArrayList<Person>();
	}
	
	public ArrayList<Country> getNeighbors() {
		return neighbors;
	}		
	
	public void addDeadPeople(Person person){
		deadPeople.add(person);
	}
	
	public ArrayList<Person> getDeadPeople(){
		return deadPeople;
	}
	
	public ArrayList<Person> getCitizens(){
		return citizens;
	}
	
	public void addCitizen(Person person){
		citizens.add(person);
		if(person.getStatus() == Status.Sick){
			sickCitizens.add(person);
		}		
		if(person.getStatus() == Status.Infected){
			infectedCitizens.add(person);
		}	
		if(person.getStatus() == Status.Immune){
			immunedCitizens.add(person);
		}	
		if(person.getDoctor()){
			doctors.add(person);
		}
	}
	
	public void removeCitizen(Person person){
		citizens.remove(person);
		if(person.getStatus() == Status.Sick){
			sickCitizens.remove(person);
		}		
		if(person.getStatus() == Status.Infected){
			infectedCitizens.remove(person);
		}		
		if(person.getStatus() == Status.Immune){
			immunedCitizens.remove(person);
		}	
		if(person.getDoctor()){
			doctors.remove(person);
		}
	}

	public void addInfectedPerson(Person person){
		infectedCitizens.add(person);
	}
	
	public void removeInfectedPerson(Person person){
		infectedCitizens.remove(person);
	}
	
	public void addDoctor(Person person){
		doctors.add(person);
	}
	
	public void removeDoctor(Person person){
		doctors.remove(person);
	}
	
	public ArrayList<Person> getDoctors(){
		return doctors;
	}	
	
	public ArrayList<Person> getInfectedCitizens(){
		return infectedCitizens;
	}

	public ArrayList<Person> getSickCitizens(){
		return sickCitizens;
	}
	
	public ArrayList<Person> getImmunedCitizens(){
		return immunedCitizens;
	}

	public void addSickPerson(Person person) {		
		sickCitizens.add(person);
	}
	
	public void removeSickPerson(Person person){
		sickCitizens.remove(person);
	}
	
	public void addSImmunePerson(Person person) {		
		immunedCitizens.add(person);
	}
	
	public void removeImmunePerson(Person person){
		immunedCitizens.remove(person);
	}
	
	public void addNeighbor(Country neighbor){
		neighbors.add(neighbor);
	}		
	
	public String getCountryName(){
		return countryName;
	}
	
	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	
}
