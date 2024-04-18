class NumberofTriplets
{//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
    public class Solution {
        class TrieNode {
            int numOfIndex;
            int sumOfIndex;
            TrieNode[] child;
    
            TrieNode() {
                numOfIndex = 0;
                sumOfIndex = 0;
                child = new TrieNode[2];
            }
        }
    
        void insert(TrieNode root, int num, int idx) {
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (root.child[bit] == null) {
                    root.child[bit] = new TrieNode();
                }
                root = root.child[bit];
            }
            root.sumOfIndex += idx;
            root.numOfIndex++;
        }
    
        int Index(TrieNode root, int num, int idx) {
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (root.child[bit] == null) {
                    return 0;
                }
                root = root.child[bit];
            }
            return (root.numOfIndex * idx) - root.sumOfIndex;
        }
    
        public int countTriplets(int[] arr) {
            long ans = 0;
            int XOR = 0;
            TrieNode root = new TrieNode();
    
            for (int i = 0; i < arr.length; i++) {
                insert(root, XOR, i);
                XOR ^= arr[i];
                ans = (ans +Index(root, XOR, i)) % 1000000007;
            }
            return (int) ans;
        }
    }
}