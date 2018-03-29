import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class MaxPriorityQueue {
    int tree[];
    int heapSize;
    int maxSize;

    public static void main(String args[] )
    {
        Scanner in = new Scanner(System.in);
        int opCount = in.nextInt();
        MaxPriorityQueue q = new MaxPriorityQueue();
        while( opCount-- > 0 )
        {
            String choice = in.next();
            switch( choice )
            {
                case "insert":
                    int x = in.nextInt();
                    q.insert(x);
                    q.print();
                    break;
                case "increase":
                    int index = in.nextInt();
                    int val = in.nextInt();
                    q.increaseKey(index, val);
                    q.print();
                    break;
                case "pop":
                    System.out.println(q.extractMax());
                    q.print();
                    break;
                default:
                    System.out.println("Speak English please!");
            }
        }
    }

    MaxPriorityQueue()
    {
        maxSize = 100000;
        tree = new int[maxSize];
        heapSize = 0;
    }

    int maximum()
    {
        return tree[0];
    }

    int extractMax()
    {
        int temp = tree[0];
        tree[0] = tree[heapSize-1];
        heapSize--;
        heapify(0);
        return temp;
    }
    void insert( int x )
    {
        tree[heapSize] = Integer.MIN_VALUE;
        heapSize++;
        increaseKey( heapSize-1 , x );
    }

    void increaseKey( int index, int newValue )
    {
        tree[index] = newValue;
        System.out.println(index + " " + parent(index));
        while( index > 0 && tree[index] > tree[parent(index)] )
        {
            int temp = tree[index];
            tree[index] = tree[parent(index)];
            tree[parent(index)] = temp;

            index = parent(index);
        }
    }


    private void print()
    {
        for( int i = 0; i < heapSize; i++ )
            System.out.print(tree[i]+ " ");
        System.out.println();
    }



    private void heapify(int i)
    {
        int largest = i;
        if( leftChild(i) < heapSize && tree[i] < tree[leftChild(i)] )
            largest = leftChild(i);
        if( rightChild(i) < heapSize && tree[largest] < tree[rightChild(i) ] )
            largest = rightChild(i);

        if( largest != i )
        {
            int temp = tree[i];
            tree[i] = tree[largest];
            tree[largest] = temp;
            heapify(largest);
        }
    }

    private int parent(int index)
    {
        return (int)ceil(index/2.0)-1;
    }

    private int leftChild(int index )
    {
        return 2*index + 1;
    }

    private int rightChild(int index )
    {
        return 2*index + 2;
    }
}
