package Jonathan.exemplo2;

/*

2013out10: v�rtice com distancia para fila de prioridade

*/


public class DistNode extends Node {
    public int d; // indica a distancia
    
    public DistNode(String name, int distance) {
        this.name = name;
        this.d = distance;
    }
}
