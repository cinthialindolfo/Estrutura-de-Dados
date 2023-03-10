import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a; // array of items
    private int N; // number of elements on stack -- número de elementos na pilha
    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
        N = 0;
    }
    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return N;
    }
    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;

        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(Item item) { // prototipo --
        if (N == a.length) resize(2*a.length); // double size of array if necessary
        a[N] = item;
        N++; // add item
    }
    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[N-1];
        a[N-1] = null; // to avoid loitering
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[N-1];
    }
    /**
     * Returns an iterator to this stack that iterates through the items in LIFO
     order.
     * @return an iterator to this stack that iterates through the items in LIFO
    order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator() {
            i = N-1;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
//    public static void main(String[] args) {
//        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
//
//        Scanner myScan = new Scanner(System.in);
//        String line,tmp;
//        StringTokenizer mytk;
//        while(myScan.hasNext()){
//            line = myScan.next();
//            mytk = new StringTokenizer(line);
//            tmp = mytk.nextToken();
//            if(tmp.equals("-")) {
//                if(!s.isEmpty()) System.out.print(s.pop()+" ");
//            }
//            else{
//                s.push(tmp);
//            }
//        }
//        System.out.println("Sobraram "+s.size()+" Elementos na Pilha");
//    }
    public static void main(String[] args){
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) s.push(item);
            else if(s.isEmpty()) StdOut.print(s.pop() + " ");

        }
        StdOut.println("(" + s.size() + "left on stack)");
        for(String nome: s) StdOut.print(nome+"\n");
    }
}