package tests.collections;

public class MyArrayList<T> {
    private Object[] storage = new Object[10];
    static int index = 0;

    public void add(T element) {
        if (isEnoughSpace(index)) {
            storage[index] = element;
        } else {
            storage = makeAnother();
            storage[index] = element;

        }
        index++;
    }

    public Object get(int index) {
        return storage[index];
    }

    public Object get(T element){
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == element){
                return storage[i];
            }
        }
        return null;
    }

    public void remove(int index) {
        for(int i = index; i < storage.length -1; i++){
            storage[i] = storage[i + 1];
        }
    }

    public void remove(T element) {
        int index = 0;
        for(int i = 0; i < storage.length; i ++){
            if(storage[i] == element){
                index = i;
            }
        }
        for(int i = index; i < storage.length -1; i++){
            storage[i] = storage[i + 1];
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                size = i;
                break;
            }
        }
        return size;
    }

    private boolean isEnoughSpace(int index) {
        if (index == storage.length) {
            return false;
        }
        return true;
    }

    private Object[] makeAnother() {
        Object[] x = new Object[(storage.length * 3) / 2 + 1];
        System.arraycopy(storage, 0, x, 0, storage.length);
        return x;
    }
}
