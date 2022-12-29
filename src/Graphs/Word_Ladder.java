package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        for (String str : wordList) {
            StringBuilder s = null;
            for (int i = 0; i < str.length(); i++) {
                s = new StringBuilder(str);
                s.setCharAt(i, '*');
                wordList = map.getOrDefault(s.toString(), new ArrayList<String>());
                wordList.add(str);
                map.put(s.toString(), wordList);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        int res = 1;
        StringBuilder s = null;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    s = new StringBuilder(str);
                    s.setCharAt(i, '*');
                    for (String w : map.get(s.toString())) {
                        if (w.equals(endWord))
                            return res;

                        if (vis.contains(w))
                            continue;

                        queue.add(w);
                        vis.add(w);
                    }
                }
            }
        }
        return 0;
    }
}