import java.util.List;

public class Country {
	private Country[] neighbors;	
	private List<Person> people;
	private boolean isThereSickPerson;
	
	public Country(){
		neighbors = new Country[4];
		
	}
	public Country[] getNeighbors() {
		return neighbors;
	}		
	
	public List<Person> getPeople(){
		return people;
	}
	
	public boolean getIsThereSickPerson(){
		for (Person person : people) {
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
}
