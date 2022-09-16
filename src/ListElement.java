public class ListElement <Type>{
    Type value;
    ListElement<Type> next = null;
    public ListElement(Type value){
        this.value = value;
    }

    public void setNext(ListElement<Type> next){
        this.next = next;
    }


    public void setValue(Type value){
        this.value = value;
    }

    public Type getValue(){
        return value;
    }

    public void addToEnd(ListElement<Type> element){
        if(next != null){
            next.addToEnd(element);
        } else {
            next = element;
        }
    }
//    public ListElement<Type> getItemNAhead(int n){
//        if(n == 0){
//            return this;
//        } else if(next != null){
//            return next.getItemNAhead(n - 1);
//        } else {
//            return null;
//        }
//    }
}
