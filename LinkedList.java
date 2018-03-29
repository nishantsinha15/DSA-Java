import java.util.Scanner;

//TODO reverse in batches of n

class Node{
    int data;
    Node next;
    Node(int data )
    {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    public static void main( String args[] )
    {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        for( int i = 0; i < n; i++ )
        {
            int x = scanner.nextInt();
            list.addNode(x);
        }
        list.head = list.reverseList();
        list.print();
    }

    Node head;

    public LinkedList(Node head)
    {
        this.head = head;
    }

    public LinkedList()
    {
        this.head = null;
    }

    private void addNode(int data )
    {
        Node newNode = new Node(data);
        if( head == null )
        {
            this.head = newNode;
            return;
        }

        Node prev = null;
        Node iter = head;
        while( iter != null )
        {
            prev = iter;
            iter = iter.next;
        }
        prev.next = newNode;
    }

    private void print()
    {
        Node iter = head;
        while( iter != null )
        {
            System.out.println(iter.data);
            iter = iter.next;
        }
    }

    private Node reverseList()
    {
        Node curr, nextNode, prevNode;
        prevNode = null;
        curr = head;
        nextNode = curr.next;
        while( curr.next != null )
        {
            curr.next = prevNode;
//            nextNode.next = curr;
            prevNode = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        curr.next = prevNode;
        return curr;
    }

}
