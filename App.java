import java.util.Scanner;
import ceph.BinaryConverter;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input base: ");
        BinaryConverter.inputCheck(in);
        int base = in.nextInt();

        System.out.print("Input decimal number: ");
        BinaryConverter.inputCheck(in);
        int decimal = in.nextInt();
        BinaryConverter.fromDecimal(base, decimal);

        System.out.print("Input number to convert to decimal: ");
        String number = in.next();
        BinaryConverter.toDecimal(base, number);

        in.close();

    }
}
