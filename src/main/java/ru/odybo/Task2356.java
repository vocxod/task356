package ru.odybo;

/**
 *
 *
 */
public class Task2356 
{
    public static void main (String[] args) {
        System.out.println("Check work");
        byte[] byteArray = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
        // byte[] subString;
        AsciiCharSequence subSec;
        AsciiCharSequence main = new AsciiCharSequence(byteArray);
        subSec = main.subSequence(0, 2);
        System.out.print("Main: ");
        System.out.println(main.toString());
        System.out.print("SubSec: ");
        System.out.println(subSec);
    }
}
