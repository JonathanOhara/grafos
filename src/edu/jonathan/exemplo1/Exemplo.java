package edu.jonathan.exemplo1;

/* 

2015mar24: le um grafo da entrada padrão e exibe as listas de adjacencia, a matriz de adjacencia, o total de vertices e o total de arcos.

*/


public class Exemplo {

    public Exemplo() {
    }

    public static void main( String args[] ) {
        Graph G = new Graph();
        G.read();
        G.print();
    }
}
