public class CList <Type> {
    private int length = 0;
    private ListElement<Type> first = null;
    public CList(){

    }

    public CList(Type[] values){
        for(Type val: values){
            add(val);
        }
    }

    public int getLength(){
        return length;
    }
    public void add(Type value){
        ListElement<Type> elementToAdd = new ListElement<Type>(value);
        if(first == null){
            first = elementToAdd;
        } else {
            getItemNAhead(length - 1).addToEnd(elementToAdd);
        }
        length++;
    }
    public Type get(int i){
        if(i >= length || i < 0) throw new IndexOutOfBoundsException(String.format("index %s out of bounds for length %s", i, length));
        ListElement<Type> element = getItemNAhead(i);
        return element.getValue();
    }
    public void removeValue(Type value){
        removeValueFunctionality(value, -1);
    }
    public void removeValue(Type value, int times){
        removeValueFunctionality(value, times);
    }
    private void removeValueFunctionality(Type value, int times){
        int[] toRemove = new int[length];
        int numToRemove = 0;
        for(int i = length - 1; i >= 0; i--){
            if(get(i).equals(value)){
                remove(i);
            }
        }
//        int starting = Math.min(times - 1, numToRemove);
//        if(times == -1) starting = numToRemove - 1;
//
//        for(int i = starting; i >= 0; i++){
//            remove(toRemove[i]);
//        }
    }

    private ListElement<Type> getItemNAhead(int n){
        ListElement<Type> current = first;
        while(n > 0){
            if(current.next != null) current = current.next;
            else return null;
            n--;
        }
        return current;
    }


    public void remove(int i){
        if(i >= length || i < 0) throw new IndexOutOfBoundsException(String.format("index %s out of bounds for length %s", i, length));
        ListElement<Type> prior = getItemNAhead(i - 1);
        ListElement<Type> toRemove = getItemNAhead(i);
        ListElement<Type> next = getItemNAhead(i + 1);
        if(i == 0){
            first = next;
        }
        if(prior != null){
            prior.setNext(next);
        }
        if(toRemove != null){
            toRemove = null;
            length--;
        }
    }
    public String toString(){
        int end = Math.min(10, length - 1);
        String res = "";
        if(end > 0){
            for(int i = 0; i <= end; i++){
                res += String.format("%s: %s \n", i, get(i));
            }
        }
        if(length > 100){
            res += "... \n";
        }
        return res;
    }
}
