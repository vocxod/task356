/**
 * License - none.
 */
package org.example;

/**
 * Ascii class imnplement CharSequence.
 * @author VraGos
 */
public class AsciiCharSequence implements CharSequence {

    /**
     * compactSequence stored lower byte from \u0032 unicode chars
     *
     */
     public byte[] compactSequence;

    /**
     *
     * @param asciiArray - Important: each value of array from 0 to 127.
     *                   Only ASCII char codes!
     */
    AsciiCharSequence(byte[] asciiArray) {
        this.compactSequence = new byte[asciiArray.length];
        for (int i =0; i < asciiArray.length; i++ ) {
            this.compactSequence[i] = asciiArray[i];
        }
    }

    /**
     *
      * @return is length of array compactSequence.
     */
    @Override
    public int length() {
        int iLengthCompactSequence = 0;
        iLengthCompactSequence = compactSequence.length;
        return iLengthCompactSequence;
    }

    /**
     *
     * @param i is index of AsciiCharSequence.
     * @return - char from AsciiCharSequence.
     */
    @Override
    public char charAt(int i) {
        if (i < 0 || i >= this.compactSequence.length ) {
            throw new IndexOutOfBoundsException();
        }
        char ch = (char)this.compactSequence[i];
        return ch;
    }

    /**
     *
     * @param i - asciiCharSerqurce start.
     * @param i1 - asciiCharSequence finish.
     * @return - required subsequence.
     */
    @Override
    public CharSequence subSequence(int i, int i1) {
        if ( i < 0 || i > compactSequence.length || i1 < i || i1 > compactSequence.length ) {
            throw new IndexOutOfBoundsException("Check indexes value in params.");
        }
        int jj = 0;
        byte[] returnArray = new byte[i1 - i];
        for ( int j = i; j < i1; j++ ) {
            // System.out.println("j=" + j + " j + (i1 - i)=" + (j + (i1 - i)));
            returnArray[jj] = this.compactSequence[j];
            jj++;
        }
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(returnArray);
        return asciiCharSequence;
    }

    /**
     *
     * @return String from byteArray to UFT8 view.
     */
    @Override
    public String toString() {
        String sResult = "";
        for (int i=0; i < this.compactSequence.length; i++) {
            char sVal = (char) this.compactSequence[i];
            sResult = sResult.concat(String.valueOf(sVal));
        }
        return sResult;
    }

}
