package Greedy;

public class Valid_Paranthesis_String {
    public boolean checkValidString(String s) {
        int cmax = 0, cmin = 0; // ('s count in range [cmin, cmax]
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cmin++;
                cmax++;
            } else if (ch == ')') {
                cmin--;
                cmax--;
            } else {
                cmax++; // if * => (
                cmin--; // if * => )
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            if (cmax < 0)
                return false; // ('s are less than )'s

            cmin = Math.max(cmin, 0); // Invalid if open paranthesis count < 0
                                      // so cmin can be just 0 if cmin < 0.
        }
        return cmin == 0;
    }
}
