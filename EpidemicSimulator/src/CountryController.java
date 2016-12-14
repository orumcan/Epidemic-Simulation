import java.util.List;

public class CountryController {
	private List<Country> countries;
	
	public void addCountry(Country country){
		countries.add(country);
	}
	 
	 public Country[] getNeighborList(Country country)
     {
         return country.getNeighbors();
     }
	 
	 public boolean getIsThereSickPerson(Country country){
		 return country.getIsThereSickPerson();
	 }
	 
	 public void setNeighborList(Country country, Country[] neighborList){
		 country.setNeighborList(neighborList);
	 }
	 
}
