package Back_Tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].   */

public class Letter_Comb_Phn_Number {

    static Map<Character, String> map = Map.of('0', "", '1', "", '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6',
            "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        String curr = "";
        recursive_call(res, curr, 0, digits);
        return res;
    }

    public static void recursive_call(List<String> res, String curr, int index, String digits) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        } else if (index >= digits.length())
            return;
        else {
            String str = map.get(digits.charAt(index));
            for (char ch : str.toCharArray()) {
                recursive_call(res, curr + ch, index + 1, digits);
            }
        }
    }

    public static void main(String[] args) {

        String digits = "33";
        List<String> res = letterCombinations(digits);
        System.out.println(res.toString());
    }
}
