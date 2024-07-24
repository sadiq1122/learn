package interview;

class SubArrayPatternMatching {
    public int countMatchingSubarrays(int[] arr, int[] pattern) {
        int count = 0;
        boolean flag = false;
        int len = pattern.length;
        for (int i = 0; i < arr.length - len; i++) {
            flag = true;
            int j = i + 1;
            for (int k = 0; j <= i + len; j++, k++) {
                if (pattern[k] == 0 && arr[j - 1] != arr[j]) {
                    flag = false;
                    break;
                } else if (pattern[k] == 1 && arr[j - 1] >= arr[j]) {
                    flag = false;
                    break;
                } else if (pattern[k] == -1 && arr[j - 1] <= arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
    }

}

// find