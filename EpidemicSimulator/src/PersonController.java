import java.util.List;
import java.util.Random;

public class PersonController {	
	
	public void becomeSick(Person person){
		person.setSick(true);
	}
	
	public void becomeImmune(Person person){
		person.setSick(false);
	}
	
	public void becomeInfected(Person person){
		person.setInfected(true);		
	}
	
	public void becomeHealthy(Person person){
		person.setInfected(false);
	}
	
	public void move(Person person){
		//after deciding the day of leaving. . .
		Country currentCountry = person.getCurrentCountry();
		Country[] neighbors = currentCountry.getNeighbors();
		for (int i = 0; i < neighbors.length; i++) {
			if(neighbors[i].getIsThereSickPerson() == true){
				continue;
			} else {
				//the deciding logic isn't implemented yet. . . 
				//assuming the person will move the first available
				person.setCurrentCountry(neighbors[i]);
			}
		}
		person.setCurrentCountry(currentCountry);
	}
}
