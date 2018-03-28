//TODO getMin()

import java.util.Scanner;

public class Stack {

    public static void main( String args[] )
    {
        Scanner in = new Scanner( System.in );
        int size = in.nextInt();
        Stack stack = new Stack(size);
        int opCount = in.nextInt();
        while( opCount > 0 )
        {
            opCount--;
            String choice = in.next();
            switch( choice )
            {
                case "push":
                    int x = in.nextInt();
                    stack.push(x);
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                default:
                    System.out.println("Speak English please!");
            }
        }
    }

    int size, begin, end;
    int a[];
    Stack minStack;

    public Stack( int length )
    {
        this.size = length;
        this.a = new int[this.size];
        this.begin = 0;
        this.end = -1;
        this.minStack = new Stack(this.size);
    }

    void push(int x )
    {
        if( (end == this.size - 1 && begin == 0)  || (begin == end + 1 && end != -1) )
        {
                System.out.println("Stack full. Overwriting the oldest element.");
                end = begin;
                begin++;
                a[end] = x;
        }
        else
        {
            end = (end + 1)%size;
            a[end] = x;
        }
    }

    int pop()
    {
        if( end == -1 )
        {
            System.out.println("Stack Empty.");
            return -1;
        }
        int temp = a[end];
        if( begin == end )
        {
            end = -1;
            begin = 0;
        }
        else
        {
            end = (end - 1);
            if (end < 0)
                end = end + size;
        }
        return temp;
    }


}
