import java.util.ArrayList;
import java.util.Random;

public class Country  {
	private ArrayList<Country> neighbors;	
	private ArrayList<Person> citizens;
	private String countryName;
	private ArrayList<Person> infectedCitizens;
	private ArrayList<Person> sickCitizens;
	private ArrayList<Person> deadPeople;
	
	public Country(){
		neighbors = new ArrayList<Country>();
		citizens = new ArrayList<Person>();	
		infectedCitizens = new ArrayList<Person>();	
		sickCitizens = new ArrayList<Person>();
		deadPeople = new ArrayList<Person>();
	}
	
	public ArrayList<Country> getNeighbors() {
		return neighbors;
	}		
	
	public void seeDeadPeople(Person person){
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
		if(person.isSick()){
			sickCitizens.add(person);
		}		
		if(person.isInfected()){
			infectedCitizens.add(person);
		}	
	}
	
	public void removeCitizen(Person person){
		citizens.remove(person);
		if(person.isSick()){
			sickCitizens.remove(person);
		}		
		if(person.isInfected()){
			infectedCitizens.remove(person);
		}			
	}

	public void addInfectedPerson(Person person){
		infectedCitizens.add(person);
	}
	
	public void removeInfectedPerson(Person person){
		infectedCitizens.remove(person);
	}
	
	public ArrayList<Person> getInfectedCitizens(){
		return infectedCitizens;
	}
			
	public ArrayList<Person> getSickCitizens(){
		return sickCitizens;
	}
	
	public void addSickPerson(Person person) {		
		sickCitizens.add(person);
	}
	
	public void removeSickPerson(Person person){
		sickCitizens.remove(person);
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
