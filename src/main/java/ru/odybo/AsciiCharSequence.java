/**
 * Licence - none
 */
package ru.odybo;

import java.lang.CharSequence;

/**
 * 
 * ASCII sequence for compact presentation the char data
 * @author VraGos
 */
public class AsciiCharSequence implements CharSequence {

  /**
   * Byte array for store ASCII sequence
   */
  public byte[] value;

  /**
   * Constructor of ASCII sequence
   * @param inArray
   */
  AsciiCharSequence(byte[] inArray) {
      this.value = new byte[inArray.length];
      System.arraycopy(inArray, 0, this.value, 0, inArray.length);
  }

  /**
   * Return the length of this ASCII sequence (count bytes in array)
   * @return
   */
  public int length(){
    return value.length;
  }

  public char charAt(int iIndex){
    char result;
    result = (char)this.value[iIndex];
    return result;
  }

  /**
   * @param start
   * @param end
   * @return AsciiCharSequence from start to end chars.
   */
  public AsciiCharSequence subSequence(int start, int end){
      byte[] byteArray = new byte[end - start];
      System.arraycopy(this.value, start, byteArray, 0, end - start);
      AsciiCharSequence subSequence = new AsciiCharSequence(byteArray);
      return subSequence;
  }
  
  /**
   * 
   * @return Unicode string from inner byte array.
   */
  public String toString() {
      String sResult="";
      char ch;
      for (int i=0; i < this.value.length; i++ ) {
          ch = (char)this.value[i];
          sResult.concat("" + ch);
      }
      return sResult; 
  }

}
