import java.util.ArrayList;

public class Country {
	private Country[] neighbors;	
	private ArrayList<Person> citizens;
	private boolean isThereSickPerson;
	
	public Country(){
		neighbors = new Country[4];
		citizens = new ArrayList<Person>();
		
	}
	public Country[] getNeighbors() {
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
	
	public void setNeighborList(Country[] neighbors){
		this.neighbors = neighbors;
	}
	
	public String name(){
		return "1";
	}
}
