package Arrays_Hashing;

import java.util.ArrayList;
import java.util.List;

public class Encode_Decode_Strings {
    
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            // sb.append(str.length());
            sb.append(str + "~");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        String[] arr = s.split("~");
        List<String> res = new ArrayList<>();
        if(arr.length == 0) return res;
        for(String str: arr) {
            res.add(str);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("very");
        list.add("bad");
        list.add("fate");


        String encode = encode(list);
        List<String> decode = decode(encode);

        System.out.println(encode);
        System.out.println(decode.toString());
    }
    
}
