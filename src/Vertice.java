import java.math.*;
public class Vertice 
{
	public double x;
	public double y;
	public double z;
	
	public Vertice(){
		x = y = z = 0;
	}
	
	public Vertice(double x2,double y2,double z2){
		x=x2;
		y=y2;
		z=z2;
	}
	
	public void setCoord(double nx,double ny, double nz){
		x = nx;
		y = ny;
		z = nz;
	}
	
	public void display(){
		System.out.println("X="+x+" Y="+y+" Z="+z);
	}
	
	public void deplacerX(double deplacement){
		x+= deplacement;
	}
	
	public void deplacerY(double deplacement){
		y+= deplacement;
	}
	
	public void deplacerZ(double deplacement){
		z+= deplacement;
	}
	
	public void deplacer(Vertice vecteur){
		x+= vecteur.x;
		y+= vecteur.y;
		z+= vecteur.z;
		
	}
	
	public void rotationY90(Vertice loc){
	
		double distance = this.distance(loc);
	
		x= loc.x+ (Math.cos(90)*distance);
		z= loc.z+ (Math.sin(90)*distance);
		
		
	}
	
	public double distance(Vertice oth){
		double deltaX,deltaY;
		deltaX = Math.abs(oth.x-x);
		deltaY = Math.abs(oth.y-y);
		double distance = Math.sqrt(deltaX+deltaY);
		return(distance);
	}
	
	
}
