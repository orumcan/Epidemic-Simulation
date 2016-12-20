import java.util.ArrayList;

public class Country {
	private ArrayList<Country> neighbors;	
	private ArrayList<Person> citizens;
	private boolean isThereSickPerson;
	private String name;
	
	public Country(String name){
		neighbors = new ArrayList<Country>();
		citizens = new ArrayList<Person>();
		this.name = name;
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
	
	public void addNeighbor(Country neighbor){
		neighbors.add(neighbor);
	}
	
	public String getName(){
		return name;
	}	
}
