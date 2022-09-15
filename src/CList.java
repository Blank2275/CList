public class CList <Type> {
    private int length = 0;
    private ListElement<Type> first = null;
    public CList(){

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

    public void remove(int i){
        ListElement<Type> prior = first.getItemNAhead(i - 1);
        ListElement<Type> toRemove = first.getItemNAhead(i);
        ListElement<Type> next = first.getItemNAhead(i + 1);
        prior.next = next;
        if(toRemove != null){
            toRemove = null;
            length--;
        }
    }
    public String toString(){
        int end = Math.min(100, length - 1);
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
