package edu.tvv;

import edu.tvv.service.Service;

/*
* Returns a new string version of the current string where the alphabetical characters specified in the given are, are removed.
The alphabetical characters to be removed are case insensitive.
* All non-alphabetical characters are unaffected.
If the current string is null, empty, or has not been set to a value, this method should return an empty string.
*
Example(s);
For a current string "my lucky numbers are 6, 8, and 19.", calling remove("ra6") would return "my lucky numbes e 6, 8, nd 19."
For a current string "my lucky numbers are 6, 8, and 19.", calling remove("6,.") would return "my lucky numbers are 6, 8, and 19."
For a current string "my lucky numbers are 6, 8, and 19.", calling remove("") would return "my lucky numbers are 6, 8, and 19."
Remember: This method builds and returns a new string, and does not directly modify the myString field.

* @param arg the string containing the alphabetical characters to be removed from the current string
* @return new string in which the alphabetical characters specified in the args are removed
* */
public class App {
    public static void main(String[] args) {
//        String inputString = "my lucky numbers are 6, 8, and 19.";
        String inputString = "my lucky nUmbeRs are 6, 8, and 19.";
//        String inputString = null;
//        String charsToRemove = "ra6";
        String charsToRemove = "RAyrRyY 62u";
//        String charsToRemove = "";

        System.out.printf("Return: [%s]%n", new Service(inputString).removeChars(charsToRemove));
    }
}
