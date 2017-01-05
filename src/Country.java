import java.util.ArrayList;

public class Country {
	private ArrayList<Country> neighbors;	
	private ArrayList<Person> citizens;
	private boolean isThereSickPerson;
	private String countryName;
	private ArrayList<Person> infectedCitizens;
	
	public Country(){
		neighbors = new ArrayList<Country>();
		citizens = new ArrayList<Person>();	
		infectedCitizens = new ArrayList<Person>();	
	}
	
	public ArrayList<Country> getNeighbors() {
		return neighbors;
	}		
	
	public ArrayList<Person> getCitizens(){
		return citizens;
	}
	
	public void addCitizen(Person person){
		citizens.add(person);
	}
	
	public boolean getIsThereSickPerson(){
		for (Person person : citizens) {
			if(person.isSick()){
				isThereSickPerson = true;
				break;
			}
		}
		return isThereSickPerson;
	}	
	
	public void informInfected(Person person){
		infectedCitizens.add(person);
	}
	
	public ArrayList<Person> getInfectedCitizens(){
		return infectedCitizens;
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
