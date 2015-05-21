import java.util.*;
public class Cube implements Mesh,Affichable{
	
	private Plan[] plans;
	
	public Cube(){
		plans = new Plan[6];
		
		
			plans[0] = new Plan();
			plans[0].deplacer(new Vertice(100,0,0));
			
			plans[1] = new Plan();
			plans[1].deplacer(new Vertice(-100,0,0));
			
			plans[2] = new Plan();
			plans[2].deplacer(new Vertice(-150,0,0));
			
			plans[3] = new Plan();
			plans[3].deplacer(new Vertice(150,0,0));
			
			plans[4] = new Plan();
			plans[4].deplacer(new Vertice(200,0,0));
			
			plans[5] = new Plan();
			//plans[5].deplacer(new Vertice(-200,0,0));
		
	}
	
	public Cube(Vertice location){
			this();
			for(int i = 0;i<6;i++){
					plans[i].deplacer(location);
			}
	}
	
	public <Triangle>List getTriangles(){
		List retour = new <Triangle>LinkedList();
		Triangle triangle_i;
		for(int i = 0;i<6;i++){
			
			Iterator ite_tri = plans[i].getTriangles().iterator();
			while(ite_tri.hasNext()){
				triangle_i = (Triangle)ite_tri.next();
				retour.add(triangle_i);				
			}
		}
		return(retour);
	}
	
	public void rotationY90(Vertice loc){
			
	}
	
	public void deplacer(Vertice vecteur){		
	}
	
	public String is(){return("Cube");}

}
