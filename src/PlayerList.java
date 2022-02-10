import java.util.Comparator;

public class PlayerList {

    private Node first;

    public PlayerList() {
        first = null;
    }

    public void add(FootballPlayer player){
        if(first == null){
            first = new Node(player);
        } else{
            Node current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(player);
        }
    }

    public void view(PlayerList player){
        Node current = player.first;
        while(current != null){
            System.out.println(current);
            current = current.next;
        }
    }

    public void sort(Comparator comparator){
       view(new PlayerList());
    }

    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public FootballPlayer get(int index) {
        return nodeAt(index).data;
    }

    private Node nodeAt(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }


    @Override
    public String toString() {
        return first.toString();
    }
}
