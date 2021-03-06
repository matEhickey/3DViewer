import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Triangle implements Mesh,Affichable{

	public Vertice v1;
	public Vertice v2;
	public Vertice v3;
	public Color color;
	
	public Triangle(){
		v1 = new Vertice();
		v2 = new Vertice();
		v3 = new Vertice();
		
		v1.setCoord(0.0,100,0.0);
		v2.setCoord(0.0,0,0.0);
		v3.setCoord(0.0,0.0,100);
	}
	
	public Triangle(Vertice location){
		this();
		v1.deplacer(location);
		v2.deplacer(location);
		v3.deplacer(location);
	}
	
	
	
	public Triangle(Vertice a,Vertice b,Vertice c){
		v1 = a;
		v2 = b;
		v3 = c;
		color = new Color(0,0,0);
	}
	
	public Triangle(Vertice a,Vertice b,Vertice c,Color color){
		v1 = a;
		v2 = b;
		v3 = c;
		this.color = color;
	}
	
	public void deplacerX(double deplacement){
		v1.deplacerX(deplacement);
		v2.deplacerX(deplacement);
		v3.deplacerX(deplacement);
	}
	
	public void deplacerY(double deplacement){
		v1.deplacerY(deplacement);
		v2.deplacerY(deplacement);
		v3.deplacerY(deplacement);
	}
	
	public void deplacerZ(double deplacement){
		v1.deplacerZ(deplacement);
		v2.deplacerZ(deplacement);
		v3.deplacerZ(deplacement);
	}
	
	//patern composite
	
	public <Triangle>java.util.List getTriangles(){
		java.util.List retour = new <Triangle>LinkedList();
		retour.add(this);
		return(retour);
	}
	
	public void deplacer(Vertice vecteur){
		v1.x+= vecteur.x;
		v1.y+= vecteur.y;
		v1.z+= vecteur.z;
		
		v2.x+= vecteur.x;
		v2.y+= vecteur.y;
		v2.z+= vecteur.z;
		
		v3.x+= vecteur.x;
		v3.y+= vecteur.y;
		v3.z+= vecteur.z;
		
	}
	
	
	
	
	public void display(){
		System.out.println("Triangle: ( "+this+" )");
		System.out.print("\tV1:");
		v1.display();
		System.out.print("\tV2:");
		v2.display();
		System.out.print("\tV3:");
		v3.display();
		System.out.print("\n");
	}
	
	public Color getColor(){
		return(color);
	}
	
	public void rotationY90(Vertice loc){
		v1.rotationY90(loc);
		v2.rotationY90(loc);
		v3.rotationY90(loc);
	}
	
	public String is(){return("Triangle");}
	
	
}
