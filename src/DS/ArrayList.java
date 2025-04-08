package DS;

import java.util.Arrays;

public class ArrayList<E> {
    public int capacity;
    public int size;
    public Object[] array;

    ArrayList(int capacity,int size) {
        this.capacity = capacity;
        this.size = size;
        this.array = new Object[capacity];
    }

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置非法");
        }
        if(capacity == size) {
            int newCapacity = capacity + (capacity >> 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public E remove(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("删除位置非法");
        E e = (E) array[index];
        for(int i = index;i<size;i++){
            array[i] = array[i+1];
        }
        size--;
        return e;
    }

    public E get(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置");
        return (E) array[index];
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>(100,0);
        arr.add(8,0);
        System.out.println(Arrays.toString(arr.array));
        int s = arr.remove(0);
    }
}
