package edu.jonathan.ep3;

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

public class Graph {
    protected int lastIndex; // temporario para contabilizar indices dos vertices no grafo
    public Map<Integer, Node> vertices; // vetor de vertices indexados por 'id'
    public Map<Node, List<Edge>> edgeByVertices; // lista de adjacencia
    public int vertexTotal, edgeTotal; // total de vertices e arestas no grafo
    private int dfsTime;
    
    private StringBuilder expression;
    
    public Graph() {
        init(10);
    }
    public Graph(int n) {
    	init(n);
	}
	
    protected void init( int n ) {
        vertices = new LinkedHashMap<Integer, Node>( n );
        
        lastIndex = 0;
        edgeTotal = 0;
    }
    
    public void addNode( Node v ) {
        v.setId( lastIndex++ );
        vertices.put( v.getId(), v );
    }
    
    public void initAdj( int m ) { //chamar para finalizar insercao de vertices
        vertexTotal = vertices.size();
        
        edgeByVertices = new LinkedHashMap<Node, List<Edge>>( vertexTotal ); // 1 lista de adjacencia para cada vertice
    }
    
    public void insertAdj( int u, int v ) {
    	insertAdj( vertices.get(u), vertices.get(v) );
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node u, Node v ) {
    	List<Edge> edges = edgeByVertices.get( u );
    	
    	if( edges == null ){
    		edges = new ArrayList<Edge>();
    	}
    	
    	edges.add( new Edge( u, v ) );
    	
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
        Graph graph = this;
        int n = graph.vertexTotal;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }

        for ( Entry< Node, List<Edge>> entry: edgeByVertices.entrySet() ) {
            System.out.print( entry.getKey().getName() + ": " );
            
            for( Edge edge : entry.getValue() ){
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
    	List<Node> vertexList = new ArrayList<Node>( vertices.values() ); 
    	executeDfs( vertexList );
    	invertEdges();
    	executeDfs( orderVertexByDfsEndTime( vertexList ) );
    }
    
    private List<Node> orderVertexByDfsEndTime(List<Node> vertexList) {
    
    	Collections.sort(vertexList, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return ( Integer.compare( o1.getDfsEndTime(), o2.getDfsEndTime() ) * - 1 );
			}
    		
    	});
		return vertexList;
	}
	private void invertEdges() {
		List<List<Edge>> allEdgeList = new ArrayList<List<Edge>>( edgeByVertices.values() );
		
		edgeByVertices.clear();
		
    	for( List<Edge> edges : allEdgeList ){
    		for( Edge edge : edges){
    			edge.invertFromTo();
    			insertAdj( edge.getFrom(), edge.getTo() );
    		}
    	}
		
	}
	private void executeDfs( List<Node> vertexList ){
		expression = new StringBuilder(); 
    	dfsTime = 0;
    	
    	for(Node vertex : vertexList){
    		vertex.setColor( Color.white );
    	}
    	for(Node vertex : vertexList){
    		if( vertex.getColor().equals( Color.white ) ){
    			dfs(vertex);
    		}
    	}
    }
    
    private void dfs(Node vertex){
    	dfsTime++;
    	
    	expression.append("(").append( vertex.getName() ).append(" ");
    	
    	vertex.setDfsTime( dfsTime );
    	vertex.setColor( Color.gray );
    	
    	List<Edge> edgeList = edgeByVertices.get(vertex);
    	
    	if( edgeList != null ){
	    	for( Edge edge: edgeList ){
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






