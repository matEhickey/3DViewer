import java.util.*;
public interface Mesh{
	public <Triangle>List getTriangles();
	public String is();
	public void rotationY90(Vertice loc);
	public void deplacer(Vertice vecteur);
}
