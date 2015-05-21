import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class Commande extends JPanel{

		private Panneau panneau;

		public JTextField newVerticeX;
		public JTextField newVerticeY;
		public JTextField newVerticeZ;
		
		public int projection;
		
	public Commande(Panneau panneau){
		this.panneau = panneau;
		projection = 1;
		JFrame frame = new JFrame("Type de vue");
		
		newVerticeX=new JTextField(5);
		
		newVerticeY=new JTextField(5);
		
		newVerticeZ=new JTextField(5);
		
		//this.add(newVerticeX);
		//this.add(newVerticeY);
		//this.add(newVerticeZ);
		
		JButton button = new JButton("Ajouter une vertice");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					System.out.println("X "+Commande.this.newVerticeX.getText()+" Y="+Commande.this.newVerticeY.getText()+" Z="+Commande.this.newVerticeZ.getText());
			}
		});		
		
		JButton button2D = new JButton("2D");
		button2D.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					
						Commande.this.panneau.projection = new Projection2D();
						
					Commande.this.panneau.repaint();
			}
		});	
		
		JButton buttonPerspective = new JButton("Perspective");
		buttonPerspective.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					
					Commande.this.panneau.projection = new ProjectionPerspective();
					Commande.this.panneau.repaint();
			}
		});		
		
		JButton buttonPoor = new JButton("Poor");
		buttonPoor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					Commande.this.panneau.projection = new ProjectionPoor();
					Commande.this.panneau.repaint();
			}
		});	
		
		
		//this.add(button);
		this.add(button2D);
		this.add(buttonPoor);
		this.add(buttonPerspective);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

}
