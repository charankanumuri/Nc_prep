package Binary_Searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time_Based_Key_Val_Store {

    Map<String, List<Pair>> map;

    public Time_Based_Key_Val_Store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        return search(map.get(key), timestamp);
    }

    public String search(List<Pair> list, int timestamp) {
        // Given : All the timestamps timestamp of set are strictly increasing.
        // So Binary Search Can be applied
        String res = "";
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                res = list.get(mid).getKey();
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }

    public class Pair {
        String key;
        Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

    }
}
