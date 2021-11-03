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
        // creates new scanner object and gets an input from user and stores it in 'input'
        switch (input) {
            case (1): {
                System.out.println("Decimal To Binary \n ");
                decimalToBinary();
                // checks if input is 1 and if it is then it will move the program to the decimalToBinary method
            }
            case (2): {
                System.out.println("Decimal to Hexadecimal \n ");
                decimalToHexadecimal();
                // checks if input is 2 and if it is then it will move the program to the decimalToHexadecimal method
            }
            case (3): {
                System.out.println("Binary to Decimal");
                binaryToDecimal();
                // checks if input is 3 and if it is then it will move the program to the binaryToDecimal method
            }
        }
    }

    public static void decimalToBinary(){
        Scanner scanner1 =  new Scanner(System.in);
        // created new scanner object

        System.out.println("Binary Method \nInsert a number you would like to convert to binary");

        int binary = scanner1.nextInt();
        // gets input from user and stores it in 'binary'

        int[] array = new int[45];
        // creates an array with size 45

        int counter = 0;
        while (binary>0){
            array[counter] = binary %2;
            binary = binary/2;
            counter++;
        }
        // calculates the remainder of the value inputted when divided by 2 also while that number is greater than zero

        System.out.print("0b");
        // prints "0b" before printing anything else

        for (int y = counter - 1; y >= 0; y--)
            System.out.print(array[y]);
        /* takes the number of times the while loop repeated to find out how many elements in the array
        and subtracts it by one because java uses zero based indexing */
        // prints the elements of the array in reverse order
    }

    public static void decimalToHexadecimal(){
        Scanner scanner2 = new Scanner(System.in);
        int decimalNumber = scanner2.nextInt();
        // creates a new scanner object and is used to get an input from user that is stored in 'decimalNumber'

        int counter1 = 0;
        // creates a counter variable

        int[] array3 = new int[45];
        // creates a new array with size 45

        while (decimalNumber> 16) {
        array3[counter1] = decimalNumber % 16;
        // takes 'decimalNumber' and takes the remainder of it when divided by 16 and stores it into the next available slot in the array.

        decimalNumber/=16;
        // divides 'decimalNumber' by 16

        counter1++;
        // increases counter variable by 1
    }
        array3[counter1] = decimalNumber % 16;
        // takes the remainder of decimalNumber when divided by 16 and stores it in the next slot in the array

        System.out.print("0x");
        // prints "0x" before printing anything else.
        for(int q = counter1; q>=0; q--){
            int newInt = array3[q];
            // takes the int stored in the last element of the array

            if (newInt == newInt) {
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
    }


    public static void binaryToDecimal() {

        Scanner scanner4 = new Scanner(System.in);
        int binary = scanner4.nextInt();
        // scanner object
        ArrayList<Integer> divide10Array = new ArrayList<Integer>();
        int b = 0;
        while (binary > 0) {
            divide10Array.add(binary % 10);
            binary /= 10;
            b++;
        }
        // this chunk of code converts a series of numbers and splits it into individual numbers and stores it into `divide10Array` ArrayList.

        ArrayList<Integer> reversedArray = new ArrayList<Integer>();
        int p = 0;
        for (int y = b - 1; y >= 0; y--) {
            reversedArray.add(divide10Array.get(y));
           // System.out.print(reversedArray.get(p));
            p++;
        }
        // reverses the elements of 'divide10Array' and stores it in an ArrayList called 'reversedArray'

        ArrayList<Integer> finalBinaryArray = new ArrayList<Integer>();
        for (int u = 0; u< reversedArray.size(); u++) {
            finalBinaryArray.add(reversedArray.get(u));
            // System.out.print("  " + finalBinaryArray.get(u));
        }
        /*
        This code takes the reversed array and adds it to the ArrayList finalBinaryArray.
        Here I could have said:
        ArrayList<Integer> finalBinaryArray = new ArrayList<Integer>(reversedArray);
        to add the elements from the reversed array to the final binary array.
        I did not have to cycle through each element in the array to store it in another.
         */

        ArrayList<Integer> finalDecimalArray = new ArrayList<Integer>();
        int g = (finalBinaryArray.size()) - 1;
        for (int y=0; y<=finalBinaryArray.size(); y++){
            if (g<0){
                break;
            } else {
                finalDecimalArray.add((finalBinaryArray.get(y)) * (int)Math.pow(2,g));
                // System.out.print(finalDecimalArray.get(y) + " ");
                g--;
            }
        }
        // this code takes each element from the ArrayList 'finalBinaryArray' and multiplies it by 2 to the power of the number of values in the array minus 1

        int add = 0;
        for (int z=0; z< finalDecimalArray.size(); z++){
            add += (finalDecimalArray.get(z));
        }
        System.out.println("Your number in decimal: " + add);
        // this code adds all the elements in the ArrayList.
    }
}