

/*

2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class Graph1 {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node1> vertices; // vetor de vertices indexados por 'id'
    public Map<Node1, List<Edge1>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    
    private int[][] distanceMatrix;
    
    public Graph1() {
        init(10);
    }
    public Graph1(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node1>( n );
        
        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node1 v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node1, List<Edge1>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    
    
    public void insertAdj( int u, int v ) {
    	insertAdj( vertices.get(u), vertices.get(v) );
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node1 u, Node1 v ) {
    	List<Edge1> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge1>();
    	}
    	
    	edges.add( new Edge1( u, v ) );
    	
    	edgeByVertices.put(u, edges); 
        edgeTotal++;
    }
    
    /*
    //devolve um vetor com os vizinhos de u
    public Node[] getAdj(Node u) {
        int tote = Adj[u.id].size();
        Node[] vAdj = new Node[tote];
        Iterator it = Adj[u.id].iterator();
        int pos = 0;
        while (it.hasNext()) {
            Node v = (Node)it.next();
            vAdj[pos] = v;
            pos++;
        }
    }
    */

    public void print() {
        Graph1 graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node1, List<Edge1>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge1 edge : entry.getValue() ){
            	System.out.print( edge.getTo().getName() + ", " );
            	madj[ entry.getKey().getId() ][ edge.getTo().getId() ] = 1;
            }
            System.out.println();
        }

        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print( madj[ i ][ j ] + " " );
            }
            System.out.println();
        }
        
        System.out.println( "Total de vertices: " + graph.vertexTotal );
        System.out.println( "Total de arcos: " + graph.edgeTotal );
    }
	
    public void calculateDistanceMatrix() {
    	int i;
    	
    	distanceMatrix = new int[vertexTotal][vertexTotal];
    	
    	i = 0;
    	
    	for( Node1 vertex : vertices.values() ){
    		breadthFirstSearch( vertex );
    		
    		for( Node1 other: vertices.values() ){    		
	    		distanceMatrix[i][ other.getId() ] = other.getDistance();
    		}
    		i++;
    	}
	}
    
    public String getDistanceMatrixForPrint(){
    	int i, j;
    	StringBuilder print = new StringBuilder();
    	
    	for( i = 0; i < vertexTotal; i++ ){
    		for( j = 0; j < vertexTotal; j++ ){
    			print.append( distanceMatrix[i][j] == Integer.MAX_VALUE ? "." : distanceMatrix[i][j] ).append( " " );
    		}
    		print.append("\n");
    	}
    	
    	return print.toString();
    }
    
    private void breadthFirstSearch( Node1 source ){
    	Queue<Node1> queue = new LinkedList<Node1>();
    	
    	for( Node1 node : vertices.values() ){
    		node.setColor( Color.white );
    		node.setDistance( Integer.MAX_VALUE );
    	}
    	
    	source.setDistance( 0 );
    	source.setColor( Color.gray );
    	
    	queue.add(source);
    	
    	Node1 node;
    	while( !queue.isEmpty() ){
    		node  = queue.poll();

    		for( Edge1 edge : edgeByVertices.get( node ) ){
    			if( edge.getTo().getColor().equals( Color.white ) ){
    				edge.getTo().setDistance( node.getDistance() + 1 );
    				edge.getTo().setColor(Color.gray);
    				queue.add(edge.getTo());
    			}
    			node.setColor( Color.black );
    		}
    	}
    }

}

