package Arrays_Hashing;

public class Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++; // if found in s
            store[t.charAt(i) - 'a']--; // if found in t
        }

        for (int n : store)
            if (n != 0)
                return false;

        return true;
    }
}
