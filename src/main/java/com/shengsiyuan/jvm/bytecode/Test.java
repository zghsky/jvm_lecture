package com.shengsiyuan.jvm.bytecode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbccc"));
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(9);
        list.sort((x, y) -> x - y);
        System.out.println(list);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) return false;
        boolean[][] visited = new boolean[n1 + 1][n2 + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (tmp[0] == n1 && tmp[1] == n2) return true;
            if (tmp[0] < n1 && s1.charAt(tmp[0]) == s3.charAt(tmp[0] + tmp[1]) && !visited[tmp[0] + 1][tmp[1]]) {
                visited[tmp[0] + 1][tmp[1]] = true;
                queue.offer(new int[]{ tmp[0] + 1, tmp[1] });
            }
            if (tmp[1] < n2 && s2.charAt(tmp[1]) == s3.charAt(tmp[0] + tmp[1]) && !visited[tmp[0]][tmp[1] + 1]) {
                visited[tmp[0]][tmp[1] + 1] = true;
                queue.offer(new int[]{ tmp[0], tmp[1] + 1 });
            }
        }
        return false;
    }
}
