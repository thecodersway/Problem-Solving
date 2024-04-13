public class countPairsXOR {
    //https://leetcode.com/problems/count-pairs-with-xor-in-a-range/
    class TrieNode {
        int count = 0;
        TrieNode[] children = new TrieNode[2];
    }
    TrieNode root = new TrieNode();
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for (int n : nums) {
            res += (calc(n, low-1) - calc(n, high));
            trieAdd(n);
        }
        return res;
    }

    public int calc(int n, int l) {
        TrieNode node = root;
        int res = 0;
        for (int i = 14; i >= 0; i--) {
            int index = ((n & 1<<i) > 0) ? 1 : 0;
            int target = (index+1) % 2;
            int p = ((l & 1<<i) > 0) ? 1 : 0;
            if (p == 1) {
                if (node.children[target] == null) {
                    return res;
                }
                node = node.children[target];
            } else {
                if (node.children[target] != null) {
                    res += node.children[target].count;
                }
                if (node.children[index] == null) {
                    return res;
                }
                node = node.children[index];
            }
        }
        return res;
    }

    public void trieAdd(int n) {
        TrieNode node = root;
        for (int i = 14; i >= 0; i--) {
            int idx = ((n & 1<<i) > 0) ? 1 : 0;
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.count++;
        }
    }
}
