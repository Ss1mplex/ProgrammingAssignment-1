package regextoNFA;

public class Node {

    private int id;
    private static int ID=0;

    public Node() {
        this.id = ID++;
    }



    @Override
    public String toString() {
        return id+"";
    }

}


