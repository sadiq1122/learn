package interview;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public long getMinCost(char a, char b, char[] original, char[] changed, int[] cost) {
        long result = Integer.MAX_VALUE;

        for (int i = 0; i < changed.length; i++) {
            if (changed[i] == b) {
                if (original[i] == a) {
                    result = Math.min(result, cost[i]);
                } else {
                    long temp = Integer.MAX_VALUE;
                    while(true){
                    char tempSource = original[i];
                    
                    }

                }
            }
        }

        return 1;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost = 0;


        for (int i = 0; i < source.length(); i++) {
            char sourceChar = source.charAt(i);
            char targetChar = target.charAt(i);
            if (sourceChar != targetChar) {

            }
        }

        return 1;
    }

    public static void main(String[] args) {

    }
}