import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WorldMapView {
	 public JFrame frame;
	 public static final int boxSize = 50;
	 JPanel contentPane;
	 
	 public void initializeView(Country[][] countries) {
		 
		 frame = new JFrame("Epidemic Simulator");
		 frame.setSize(countries.length * boxSize, countries.length * boxSize);
		 contentPane = new JPanel();
		 contentPane.setLayout(new GridLayout(countries.length, countries[0].length));

		 for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				
				int populationSize = countries[i][j].getCitizens().size();
				String countryName = countries[i][j].getCountryName();
				
				String info = "<html><center>" + "Name: " + countryName + "<br>"  
						      + "Population: " + populationSize + "<br>" 
						      + "Infected People: " + countries[i][j].getInfectedCitizens().size() + "</center></html>";
				
				JLabel label = new JLabel(info, SwingConstants.CENTER);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				contentPane.add(label);
			}
		}
		 
		 frame.add(contentPane);
		 frame.pack();
		 frame.setVisible(true);
		 frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	 }
}
