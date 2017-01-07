import java.util.ArrayList;

public class EventFiringSource {
	private ArrayList<Person> personListeners;
	
private static EventFiringSource instance;
	
	private EventFiringSource(){
		
	}
	
	public static EventFiringSource Instance(){
		if(instance == null){
			instance = new EventFiringSource();			
		}
		return instance;
	}
	
	public void addDayEventListener(Person personListener){
		if(personListeners == null){
			personListeners = new ArrayList<Person>();
		}
		personListeners.add(personListener);
	}
	
	private void fireDayEvent(){
		for (Person listener : personListeners ) {
			listener.dayPassed();
		}
	}
	
	public void startDayEvent(){
		fireDayEvent();
	}
}
