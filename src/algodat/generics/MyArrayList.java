package algodat.generics;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] innerarray; // Daten-Feld
    private int pos;  // Aktuelle Position im Array
    private int size; // Größe des Array

    public MyArrayList() {
        size = 10;
        pos = 0;
        innerarray = new Object[size];
        }

    private class MyIterator<T> implements Iterator<T> {
        // Vor dem Array => -1
        private int actualpos = -1;

        @Override
        public boolean hasNext() {
            return actualpos < pos - 1;
        }

        @Override
        public T next() {
            actualpos++;

            if(actualpos > pos) {
                throw new NoSuchElementException();
            }

            return (T)innerarray[actualpos];
        }
    }



    public void add(T elem) {

        if(pos < size) {
            innerarray[pos] = elem;
            pos++;
        } else {
            // Array ist voll
            // Neues Array mit doppelter Größe erzeugen
            // Alte Elemente ins neue Array kopieren

            // innerarray = Arrays.copyOf(innerarray, size*2);

            Object newarray[] = new Object[size*2];
            System.arraycopy(innerarray,0,newarray,0,size);
            size *=2;
            innerarray = newarray;
            innerarray[pos] = elem;
            pos++;
        }

    }
    public T get(int index) {
        if(index >=0 && index < size) {
            return (T) innerarray[index];
        } else {
            throw new IndexOutOfBoundsException("Index außerhalb der Grenzen");
        }
    }
    public void remove(T elem) {
        int found = -1;
        for(int i = 0; i < pos;i++) {
            if(elem.equals(innerarray[i])) {
                innerarray[i] = null;
                found = i;
                break;
            }
        }
        if(found != -1 ){
            for(int i = found; i < pos; i++) {
                innerarray[i] = innerarray[i+1];
            }
            pos--;
        }
    }

    public int length() {
        return pos;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
