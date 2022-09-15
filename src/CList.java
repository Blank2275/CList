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
            first.addToEnd(elementToAdd);
        }
        length++;
    }
    public Type get(int i){
        ListElement<Type> element = first.getItemNAhead(i);
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


    public void remove(int i){
        ListElement<Type> prior = first.getItemNAhead(i - 1);
        ListElement<Type> toRemove = first.getItemNAhead(i);
        ListElement<Type> next = first.getItemNAhead(i + 1);
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
