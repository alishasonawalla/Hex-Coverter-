
/**
 * Accepts hexadecimal numbers as input and converts each 
 * number to binary using an array and to the decimal equivalent.
 * Valid input examples: F00D, 000a, 1010, FFFF, Goodbye, GOODBYE
 *  Enter GOODBYE (case insensitive) to exit the program.
 * 
 * @author Alisha Sonawalla
 * @version 02/25/2017
 */


import java.util.Scanner;

public class HexConversion2 {

   public static void main(String[] args) {
    	
    // Maximum length of input string
    final byte INPUT_LENGTH = 4;
    
    // Initialize to null string
    String userInput = "";                  
    Scanner input = new Scanner(System.in);
    // Process the inputs until GOODBYE is entered
    do {
      // Input a 4 digit hex number
      System.out.print("\nEnter a hexadecimal string, or enter GOODBYE to quit:  ");
      userInput = input.next().toUpperCase();
		  
      // Process the input
      switch (userInput) {
		  
        case "GOODBYE": break;
            
        default:        if (isValidHex(userInput, INPUT_LENGTH)) {
                          // The input is a valid hexadecimal string
				
                          // Convert the hexadecimal string to binary and print the binary number as a string
                          String binVal = hex2Bin(userInput, INPUT_LENGTH);
		                      
                          // Convert the hexadecimal string to decimal and print the decimal number
                          long decVal = hex2Dec(userInput, INPUT_LENGTH);
                          System.out.printf("      0x%s = %s in binary = %d in decimal (unsigned).\n", userInput, binVal, decVal);
                        }
			
                        else {
                          // String is either the wrong length or is not a valid hexadecimal string
                          System.out.printf("      The string %s is not a valid input.\n", userInput);
                        }
                        break;
        }
    } while (!userInput.equals("GOODBYE"));
		
    // Exit the program
    System.out.println("\nGoodbye!");
    input.close();
  }
 
   /**
    * This method validates the input of the hex value.
    * 
    * @param userIn, inputLen takes in the hex value and input length
    * @return isValid boolean value based on the validity of input 
    */
  public static boolean isValidHex(String userIn, byte inputLen) {
    boolean isValid = false;
    	
    // If length of the input string is equal to inputLen, continue with validation,
    // otherwise return false
    if (userIn.length() == inputLen) {
        
      // The length is correct, now check that the characters are legal hexadecimal digits
      for (int i = 0; i < inputLen; i++) {
        char thisChar = userIn.charAt(i);
          
        // Is the character a decimal digit (0..9)? If so, advance to the next character
        if (Character.isDigit(thisChar)) {
          isValid = true;
        }
	        
       else {	
          // Character is not a decimal digit (0..9), is it a valid hexadecimal digit (A..F)?
             if (thisChar >='A' && thisChar <= 'F') {
        	    isValid = true;
        	  }
             else{
            	 return false;
             }
        }
      }
    }
        
    // Return true if the string is a valid hexadecimal string, false otherwise
      return isValid;
  }

 
  /**
   * This method converts the hex number to a binary string
   * 
   * @param userIn, inputLen takes in the hex value and input length
   * @return binString the binary output
   */
  public static String hex2Bin(String hexString, byte inputLen) {
	  String binString = ""; // Initialize binString to null string

	  String[] binValue = {"0000 ","0001 ","0010 ","0011 ", "0100 ", "0101 ", "0110 ", "0111 ", 
			  "1000 ", "1001 ", "1010 ", "1011 ", "1100 ", "1101 ", "1110 ", "1111 "};
	  
	  // Convert hexString to a binary string, e.g. F00D = 1111000000001101
	  for (int i = 0; i < inputLen; i++) {
	  
	 // Convert each hexadecimal digit to a binary string
		  String hexvalues = "0123456789ABCDEF";
		  int b = hexvalues.indexOf(hexString.charAt(i));
	      binString+=binValue[b];
	   }
	  return binString;
  }
  
  
  /**
   * This method converts the hex number to decimal number
   * 
   * @param userIn, inputLen takes in the hex value and input length
   * @return value returns decimal value 
   */
  public static long hex2Dec(String hexString, byte inputLen) {
    	
    // Convert hexadecimal string to decimal, e.g. F00D = 61453 in unsigned decimal
	  String hexvalues = "0123456789ABCDEF";
	  int value = 0;
      for (int i = 0; i < hexString.length(); i++) {
          char c = hexString.charAt(i);
          int d = hexvalues.indexOf(c);
          value = 16*value + d;
      }
      return value;
  }
  }

