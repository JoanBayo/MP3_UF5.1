import java.sql.Array;

public class EX1 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
            System.out.println(array[i]);
        }

    }
}
