import java.util.Scanner;


public class GameManager {

	public static void main(String[] args) {		
		WorldMap worldMap = new WorldMap();	
		PersonController personController = new PersonController();
		Scanner reader = new Scanner(System.in);
				
		System.out.println("Enter the world size: ");
		Constants.worldSize = reader.nextInt();
		
		System.out.println("Enter the population size: ");
		Constants.populationSize = reader.nextInt();
		
		worldMap.createWorldMap();
		Country [][] countries = worldMap.getCountries();
		
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries[0].length; j++) {
				System.out.print("[" + countries[i][j].getCitizens().size() + "]");				
			}
			System.out.println();
		}
	}
}
