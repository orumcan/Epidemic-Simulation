import java.util.ArrayList;
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
		person.getCurrentCountry().informInfected(person);
	}
	
	public void becomeHealthy(Person person){
		person.setInfected(false);
	}
		
	public void move(Person person){
		
	}
}
