/**
 * Accepts hexadecimal numbers as input and converts each number to binary
 * and to the decimal equivalent.
 * Valid input examples: F00D, 000a, 1010, FFFF, Goodbye, GOODBYE
 * Enter GOODBYE (case insensitive) to exit the program.
 * 
 * @author Alisha Sonawalla
 * @version 02/20/2017
 */



import java.util.Scanner;


public class HexConversion {

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
    String binString = "";     // Initialize binString to null string
    	
    // Convert each hexadecimal digit to its binary equivalent
    for (int i = 0; i < 4; i++) {
      char thisChar = hexString.charAt(i);
      
      // Convert hexString to a binary string, e.g. F00D = 1111000000001101
         switch (thisChar) {
              case '0': binString+="0000 ";
                      break;
              case '1': binString+="0001 ";
                      break;
              case '2': binString+="0010 ";
                      break;
              case '3': binString+="0011 ";
                      break;
              case '4': binString+="0100 ";
                      break;
              case '5': binString+="0101 ";
                      break;
              case '6': binString+="0110 ";
                      break;
              case '7': binString+="0111 ";
                      break;
              case '8': binString+="1000 ";
                      break;
              case '9': binString+="1001 ";
                      break;
              case 'A': binString+="1010 ";
                        break;
              case 'B': binString+="1011 ";
                        break;
              case 'C': binString+="1100 ";
                        break;
              case 'D': binString+="1101 ";
                        break;
              case 'E': binString+="1110 ";
                        break;
              case 'F': binString+="1111 ";
                        break;
          }
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
         // System.out.println(value);
      }
      return value;
  }
  }

