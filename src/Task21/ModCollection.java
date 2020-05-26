package Task21;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ModCollection<T> extends AbstractCollection {
    private T[] arr;
    int last;

    public ModCollection(T[] arr) {
        this.arr = arr;
        this.last = 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return arr.length > cursor;
            }

            @Override
            public T next() {
                try {
                    T el = arr[cursor];
                    cursor++;
                    return el;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new java.util.NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                T[] new_arr = (T[]) new Object[size() - 1];

                for (int i = 0; i < arr.length - 1; i++) {
                    new_arr[i] = arr[i];
                }
                arr = new_arr;
            }
        };
        return iterator;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean add(Object o) {
        T[] new_arr = (T[]) new Object[size() + 1];
        for (int i = 0; i < size(); i++) {
            new_arr[i] = arr[i];
        }
        new_arr[arr.length] = (T) o;
        arr = new_arr;
        return true;
    }

    public T getLast() {
        return arr[last];
    }

    public T get(T i){
        return arr[(int) i];
    }

    public void sout() {
        System.out.println();
        for (int i = 0; i < size(); i++)
            System.out.println(arr[i]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModCollection)) return false;
        ModCollection<?> that = (ModCollection<?>) o;
        return last == that.last &&
                Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(last);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        return "ModCollection{" +
                "arr=" + Arrays.toString(arr) +
                ", last=" + last +
                '}';
    }
}
