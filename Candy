class Solution {
    static int minCandy(int N, int ratings[]) {
        
       Map<Integer, Integer> candyMap = new HashMap<>();
        int[] l = new int[N];
        int[] r = new int[N];

        l[0] = 1;
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 1;
            }
        }

        r[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.max(l[i], r[i]);
            candyMap.put(i, Math.max(l[i], r[i]));
        }

        return ans;
    
    }
}
