package Linked_Lists;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    Map<Integer, Node> nodeMap;
    final Node head = new Node();
    final Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        Node node = nodeMap.get(key);
        if(node != null) {
            res = node.val;
            remove(node);
            add(node);
        }
        return res;
    }

    public void remove(Node node) {
        Node node_next = node.next;
        Node node_prev = node.prev;

        node_prev.next = node_next;
        node_next.prev = node_prev;

    }

    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node; 
    }
    
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            node.val = value;
            nodeMap.put(key, node);
            remove(node);
            add(node);
        }else {
            if(nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            nodeMap.put(key, new_node);
            add(new_node);
        }
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }
}