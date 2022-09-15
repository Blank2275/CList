public class Main {
    public static void main(String[] args) {
        CList<Integer> squares = new CList<Integer>();
        for(int i = 0; i <= 20; i++) {
            squares.add(i * i);
        }
        squares.remove(2);
        squares.add(21 * 21);
        System.out.println(squares);
    }
}