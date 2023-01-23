import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public StackArray(int capacity) {
        this.a = (Item[]) new Object[capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return this.N;
    }

    public void resize(int capacity) {
        assert capacity > 0;

        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void push(Item item) {
        if (this.N == this.a.length) resize(this.a.length * 2);

        a[N++] = item;
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");

        Item item = a[N-1];// PEGA O ULTIMO ELEMENTO
        a[N-1] = null;// TROCA O ULTIMO ELEMENTO POR NULL
        N--;// REDUZ A CAPACIDADE

        return item;
    }


    private class ReverseArrayIterate implements Iterator<Item> {

        private int i;

        public ReverseArrayIterate() {
            i = i - N;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return i >= 0;
        }

        public void remove() {
            throw new NoSuchElementException();
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new UnsupportedOperationException();
            return a[i--];
        }

    }

//	public void varrer() {
//		for (Item s : a) {
//			System.out.print(s + " ");
//		}
//	}


    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ReverseArrayIterate();
    }

    public String toString() {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < N - 1; i++) {
            s.append(a[i]);
            s.append(" - ");
        }

        if (N > 0) {
            s.append(a[N-1]);
        }

        return s.toString();
    }




}