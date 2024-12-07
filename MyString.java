/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        // String hello = "hello";
        // System.out.println(countChar(hello, 'h'));
        // System.out.println(countChar(hello, 'l'));

    //     System.out.println("sap in space -> " + MyString.subsetOf("sap", "space") + " (expected: true)");
    //     System.out.println("spa in space -> " + MyString.subsetOf("spa", "space") + " (expected: true)");
    //     System.out.println("pass in space -> " + MyString.subsetOf("pass", "space") + " (expected: false)");
    //     System.out.println("c in space -> " + MyString.subsetOf("c", "space") + " (expected: true)");
    //     System.out.println("empty string in anything -> " + MyString.subsetOf("", "anything") + " (expected: true)");

        // System.out.println(randomStringOfLetters(10));
        // System.out.println(randomStringOfLetters(10));
        // System.out.println(randomStringOfLetters(10));

        // System.out.println(remove("committee", "meet") + " (expected: comit)");
        // System.out.println(remove("abc", "abc") + " (expected: )");
        // System.out.println(remove("abc", "b") + " (expected: ac)");



       
     }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch || str.charAt(i) == ch + 32 || str.charAt(i) == ch - 32 ) {
                index++;
            }
        }
        return index;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1 == "") {
            return true;
        }
        int counter = 0;
        String newStr1 = "";
        

        for(int i=0; i < str1.length(); i++){
            char charOfStr1 = (char) str1.charAt(i);
            if (countChar(newStr1, charOfStr1) == 0) {
                newStr1 = newStr1 + charOfStr1;
            }
        }

        for(int i=0; i < newStr1.length(); i++){
            char charOfStr1 = (char) newStr1.charAt(i);
            if (countChar(str2, charOfStr1) == 1) {
                counter++;
            }
            if (counter == str1.length()) {
                return true;
            }
        }        
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newStr1 = "";

        if (str.length() == 0) {
            return " ";
        }

        for(int i=0; i< (str.length() - 1) ; i++){
            newStr1 = newStr1 + str.charAt(i);
            newStr1 = newStr1 + " ";
        }
        newStr1 = newStr1 + str.charAt(str.length()-1);

        return newStr1;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for(int i = 0; i < n; i++ ){
            int rand = (int) (Math.random() * 26) + 97;
            char ch = (char)rand;
            str = str + "" + ch;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String strRturn = "";
        char[] arrCh = new char[str1.length()];

        for(int i = 0; i< arrCh.length; i++){
            arrCh[i] = str1.charAt(i);
        }

        for (int i = 0; i < str2.length(); i++) {
            char checking = str2.charAt(i);
    
            for (int j = 0; j < arrCh.length; j++) {
                if (arrCh[j] == checking) {
                    arrCh[j] = 0; 
                    break;
                }
            }
        }

        for(int i = 0; i < arrCh.length; i++){
            if (arrCh[i] != 0) {
                strRturn = strRturn + arrCh[i];
            }
        }

        return strRturn;
    }
    

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
