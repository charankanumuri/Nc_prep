package Back_Tracking;

import java.util.ArrayList;
import java.util.List;

/* A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only. */

public class Restore_IP_Address {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();

        for (int i = 1; i <= 3; i++) {
            if (len - i > 9)
                continue;
            for (int j = i + 1; j <= i + 3; j++) {
                if (len - j > 6)
                    continue;
                for (int k = j + 1; k <= j + 3 && k < len; k++) {
                    int a, b, c, d;
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j));
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255)
                        continue;
                    String ip = a + "." + b + "." + c + "." + d;
                    if (ip.length() < len + 3) continue;
                    res.add(ip);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = restoreIpAddresses(s);

        for (String l : list) {
            System.out.println(l.toString());
        }
    }

}
