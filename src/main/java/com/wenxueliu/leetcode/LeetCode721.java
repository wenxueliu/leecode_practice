package com.wenxueliu.leetcode;

import java.util.*;

/**
* @author liuwenxue
* @date 2020-05-21
*/
public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DSU dsu = new DSU();
        Map<String, Integer> email2index = new HashMap<>();
        Map<Integer, String> index2name = new HashMap<>();
        List<String> names = new ArrayList<>();
        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int index = 1; index < account.size(); index++) {
                String email = account.get(index);
                if (!email2index.containsKey(email)) {
                    email2index.put(email, count);
                    index2name.put(count, name);
                    names.add(name);
                    count++;
                }
                dsu.union(email2index.get(account.get(1)), email2index.get(email));
            }
        }
        Map<Integer, List<String>> name2email = new HashMap<>();
        for (String email : email2index.keySet()) {
            int index = dsu.findRoot(email2index.get(email));
            if (name2email.containsKey(index)) {
                name2email.get(index).add(email);
            } else {
                name2email.put(index, new ArrayList<>());
                name2email.get(index).add(email);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : name2email.entrySet()) {
            List<String> ele = new ArrayList<>();
            ele.add(names.get(entry.getKey()));
            List<String> emails =  entry.getValue();
            Collections.sort(emails);
            ele.addAll(emails);
            res.add(ele);
        }
        return res;
    }

    class DSU {
        int []parent;

        DSU() {
            parent = new int[10001];
            for (int index  = 0; index < 10001; index++) {
                parent[index] = index;
            }
        }

        // 比如 1->2 2->4 4->4
        int findRoot(int x) {
            if (parent[x] != x) {
                parent[x] = findRoot(parent[x]);
            }
            return parent[x];
        }

        // parent[1] = 2  parent[2] = 4
        void union(int x, int y) {
            parent[findRoot(x)] = findRoot(y);
        }
    }
}
