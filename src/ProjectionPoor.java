import java.util.*;
public class ProjectionPoor implements Projection {

	public int[] getXYcoord(Vertice vertice){
		int[] coord = new int[2];
		
		coord[0] = ((int)vertice.x) -((int)(vertice.z/2.0));
		coord[1] =  ((int)vertice.y) -((int)(vertice.z/2.0));

		
		return(coord);
	}
	
	
}
