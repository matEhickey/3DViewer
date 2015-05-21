import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;

public class Panneau extends JPanel{

	private JFrame frame;
	private int largeur;
	private int longueur;
	public java.util.List<Mesh> meshes;
	public java.util.List vertices;//pour la detection des click
	
	public Vertice verticeSelection;
	
	//private Vertice persp1;
	//private Vertice persp2;
	
	public Projection projection;
	
	
	public Panneau(JFrame frame){
		//gestion fenetre
		//super();
		
		this.frame = frame;
		//choix visiteur projection
		projection = new ProjectionPoor();
				//projection = new ProjectionParallele();
				//projection = new ProjectionPerspective2Points();
		
		//initialisation des données 
		
		largeur = 700;
		longueur = 500;
		
		vertices = new LinkedList();
		
		meshes = new LinkedList<Mesh>();
		
		//persp1=new Vertice(0.0,0.0,5000.0);
		//persp2=new Vertice(0.0,0.0,5000.0);
		
		this.addMouseListener(
			new MouseListener(){
				public void mouseClicked(MouseEvent e){
					//System.out.println(e.getX());
					System.out.println("click");
					Iterator ite = Panneau.this.vertices.iterator();
					Vertice vert_i ;
					int getX = e.getX();
					int getY = e.getY();
					while(ite.hasNext()){
						vert_i = (Vertice)ite.next();
						int [] coords = projection.getXYcoord(vert_i);
						
						
						
						
						//System.out.println("x ="+x+" y ="+y+" click = x:"+getX+" y"+getY);
						if(coords[0]+(longueur/2)>getX-5 && coords[0]+(longueur/2)<getX+5){
							if(coords[1]+(largeur/2)>getY-5 && coords[1]+(largeur/2)<getY+5){
								System.out.println("gagne");
								verticeSelection = vert_i;
							}
						}
					}
					
				}
				public void mouseExited(MouseEvent e){}
				public void mouseEntered(MouseEvent e){
					
				}
				public void mouseReleased(MouseEvent e){
				//System.out.println("fghhf");
				}
				public void mousePressed(MouseEvent e){}
			}
		);
		
		
		
		
		//repaint();
		frame.setVisible(true);
	}
	public void paint(Graphics g){
		//raz
		//g.clearRect(0,0,largeur,longueur);
		//init fond
		g.setColor(new Color(100,100,100));
		for(int i = 0;i<largeur;i++){
			for(int j = 0;j<longueur;j++){
					g.fillRect(i,j,1,1);
			}
		}
		
		//parcours des meshes
		Iterator ite_mesh = meshes.iterator();
		Mesh mesh_i;
		int i = 0;
		System.out.println("taille de la liste objets = "+meshes.size());
		
		vertices = new LinkedList();//raz
		
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
				
				
				
				vertices.add(tri_i.v1);
				vertices.add(tri_i.v2);
				vertices.add(tri_i.v3);
				
				
				
				
				//lignes des triangles
					g.setColor(tri_i.getColor());
					g.drawLine(coord1[0]+longueur/2,coord1[1]+largeur/2, coord2[0]+longueur/2,coord2[1]+largeur/2);
					g.drawLine(coord2[0]+longueur/2,coord2[1]+largeur/2, coord3[0]+longueur/2,coord3[1]+largeur/2);
					g.drawLine(coord1[0]+longueur/2,coord1[1]+largeur/2, coord3[0]+longueur/2,coord3[1]+largeur/2);
			
				
				
				
				
				
			}
			
			//reperes		
			
			
					g.setColor(new Color(254,0,0));
					Vertice x1 = new Vertice(10,0,0);
					int [] coordX = projection.getXYcoord(x1);
					g.drawLine(0+longueur/2,0+largeur/2, coordX[0]+longueur/2,coordX[1]+largeur/2);
			
					g.setColor(new Color(0,254,0));
					Vertice y1 = new Vertice(0,10,0);
					int [] coordY = projection.getXYcoord(y1);
					g.drawLine(0+longueur/2,0+largeur/2, coordY[0]+longueur/2,coordY[1]+largeur/2);
			
					g.setColor(new Color(0,0,254));
					Vertice z1 = new Vertice(0,0,10);
					int [] coordZ = projection.getXYcoord(z1);
					g.drawLine(0+longueur/2,0+largeur/2, coordZ[0]+longueur/2,coordZ[1]+largeur/2);
			
			
			//trace vertice selectionner
			
			try{
					g.setColor(new Color(255,255,0));
					int [] coordSelect = projection.getXYcoord(verticeSelection);
					g.drawOval(coordSelect[0]+longueur/2-1,coordSelect[1]+largeur/2-1,5,5);
					Panneau.this.repaint();
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			
			
		}
		
		
		frame.setSize(largeur,longueur);
	}
	
	public static void main(String[] args){
		//System.out.println("Hello");
		JFrame frame = new JFrame("Visualisation 3D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panneau panneau = new Panneau(frame);
		frame.add(panneau);
		new Commande(panneau);
		new Spawner(panneau);
	}

}
