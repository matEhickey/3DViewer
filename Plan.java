import java.util.*;
public class Plan implements Mesh,Affichable{

	private Triangle[] triangles;
	
	public Plan(){
		triangles = new Triangle[2];
		
		
		Vertice v1 = new Vertice();
		Vertice v2 = new Vertice();
		Vertice v3 = new Vertice();
		
		v1.setCoord(0.0,100,0.0);
		v2.setCoord(0.0,0,0.0);
		v3.setCoord(0.0,0.0,100);
		triangles[0] = new Triangle(v1,v2,v3);
				
		Vertice v11 = new Vertice();
		Vertice v22 = new Vertice();
		Vertice v33 = new Vertice();
		
		v11.setCoord(0,100,100);
		v22.setCoord(0,0,100);
		v33.setCoord(0,100.0,0);	
		triangles[1] = new Triangle(v11,v22,v33);
	}
	
	public Plan(Vertice location){
		this();
		deplacer(location);
	}
	
	public <Triangle>List getTriangles(){
		List retour = new <Triangle>LinkedList();
		for(int i = 0;i<2;i++){
			retour.add(triangles[i]);
		}
		return(retour);
	}
	
	public void deplacer(Vertice vecteur){
		for(int i = 0;i<2;i++){
			triangles[i].deplacer(vecteur);
		}	
		
	}
	
	public void rotationY90(Vertice loc){
		for(int i = 0;i<2;i++){
			triangles[i].rotationY90(loc);
		}	
	}
	
	public String is(){return("Plan");}

}
