import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Spawner extends JPanel{
	
	public Panneau panneau;
		public JTextField locX ;
		public JTextField locY ;
		public JTextField locZ ;
		public Mesh lastMesh;
	
	public Spawner(Panneau panneau){
		this.panneau = panneau;
		JFrame frame = new JFrame("Spawner");
		
		
		JButton buttonAddTriangle = new JButton("Ajouter Triangle");
		JButton buttonAddPlan = new JButton("Ajouter Plan");
		JButton buttonAddCube = new JButton("Ajouter Cube (WIP)");
		
		locX = new JTextField(5);
		locY = new JTextField(5);
		locZ = new JTextField(5);
		
		buttonAddTriangle.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("add triangle");
					double x,y,z;
					x = Double.parseDouble(Spawner.this.locX.getText());
					y = Double.parseDouble(Spawner.this.locY.getText());
					z = Double.parseDouble(Spawner.this.locZ.getText());
					Mesh mesh = new Triangle(new Vertice(x,y,z));
					Spawner.this.lastMesh = mesh;
					Spawner.this.panneau.meshes.add(mesh);
					Spawner.this.panneau.repaint();
				}
			}
		
		);
		
		
		buttonAddPlan.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("add plan");
					double x,y,z;
					x = Double.parseDouble(Spawner.this.locX.getText());
					y = Double.parseDouble(Spawner.this.locY.getText());
					z = Double.parseDouble(Spawner.this.locZ.getText());
					Mesh mesh = new Plan(new Vertice(x,y,z));
					Spawner.this.lastMesh = mesh;
					Spawner.this.panneau.meshes.add(mesh);
					Spawner.this.panneau.repaint();
				}
			}
		
		);
		
		
		buttonAddCube.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("add cube");
					double x,y,z;
					x = Double.parseDouble(Spawner.this.locX.getText());
					y = Double.parseDouble(Spawner.this.locY.getText());
					z = Double.parseDouble(Spawner.this.locZ.getText());
					Mesh mesh = new Cube(new Vertice(x,y,z));
					Spawner.this.lastMesh = mesh;
					Spawner.this.panneau.meshes.add(mesh);
					Spawner.this.panneau.repaint();
				}
			}
		
		);
		
		
		JButton buttonRot90 = new JButton("Rot 90 (WIP)");
		
		buttonRot90.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Spawner.this.lastMesh.rotationY90(new Vertice(0,0,0));
					Spawner.this.panneau.repaint();
				}
			});
			
		JButton buttonMoveP = new JButton("Mouv + (WIP)");
		
		buttonMoveP.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Spawner.this.lastMesh.deplacer(new Vertice(0,0,20));
					Spawner.this.panneau.repaint();
				}
			});
			
			JButton buttonMoveM = new JButton("Mouv - (WIP)");
		
		buttonMoveM.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Spawner.this.lastMesh.deplacer(new Vertice(0,0,-20));
					Spawner.this.panneau.repaint();
				}
			});
		
		
		this.add(new JLabel("X"));
		this.add(locX);
		this.add(new JLabel("Y"));
		this.add(locY);
		this.add(new JLabel("Z"));
		this.add(locZ);
		this.add(buttonRot90);
		this.add(buttonMoveP);
		this.add(buttonMoveM);
		
		this.add(buttonAddTriangle);
		this.add(buttonAddPlan);
		this.add(buttonAddCube);
		
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

}
