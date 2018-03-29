import java.util.Scanner;

import static java.lang.Math.ceil;

public class MaxHeapSort {
    int tree[];
    int heapSize;

    public static void main(String args[] )
    {
        Scanner in = new Scanner(System.in);
        int size;
        size = in.nextInt();
        int a[] = new int[size];
        for( int i = 0; i < size; i++ )
            a[i] = in.nextInt();
        MaxHeapSort q = new MaxHeapSort(a, size);
    }

    private void copyArray( int a[], int b[], int n )
    {
        for( int i = 0; i < n; i++ )
        {
            a[i] = b[i];
        }
    }

    MaxHeapSort(int a[], int size )
    {
        this.heapSize = size;
        tree = new int[heapSize];
        copyArray(tree, a, heapSize );
        createHeap();
        sort();
    }

    void sort()
    {
        while( heapSize > 0 )
        {
            System.out.print(tree[0] + " ");
            tree[0] = tree[heapSize-1];
            heapSize--;
            heapify(0);
        }
        System.out.println();
    }

    private void createHeap()
    {
        for( int i = heapSize-1; i >= 0; i-- )
        {
            heapify(i);
        }
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
        return (int)ceil(index/2)-1;
    }

    private int leftChild(int index )
    {
        return 2*index + 1;
    }

    private int rightChild(int index )
    {
        return 2*index + 2;
    }

    private void print()
    {
        for( int i = 0; i < heapSize; i++ )
            System.out.print(tree[i]+ " ");
        System.out.println();
    }

}
