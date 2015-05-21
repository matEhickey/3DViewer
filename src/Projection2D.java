public class Projection2D implements Projection {

	public int[] getXYcoord(Vertice vertice){
		int[] coord = new int[2];
		coord[0] = (int)vertice.x;
		coord[1] = (int)vertice.y;
		return(coord);
	}

}
