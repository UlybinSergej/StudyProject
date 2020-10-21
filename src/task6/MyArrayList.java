package task6;

import java.util.Arrays;

public class MyArrayList<T> {

    private Object[] list;
    private int length;

    public MyArrayList() {
        list = new Object[10];
        length = 0;
    }

    public void add(T t) {
        if (length < 10) {
            list[length] = t;
            length++;
        } else {
            throw new MyArrayStoreException("Массив заполнен!");
        }
    }

    public boolean remove(T t) {
        boolean removeSuccessful = false;
        for (int i = 0; i < length; i++) {
            if (list[i].equals(t)) {
                removeObj(i);
                removeSuccessful = true;
            }
        }
        return removeSuccessful;
    }

    private void removeObj(int i) {
        System.arraycopy(list, i + 1, list, i, length - i - 1);
        list[--length] = null;
    }

    public T[] toArray() {
        return (T[]) Arrays.copyOf(list, length);
    }

    public int size() {
        return length;
    }

    public T get(int i) {
        return (T) list[i];
    }
}

class MyArrayStoreException extends RuntimeException {
    MyArrayStoreException(String msg) {
        super(msg);
    }
}
