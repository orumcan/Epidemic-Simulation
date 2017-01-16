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
			if(listener.getStatus() != Status.Dead){
				PersonController.Instance().dayPassed(listener);
				PersonController.Instance().vaccinate(listener);
				PersonController.Instance().move(listener);				
				PersonController.Instance().manageInfectionStatus(listener);				
			}						
		}
	}
	
	public void startDayEvent(){
		fireDayEvent();
		if(Constants.showConsole != 0)
			WorldMapView.Instance().updateConsole();
	}
}
