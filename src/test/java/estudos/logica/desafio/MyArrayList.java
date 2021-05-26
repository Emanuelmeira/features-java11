package estudos.logica.desafio;


public class MyArrayList<T> {

    private int size;
    private Object[] array = new Object[1];

    public void add(T elemento){

        if(array.length == size){
            array = grow(array);
        }
        array[size] = elemento;
        ++this.size;
    }

    private Object[] grow(Object[] oldArray) {

        Object[] newArray = new Object[oldArray.length + 1];
        this.copyArray(newArray, oldArray, oldArray.length);
        return newArray;
    }

    private void copyArray(Object[] newArray, Object[] oldArray, int length){

        for(int i=0; i< length; i++){
            newArray[i] = oldArray[i];
        }
    }

    public Object get(int index) {

        if(index > array.length){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void remover(int index){

        if(index > array.length){
            throw new IndexOutOfBoundsException();
        }

        for(int i=index; i<array.length-1; i++){
            array[i] = array[i+1];
        }

        Object[] newArray = new Object[array.length-1];
        this.copyArray(newArray, array, array.length-1);
        array = newArray;
    }

    public Object[] getArray() {
        return array;
    }
}
