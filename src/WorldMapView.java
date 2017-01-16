import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class WorldMapView {
	 public static final int boxSize = 50;
	 public static final int buttonSize = 80;	 
	 
	 JFrame frame;
	 JPanel labelPanel;
	 JPanel controlPanel;
	 JPanel mainPanel;
	 JPanel consolePanel;
	 JPanel gamePanel;
	 JScrollPane gridScrollPane;
	 JScrollPane consoleScrollPane;
	 
	 JButton nextButton;
	 JLabel[][] labels;
	 JLabel [] consoleLabels;
	 Country[][] countries;
	 	 
	 String consoleString = "";
	 int populationSize;
	 
	 private static WorldMapView instance;
 
	 private WorldMapView() {
		 
	 }
	
	 public static WorldMapView Instance(){
		if(instance == null){
			instance = new WorldMapView();			
		}
		return instance;
	 }
	
	 public void initializeView(Country[][] countries, ActionListener actionListener) {
		 this.countries = countries;
		 populationSize = WorldMap.Instance().getPopulation().length;
		 frame 		    = new JFrame("Epidemic Simulator");
		 mainPanel      = new JPanel();
		 labelPanel     = new JPanel();
		 controlPanel   = new JPanel();	
		 consolePanel   = new JPanel();
		 gamePanel		= new JPanel();
		 labels 	    = new JLabel[countries.length][countries[0].length];
		 consoleLabels  = new JLabel[populationSize];
		 nextButton     = new JButton();
		 

		 frame		 	 .setSize(countries.length * boxSize, countries.length * boxSize);
		 controlPanel 	 .setPreferredSize(new Dimension(countries.length * boxSize , buttonSize));
		 gamePanel		 .setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
		 mainPanel	 	 .setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		 consolePanel	 .setLayout(new BoxLayout(consolePanel, BoxLayout.Y_AXIS));
		 labelPanel  	 .setLayout(new GridLayout(countries.length, countries[0].length));		 		
		 nextButton  	 .addActionListener(actionListener);
		 nextButton		 .setPreferredSize(new Dimension(buttonSize, buttonSize/2));
		 
		 for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries[0].length; j++) {
				
				int populationSize = countries[i][j].getCitizens().size();
				String countryName = countries[i][j].getCountryName();
				
				String info = "<html><center>" 		
							  + "Name: " 			+ countryName + "<br>"  
						      + "Population: " 		+ populationSize + "<br>" 
						      + "Doctors: "			+ countries[i][j].getDoctors().size() + "<br>"
						      + "Immune People: " 	+ countries[i][j].getImmunedCitizens().size() + "<br>"
						      + "Infected People: " + countries[i][j].getInfectedCitizens().size() + "<br>"
						      + "Sick People: " 	+ countries[i][j].getSickCitizens().size() + "<br>"
							  + "Dead People: " 	+ countries[i][j].getDeadPeople().size()
							  + "</center></html>";
				
				JLabel label = new JLabel(info, SwingConstants.CENTER);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));				
				labels[i][j] = label;
				labelPanel.add(label);							
			}
		}
		 JLabel infoLabel = new JLabel(" ID Country Status  isDoctor InfectionDay  MoveDay   ");
		 if(Constants.showConsole != 0){
			 consolePanel.add(infoLabel); 
		 }	 
		 
		for (int i = 0; i < populationSize; i++) {		
			 consoleLabels[i] = new JLabel("", SwingConstants.LEFT);		 		
			 consolePanel.add(consoleLabels[i]);
		}
		

		gridScrollPane = new JScrollPane(labelPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		consoleScrollPane = new JScrollPane(consolePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		gamePanel.add(consoleScrollPane);
		gamePanel.add(gridScrollPane);
		mainPanel.add(gamePanel);				
		controlPanel.add(nextButton);				
		mainPanel.add(controlPanel);
			
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
		
		if(Constants.showConsole != 0){
			updateConsole();
			nextButton.setText("0");
		}	
	 }
	 
	public void updateGUI(){
		 for (int i = 0; i < countries.length; i++) {
				for (int j = 0; j < countries[0].length; j++) {
					
					int populationSize = countries[i][j].getCitizens().size();
					String countryName = countries[i][j].getCountryName();
					
					String info = "<html><center>" 		
							  + "Name: " 			+ countryName + "<br>"  
						      + "Population: " 		+ populationSize + "<br>" 
						      + "Doctors: "			+ countries[i][j].getDoctors().size() + "<br>"
						      + "Immune People: " 	+ countries[i][j].getImmunedCitizens().size() + "<br>"
						      + "Infected People: " + countries[i][j].getInfectedCitizens().size() + "<br>"
						      + "Sick People: " 	+ countries[i][j].getSickCitizens().size() + "<br>"
							  + "Dead People: " 	+ countries[i][j].getDeadPeople().size() 
							  + "</center></html>";
	
					labels[i][j].setText(info);
					
			}
		 }		 
	 }
 
	public void updateConsole(){	 
		 
		 for (int i = 0; i < populationSize; i++) {
			 Person person = WorldMap.Instance().getPopulation()[i];
			 String info = person.getID()
			 +"       "+ person.getCurrentCountry().getCountryName() 
			 +"        "+ person.getStatus()
			 +"   "+ person.getDoctor()
			 +"           "+ person.getInfectionDay() 		 
			 +"                     "+ person.getMoveDay();
			 consoleLabels[i].setText(info);
			 nextButton.setText(Integer.toString(GameManager.dayCounter));		 
		}		 	
	}	
	
}
