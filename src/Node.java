public class Node {

    public FootballPlayer data;
    public Node next;

    public Node() {
      this(null, null);
    }

    public Node(FootballPlayer player) {
      this(player,null);
    }

    public Node(FootballPlayer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void addNode(FootballPlayer player){
        Node node = new Node(player);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
