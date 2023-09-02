public class Edge {
    private Node begin;
    private Node end;
    private String label;
    public Edge(Node begin, Node end, String label) {
        super();
        this.begin = begin;
        this.end = end;
        this.label = label;
    }
    @Override
    public String toString() {
        return "Edge [begin="+begin+", end="+end+", label="+label+"]";
    }

}
