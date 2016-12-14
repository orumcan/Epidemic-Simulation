
public class WorldMap {
	private Country[][] countryList;
	int countryNum; //to be implemented as a Constant
	CountryController controller;
	
	public void createWorldMap(CountryController controller){
		countryList = new Country[countryNum][countryNum];
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList.length; j++) {
				countryList[i][j] = new Country();
			}
		}
		this.controller = controller;
		initializeNeighbors();
	}
	
	public Country[][]  gerWorldMap(){
		return countryList;
	}
	
	private void initializeNeighbors(){
		Country [] neighbors = new Country[4];
		for (int i = 0; i < countryList.length; i++) {
			for (int j = 0; j < countryList.length; j++) {
				if(i == 0 && j == 0){
					neighbors[0] = null;                  //north
					neighbors[1] = countryList[i][j + 1]; //east
					neighbors[2] = countryList[i + 1][j]; // south
					neighbors[3] = null;                  //west
				}
				if(i == 0 && j == countryNum){
					neighbors[0] = null; 			      //north
					neighbors[1] = null;                  //east					
					neighbors[2] = countryList[i + 1][j]; // south
					neighbors[3] = countryList[i][j - 1]; //west					
								
				}
				if(i == countryNum && j == 0){
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = countryList[i][j + 1]; //east					
					neighbors[2] = null; 			      // south
					neighbors[3] = null;				  //west
				}
				if(i == countryNum && j == countryNum){
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = null;				  //east					
					neighbors[2] = null;				  // south
					neighbors[3] = countryList[i][j - 1]; //west
				}
				if(i == 0 && j != 0 && j != countryNum){
					neighbors[0] = null; //north
					neighbors[1] = countryList[i][j + 1];//east					
					neighbors[2] = countryList[i + 1][j];// south
					neighbors[3] = countryList[i][j - 1]; //west
				}
				if(i == countryNum && j != 0 && j != countryNum){
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = countryList[i][j + 1];//east					
					neighbors[2] = null; 				 // south
					neighbors[3] = countryList[i][j - 1]; //west
				}
				if(j == 0 && i != 0 && i != countryNum){
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = countryList[i][j + 1]; //east					
					neighbors[2] = countryList[i + 1][j]; // south
					neighbors[3] = null; //west
				}
				if(j == countryNum && i != 0 && i != countryNum){
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = null;				  //east					
					neighbors[2] = countryList[i + 1][j]; // south
					neighbors[3] = countryList[i][j - 1]; //west
				}else{
					neighbors[0] = countryList[i - 1][j]; //north
					neighbors[1] = countryList[i][j + 1]; //east					
					neighbors[2] = countryList[i + 1][j]; // south
					neighbors[3] = countryList[i][j - 1]; //west
				}
				controller.setNeighborList(countryList[i][j], neighbors);
			}
			
		}
	}
}
