

/*

// 1 lista de adjacencia para cada vertice2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graph3 {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node3> vertices; // vetor de vertices indexados por 'id'
    public Map<Node3, List<Edge3>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    private int dfsTime;
    
    private StringBuilder expression;
    
    public Graph3() {
        init(10);
    }
    public Graph3(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node3>( n );
        
        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node3 v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node3, List<Edge3>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    public void insertAdj( int u, int v ) {
    	insertAdj( vertices.get(u), vertices.get(v) );
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node3 u, Node3 v ) {
    	List<Edge3> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge3>();
    	}
    	
    	edges.add( new Edge3( u, v ) );
    	
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
        Graph3 graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node3, List<Edge3>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge3 edge : entry.getValue() ){
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
	
    
    public void calculateDFS( ){
    	List<Node3> vertexList = new ArrayList<Node3>( vertices.values() ); 
    	executeDfs( vertexList );
    	invertEdges();
    	executeDfs( orderVertexByDfsEndTime( vertexList ) );
    }
    
    private List<Node3> orderVertexByDfsEndTime(List<Node3> vertexList) {
    
    	Collections.sort(vertexList, new Comparator<Node3>(){
			@Override
			public int compare(Node3 o1, Node3 o2) {
				return ( Integer.compare( o1.getDfsEndTime(), o2.getDfsEndTime() ) * - 1 );
			}
    		
    	});
		return vertexList;
	}
	private void invertEdges() {
		List<List<Edge3>> allEdgeList = new ArrayList<List<Edge3>>( edgeByVertices.values() );
		
		edgeByVertices.clear();
		
    	for( List<Edge3> edges : allEdgeList ){
    		for( Edge3 edge : edges){
    			edge.invertFromTo();
    			insertAdj( edge.getFrom(), edge.getTo() );
    		}
    	}
		
	}
	private void executeDfs( List<Node3> vertexList ){
		expression = new StringBuilder(); 
    	dfsTime = 0;
    	
    	for(Node3 vertex : vertexList){
    		vertex.setColor( Color.white );
    	}
    	for(Node3 vertex : vertexList){
    		if( vertex.getColor().equals( Color.white ) ){
    			dfs(vertex);
    		}
    	}
    }
    
    private void dfs(Node3 vertex){
    	dfsTime++;
    	
    	expression.append("(").append( vertex.getName() ).append(" ");
    	
    	vertex.setDfsTime( dfsTime );
    	vertex.setColor( Color.gray );
    	
    	List<Edge3> edgeList = edgeByVertices.get(vertex);
    	
    	if( edgeList != null ){
	    	for( Edge3 edge: edgeList ){
	    		if( edge.getTo().getColor().equals( Color.white ) ){
	    			dfs( edge.getTo() );
	    		}
	    	}
    	}
    	
    	dfsTime++;
    	
    	vertex.setDfsEndTime( dfsTime );
    	vertex.setColor( Color.black );
    	
    	expression.append(vertex.getName()).append(") ");
    }
    
    public String getDFSExpression(){
    	return expression.toString().trim();
    }
}






