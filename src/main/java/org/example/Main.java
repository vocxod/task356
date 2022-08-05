/**
 * License - none.
 */
package org.example;


import java.util.Scanner;

/**
 * Main class.
 * @author VraGos
 */
public final class Main {

    /**
     *
     * ASCII Special sequence for colored print in console.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Main constructor.
     */
    private Main() {
        System.out.print("Start application");
    }

    /**
     * Start appication.
     * @param args this args not used in progrem.
     */
    public static void main(final String... args) {
        System.out.println("ASCIICharSequence start");
        byte[] byteArray = new byte[128];
        // Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();
        for (int i = 0; i < 128; i++) {
            byteArray[i] = (byte) i;
        }
        AsciiCharSequence asciiCharSequence1 = new AsciiCharSequence(byteArray);
        AsciiCharSequence asciiCharSequence2 = (AsciiCharSequence) asciiCharSequence1
                .subSequence(0, 128);
        for (int j=0; j < 128; j++) {
            System.out.print("[" + j + " :" + asciiCharSequence1.compactSequence[j]);
            System.out.print("=" + asciiCharSequence2.compactSequence[j] + "]");
        }
        // System.out.println("asciiCharSequence2.length=" + asciiCharSequence2.compactSequence.length);

        int startIndex = 0;
        int endIndex = 0;
        int iMaxDepth = 8;
        final int ICOUNT = 16;
        for (int iTer = 0; iTer < iMaxDepth; iTer++) {
            startIndex = iTer * ICOUNT;
            endIndex = (iTer + 1) * ICOUNT - 1;
            System.out.println("Iteration: " + (iTer + 1));
            System.out.println("From index: " + startIndex + " To index: "
                    + endIndex );

            asciiCharSequence2 = (AsciiCharSequence) asciiCharSequence1
                    .subSequence(startIndex, startIndex + ICOUNT);
            if (iTer > 2) {
                System.out.println(ANSI_YELLOW + asciiCharSequence2.toString() + ANSI_RESET);
            }

            System.out.print("AsciiCharSequence 1\n");
            for (int j = 0; j < ICOUNT; j++) {
                System.out.print("[" + asciiCharSequence2.compactSequence[j] + "] ");
            }
            System.out.print("\n");
            System.out.print("AsciiCharSequence 2\n");
            for (int j = startIndex; j < startIndex + ICOUNT; j++) {
               System.out.print("(" + asciiCharSequence1.compactSequence[j] + ") ");
            }
            System.out.print("\n\n");
        }
    }
}
