import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.lang.reflect.Array;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.ArrayList;
public class binary {

    public static void main(String[] args){
        starterMethod();
    }

    public static void starterMethod(){
        System.out.println("What would you like to convert from decimal? \n 1). Decimal to Binary Number \n 2). Decimal to hexadecimal \n 3). Binary to Decimal \n Enter number value");
        Scanner scanner =  new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case (1):
                System.out.println("Decimal To Binary \n ");
                decimalToBinary();
                // checks if input is 1 and if it is then it will move the program to the decimalToBinary method
                break;

            case (2):
                System.out.println("Decimal to Hexadecimal \n ");
                decimalToHexadecimal();
                // checks if input is 2 and if it is then it will move the program to the decimalToHexadecimal method
                break;

            case (3):
                System.out.println("Binary to Decimal");
                binaryToDecimal();
                // checks if input is 3 and if it is then it will move the program to the binaryToDecimal method
                break;
        }
    }

    public static void decimalToBinary(){
        Scanner scanner1 =  new Scanner(System.in);
        System.out.println("Binary Method \nInsert a number you would like to convert to binary");

        int binary = scanner1.nextInt();

        ArrayList<Integer> array = new ArrayList<>();

        int counter = 0;
        while (binary>0){
            array.add(binary %2);
            binary = binary/2;
            counter++;
        }
        // calculates the remainder of the value inputted when divided by 2 also while that number is greater than zero

        System.out.print("0b");
        // prints "0b" before printing anything else

        for (int y = counter - 1; y >= 0; y--)
            System.out.print(array.get(y));
        /* takes the number of times the while loop repeated to find out how many elements in the array
        and subtracts it by one as java uses zero based indexing */
        // prints the elements of the array in reverse order
    }

    public static void decimalToHexadecimal(){
        Scanner scanner2 = new Scanner(System.in);
        int decimalNumber = scanner2.nextInt();
        int counter1 = 0;
        ArrayList <Integer> array3 = new ArrayList<>();

        while (decimalNumber> 16) {
        array3.add(decimalNumber % 16);
        decimalNumber/=16;
        counter1++;
    } // takes 'decimalNumber' and takes the remainder of it when divided by 16 and stores it into the next available slot in the array.

        array3.add(decimalNumber % 16);
        // takes the remainder of decimalNumber when divided by 16 and stores it in the next slot in the array

        System.out.print("0x");
        // prints "0x" before printing anything else.
        for (int q = counter1; q>=0; q--){
            int newInt = array3.get(q);
            // takes the int stored in the last element of the array

                switch (newInt)   {
                    // checks if 'newInt' is equal to one of the cases below and if it is, it prints the corresponding letter.
                    case (10):{
                        System.out.print("A");
                        break;
                    }
                    case (11):{
                        System.out.print("B");
                        break;
                    }
                    case (12):{
                        System.out.print("C");
                        break;
                    }
                    case (13):{
                        System.out.print("D");
                        break;
                    }
                    case (14):{
                        System.out.print("E");
                        break;
                    }
                    case (15):{
                        System.out.print("F");
                        break;
                    }
                    default :
                        System.out.print(newInt);
                }
                /* prints the elements of the array in reverse order, and checks if a number is greater or equal to 10
                so that it can change it to the corresponding letter. Otherwise, it will just print the number in the array. */
                // counter 1 is not subtracted by one because we have one more division after the for loop.
        }
    }


    public static void binaryToDecimal() {

        Scanner scanner4 = new Scanner(System.in);
        int binary = scanner4.nextInt();
        ArrayList<Integer> divide10Array = new ArrayList<>();
        int b = 0;
        while (binary > 0) {
            divide10Array.add(binary % 10);
            binary /= 10;
            b++;
        }
        // this code converts a series of numbers and splits it into individual numbers and stores it into `divide10Array` ArrayList.

        ArrayList<Integer> reversedArray = new ArrayList<>();
        for (int y = b - 1; y >= 0; y--) {
            reversedArray.add(divide10Array.get(y));
        }
        // reverses the elements of 'divide10Array' and stores it in an ArrayList called 'reversedArray'

        ArrayList<Integer> finalBinaryArray = new ArrayList<>(reversedArray);

        ArrayList<Integer> finalDecimalArray = new ArrayList<>();

        int g = (finalBinaryArray.size()) - 1;
        for (int y=0; y<=finalBinaryArray.size(); y++){
            if (g<0){
                break;
            } else {
                finalDecimalArray.add((finalBinaryArray.get(y)) * (int)Math.pow(2,g));
                g--;
            }
        }
        // this code takes each element from the ArrayList 'finalBinaryArray' and multiplies it by 2 to the power of the number of values in the array minus 1

        int finalNum = 0;
        for (int z=0; z< finalDecimalArray.size(); z++){
            finalNum += (finalDecimalArray.get(z));
        }
        System.out.println("Your number in decimal: " + finalNum);
        // this code adds up all the elements in the ArrayList.
    }
}