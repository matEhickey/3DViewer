import java.util.*;
public class ProjectionPerspective2Points implements Projection {
		private Vertice persp1;
		private Vertice persp2;
	public ProjectionPerspective2Points(){
		persp1 = new Vertice(-200,100,-500);
		persp2 = new Vertice(200,100,-500);
	}


	public int[] getXYcoord(Vertice vertice){
		int[] coord = new int[2];
		coord[0] = (
									(((int)vertice.x*(int)persp1.z*(int)persp2.z)
													-((int)vertice.z*(int)persp1.x*(int)persp2.x))
									/((int)((persp1.z+persp2.z)-vertice.z))
								);
		coord[1] = (
									(((int)vertice.y*(int)persp1.z*(int)persp2.z)
													-((int)vertice.z*(int)persp1.y*(int)persp2.y))
									/((int)((persp1.z+persp2.z)-vertice.z))
							);
		return(coord);
	}
}
