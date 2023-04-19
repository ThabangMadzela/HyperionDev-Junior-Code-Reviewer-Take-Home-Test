
/**	
 *	a program with a function (isbn13(strNum)) that takes 
 * a string of numbers (possibly with an X at the end) and...
 *
 * Return "Invalid" if it is not a valid ISBN-10 or ISBN-13.
 * Return "Valid" if it is a valid ISBN-13.
 * If it is a valid ISBN-10, convert it into an ISBN-13 and return the ISBN-13 number.
 * 
 * NB. ALL METHODS IN THIS PROGRAM ARE MADE SPECIFICALLY FOR THE FUNCTIONALITY OF THE isbn13(strNum)
 *@author Thabang Thubane
 *@version 19 April 2023
 */

public class ISBN {
    

    /**
     * checks whether the parameter is numeric
     * @param an array 0f integers
     * 
     */
    public   boolean isNumeric(String strNum) {
    
        if (strNum == null) {
            return false;
        }

        //checks if strNum has X at the end...then only take the chars before X as strNum
        if((strNum.length() == 10) && (((Character)strNum.charAt(9)).equals((Character)('X')))){
            strNum = strNum.substring(0, 9);   
        }


        try {
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * multiply digits in strNum with alternating 1s and 3s
     * @param  strNum - string of nums
     * 
     */
    public int byThreeOne(String strNum){
        int sum = 0;

        for(int i = 0; i<strNum.length(); i+=2){

            if((i+1) < strNum.length()){
                sum = sum + (Character.getNumericValue(strNum.charAt((i)))) + (Character.getNumericValue(strNum.charAt((i+1)))*3);
            }
            else{
                sum = sum + (Character.getNumericValue(strNum.charAt((i))));
            }
        }

        return sum;

    }

     /**
     * check if strNum is isbn10 (may have X at the end)
     * @param  strNum - string of nums
     * 
     * 
     */
    public boolean isISBN10(String strNum){
        int sum = 0;

        // like lining up the digits with the numbers 10 to 1
        // and Multiply each digit with the number below it 
        // (the 10th digit in an ISBN can be an X. This last X simply means 10).

        for(int i = 0, z = 10; i<strNum.length() && z > 0; i++, z--){
            if(((Character)strNum.charAt(i)).equals((Character)('X'))){
                sum = sum + (10*z);
            }
            else{
                sum = sum + (Character.getNumericValue(strNum.charAt((i)))*z);
            }
        }

        // verify
        if(sum%11 == 0 ) {  return true;}
        
        return false;

    }

    /**
     * the  key function of this program
     * check if strNum is isbn10 (may have X at the end)
     * @param  strNum - takes a string of numbers (possibly with an X at the end)
     * 
     * @return "Invalid" if it is not a valid ISBN-10 or ISBN-13.
     * @return "Valid" if it is a valid ISBN-13.
     * @return "the ISBN-13 number" If it is a valid ISBN-10, convert it into an ISBN-13 
     * 
     */
    public String isbn13(String input){

        String isbn = "";
        
        //check if numeric 
        if(this.isNumeric(input)){

            // if its isbn10
            if(input.length() == 10 && isISBN10(input)){
                // tacking 978 to the start oth the isbn10 exclude last digit
                int sum = byThreeOne("978"+input.substring(0, input.length()-1));
                
                // checking what the last digit should be changed to
                if(sum%10 == 0){// if remainder is 0 the last is 0
                    isbn = "978" + input.substring(0, input.length() -1) + "0";
                }
                // else last is 10-(remainder)
                else{
                    isbn = "978" + input.substring(0, input.length() -1) + (10-sum%10);
                }

                return isbn;

            }

            // if it is a valid ISBN-13.
            else if(input.length() == 13 && (byThreeOne(input)%10 == 0)){
                return "Valid";
            }
        }
        
        return "Invalid";
        
    }

    public static void main( String [ ] args ){
        var isbn = new ISBN();

        // examples of the functionality
        System.out.println(isbn.isbn13("9780316066525"));
        System.out.println(isbn.isbn13("0330301824"));
        System.out.println(isbn.isbn13("123456789X"));
        System.out.println(isbn.isbn13("0316066524"));

    }

}
