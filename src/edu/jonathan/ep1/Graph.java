package edu.jonathan.ep1;

/*

2015mar24: 
.read(): faz a leitura de um grafo pela entrada padrão
.print(): imprime listas de adjacencia e matriz de adjacencia

Node 'int id': indice dos vertices.
Assume v.id de 0..N-1, obedecendo a ordem de insercao dos vertices.

*/

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    protected List<Node> Vl; //lista temporaria para criar Adj
    protected int idV; // temporario para contabilizar indices dos vertices no grafo
    public Node[] vertices; // vetor de vertices indexados por 'id'
    public LinkedList<Node>[] adj; // lista de adjacencia
    public int totV, totE; // total de vertices e arestas no grafo
    
    private int[][] distanceMatrix;
    
    public Graph() {
        init();
    }
    protected void init() {
        Vl = new LinkedList<Node>();
        idV = 0;
        totE = 0;
    }

    public void addNode( Node v ) {
        Vl.add( v );
        v.setId( idV );
        idV++;
    }
    
    public void initAdj() { //chamar para finalizar insercao de vertices
        totV = Vl.size();
        adj = new LinkedList[ totV ]; // 1 lista de adjacencia para cada vertice
        for (int i = 0; i < totV; i++)
            adj[i] = new LinkedList<Node>();
        // cria vetor indexado de vertices
        vertices = new Node[ totV ];
        Iterator<Node> it = Vl.iterator();
        while (it.hasNext()) {
            Node v = it.next();
            vertices[ v.getId() ] = v;
        }
    }
    
    //insere v na lista de adjacencia de u
    public void insertAdj( Node u, Node v ) {
        adj[ u.getId() ].addLast(v);
        totE++;
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
        Graph G = this;
        int n = G.totV;
        int[][] madj = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                madj[i][j] = 0;
            }
        }
        //System.out.println("\nListas de Adjacencia:");
        for (int i = 0; i < n; i++) {
            Node u = G.vertices[ i ];
            System.out.print( u.getName() + ": " );
            Iterator<Node> it = G.adj[ u.getId() ].iterator();
            while (it.hasNext()) {
                Node v = it.next();
                System.out.print( v.getName() + ", " );
                int j = v.getId();
                madj[i][j] = 1;
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
        
        System.out.println( "Total de vertices: " + G.totV );
        System.out.println( "Total de arcos: " + G.totE );
    }
	
    public void calculateDistanceMatrix() {
    	distanceMatrix = new int[vertices.length][vertices.length];
    	
    	int i = 0;
    	for( Node vertex : vertices ){
    		breadthFirstSearch( vertex );
    		
    		i = 0;
    		for( Node other: vertices ){    		
	    		distanceMatrix[i][ other.getId() ] = other.getDistance();
	    		System.out.print( ( other.getDistance() == Integer.MAX_VALUE ? "." : other.getDistance() )+" ");
    		}
    		System.out.println("");
    		i++;
    	}
	}
    
    private void breadthFirstSearch( Node source ){
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	for( Node node : vertices ){
    		node.setColor( Color.white );
    		node.setDistance( Integer.MAX_VALUE );
    	}
    	
    	source.setDistance( 0 );
    	source.setColor( Color.gray );
    	
    	queue.add(source);
    	
    	Node node;
    	while( !queue.isEmpty() ){
    		node  = queue.poll();

    		for( Node ad : adj[ node.getId() ]){
    			if( ad.getColor().equals( Color.white ) ){
    				ad.setDistance( node.getDistance() + 1 );
    				ad.setColor(Color.gray);
    				queue.add(ad);
    			}
    			node.setColor( Color.black );
    		}
    	}
    }
}

