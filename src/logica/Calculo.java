package logica;



import modelo.Relacion;
import modelo.Usuario;
import net.datastructures.*;


public class Calculo {

	private Graph<Usuario, Relacion> red;
	private TreeMap<String, Vertex<Usuario>> verts;
	
	
	  /**
	   * Construye un grafo no direccionado a partir de un mapa de <String, Usuario> y una lista de relaciones.
	   * @param mapa de usuarios 
	   * @param lista de relaciones 
	   */
	public Calculo(TreeMap<String, Usuario> usuarios, List<Relacion> relaciones) {
		red = new AdjacencyMapGraph<>(false);

		// create vertices
		verts = new TreeMap<String, Vertex<Usuario>>();
		for (Entry<String, Usuario> u : usuarios.entrySet())
			verts.put(u.getKey(), red.insertVertex(u.getValue()));

		// now add edges to the graph
		for (Relacion relacion : relaciones)
			red.insertEdge(verts.get(relacion.getUsuario1().getCodigo()),verts.get(relacion.getUsuario2().getCodigo()), relacion);
	}

	
	  /**
	   * Retorna el grado promedio del grafo, es decir la cantidad total de arcos divivida por la cantidad de vertices.
	   * @return int grado promedio.
	   */

	public int grado() {
		int vertices = red.numVertices();
		int arcos = red.numEdges() * 2;

		return arcos / vertices;
	}

	
	  /**
	   * Retorna una lista de relaciones representando el camino mas corto basado en antiguedad entre 2 usuarios.
	   * @param primer usuario
	   * @param segundo usuario
	   * @return lista de relaciones.
	   */
	public List<Relacion> antiguedad(Usuario usuario1, Usuario usuario2) {
		// copia grafo para agregar peso a los arcos
		Graph<Usuario, Integer> antiguedad = new AdjacencyMapGraph<>(false);
		Map<Usuario, Vertex<Usuario>> res = new ProbeHashMap<>();

		for (Vertex<Usuario> result : red.vertices())
			res.put(result.getElement(), antiguedad.insertVertex(result.getElement()));
		
		
		Vertex<Usuario>[] vert;
		
		for (Edge<Relacion> result : red.edges()) {
			vert = red.endVertices(result);
			antiguedad.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), result.getElement().getTiempo());
		}
		
		PositionalList<Vertex<Usuario>> lista = GraphAlgorithms.shortestPathList(antiguedad, res.get(usuario1),res.get(usuario2));
		
		List<Relacion> relaciones = new ArrayList<Relacion>();
				
		Vertex<Usuario> v1, v2;	
		Position<Vertex<Usuario>> aux = lista.first();
		Integer i = 0;
		while (lista.after(aux) != null) {
			v1 = aux.getElement();			
			aux = lista.after(aux);
			v2 = aux.getElement();
			relaciones.add(i++, red.getEdge(verts.get(v1.getElement().getCodigo()), verts.get(v2.getElement().getCodigo())).getElement());
		}
		
		return relaciones;
	}
	
	
	  /**
	   * Retorna un mapa con la cantidad de conexiones que tiene cada usuario.
	   * @param mapa usuarios
	   * @return usuarios separados por cantidad de conexiones.
	   */
	public TreeMap<Integer, List<Usuario>> centralidad(TreeMap<String, Usuario> usuarios){
		
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		int arcos = 0;
		
		for(Entry<String, Usuario> u: usuarios.entrySet()) {			
			arcos = red.outDegree(verts.get(u.getValue().getCodigo()));
			count.put(u.getKey(), arcos);
		}
		
		TreeMap<Integer, List<Usuario>> frec = new TreeMap<Integer, List<Usuario>>();
		
		
		List<Usuario> l;
		
		for (Entry<String, Integer> i : count.entrySet())
			if ((l = frec.get(i.getValue())) != null) 			
				l.add(0, usuarios.get(i.getKey()));
			else {
				l = new ArrayList<Usuario>();
				l.add(0, usuarios.get(i.getKey()));
				frec.put(i.getValue(), l);
				
			}
		return frec;
	
	}		
}
