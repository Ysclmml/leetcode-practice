package 哈希表.q706_设计哈希映射;

import java.util.LinkedList;
import java.util.List;


/**
 * 键值对数据类型
 * @param <K> 键
 * @param <V> 值
 */
class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}


/**
 * 封装对键值对链表数据的增删改查
 */
class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean isFound = false;
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            bucket.add(new Pair<>(key, value));
        }
    }

    public void delete(Integer key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                bucket.remove(pair);
                break;
            }
        }
    }
}


/**
 * MyHashMap
 * create by yscl on 2020/9/8
 */
public class MyHashMap {
    /** Initialize your data structure here. */

    private int size = 2079; // 底层数组的大小
    private Bucket[] buckets; // 底层存储数据结构

    public MyHashMap() {
        this.buckets = new Bucket[size];
        for(int i = 0; i < size; i++) {
            buckets[i] = new Bucket();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // 普通的取模
        int pos = key % this.size;
        Bucket bucket = this.buckets[pos];
        bucket.update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int pos = key % this.size;
        Bucket bucket = this.buckets[pos];
        return bucket.get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = key % this.size;
        Bucket bucket = this.buckets[pos];
        bucket.delete(key);
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(2, 2);
        map.put(1, 2);
        map.put(3, 2);
        map.put(2, 555);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
        System.out.println(map.get(3));
    }
}
