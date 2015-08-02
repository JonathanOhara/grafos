package Jonathan.exemplo2;

/* 

2015mar26: le um grafo ponderado da entrada padrão e exibe as listas de adjacencia, a matriz de adjacencia, o total de vertices e o total de arcos.

*/



public class Exemplo2 {

    public Exemplo2() {
    }

    public static void main( String args[] ) {
        WGraph G = new WGraph();
        G.read();
        G.print();
    }
}
