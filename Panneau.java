import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Panneau extends JPanel{

	private JFrame frame;
	private int longueur;
	private int largeur;
	public java.util.List<Mesh> meshes;
	
	//private Vertice persp1;
	//private Vertice persp2;
	
	public Projection projection;
	
	private int profondeur;//doit etre remplacer par les z des points de fuites
	
	public Panneau(JFrame frame){
		//gestion fenetre
		//super();
		
		this.frame = frame;
		//choix visiteur projection
		//projection = new ProjectionPoor();
				//projection = new ProjectionParallele();
				projection = new Projection2D();
		
		//initialisation des données 
		
		longueur = 500;
		largeur = 500;
		profondeur = 500;
		
		meshes = new LinkedList<Mesh>();
		
		//persp1=new Vertice(0.0,0.0,5000.0);
		//persp2=new Vertice(0.0,0.0,5000.0);
		
		
		
		
		
		
		//repaint();
		frame.setVisible(true);
	}
	public void paint(Graphics g){
		//raz
		//g.clearRect(0,0,longueur,largeur);
		//init fond
		g.setColor(new Color(100,100,100));
		for(int i = 0;i<longueur;i++){
			for(int j = 0;j<largeur;j++){
					g.fillRect(i,j,1,1);
			}
		}
		
		//parcours des meshes
		Iterator ite_mesh = meshes.iterator();
		Mesh mesh_i;
		int i = 0;
		System.out.println("taille de la liste objets = "+meshes.size());
		while(ite_mesh.hasNext()){
			
			i++;
			mesh_i = (Mesh)ite_mesh.next();
			System.out.println("Classe "+mesh_i.is());
			
			java.util.List triangles = mesh_i.getTriangles();
			System.out.println("Nombre de triangles "+triangles.size());
			Iterator ite_tri = triangles.iterator();
			
			Triangle tri_i;
			while(ite_tri.hasNext()){
				tri_i = (Triangle)ite_tri.next();
				//tri_i.display();
				
				//tri_i est  le triangle a afficher
				
				int [] coord1 = projection.getXYcoord(tri_i.v1);
				System.out.println("1 . x = "+coord1[0]+"  Y="+coord1[1]);
				int [] coord2 = projection.getXYcoord(tri_i.v2);
				System.out.println("2 . x = "+coord2[0]+"  Y="+coord2[1]);
				int [] coord3 = projection.getXYcoord(tri_i.v3);
				System.out.println("3 . x = "+coord3[0]+"  Y="+coord3[1]);
				
				
				
				//lignes des triangles
					g.setColor(tri_i.getColor());
					g.drawLine(coord1[0]+largeur/2,coord1[1]+longueur/2, coord2[0]+largeur/2,coord2[1]+longueur/2);
					g.drawLine(coord2[0]+largeur/2,coord2[1]+longueur/2, coord3[0]+largeur/2,coord3[1]+longueur/2);
					g.drawLine(coord1[0]+largeur/2,coord1[1]+longueur/2, coord3[0]+largeur/2,coord3[1]+longueur/2);
			
				
				
				
				
				
			}
			
			//reperes		
			
			
					g.setColor(new Color(254,250,250));
					Vertice x1 = new Vertice(10,0,0);
					int [] coordX = projection.getXYcoord(x1);
					g.drawLine(0+largeur/2,0+longueur/2, coordX[0]+largeur/2,coordX[1]+longueur/2);
			
					//g.setColor(new Color(100,50,200));
					Vertice y1 = new Vertice(0,10,0);
					int [] coordY = projection.getXYcoord(y1);
					g.drawLine(0+largeur/2,0+longueur/2, coordY[0]+largeur/2,coordY[1]+longueur/2);
			
					//g.setColor(new Color(200,50,100));
					Vertice z1 = new Vertice(0,0,10);
					int [] coordZ = projection.getXYcoord(z1);
					g.drawLine(0+largeur/2,0+longueur/2, coordZ[0]+largeur/2,coordZ[1]+longueur/2);
			
			
			
			
			
			
			
			
		}
		
		
		frame.setSize(longueur,largeur);
	}
	
	public static void main(String[] args){
		//System.out.println("Hello");
		JFrame frame = new JFrame("Visualisation 3D");
		Panneau panneau = new Panneau(frame);
		frame.add(panneau);
		new Commande(panneau);
		new Spawner(panneau);
	}

}
