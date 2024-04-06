public class sumOfPrefixscores {
    //https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
    static class Trie {
        int count;
        Trie children[];

        Trie() {
            count = 0;
            children = new Trie[26];
        }
    }

    static void insert(String name, Trie root) {
        Trie node = root;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
            node.count++;
        }
    }

    int sumofprefix(String query, Trie root) {
        Trie node = root;int count =0;
        for (int i = 0; i <query.length(); i++) {
            int index = query.charAt(i) - 'a';
             if (node.children[index] == null)
             return 0;
            node = node.children[index];
            count+=node.count;
        }
       return count;
    }

    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        int ar[] = new int[words.length];
        for (String s : words) {
            insert(s, root);
        }
        for (int i = 0; i < words.length; i++) {
               
            ar[i] =sumofprefix(words[i],root);
        }
        return ar;
    }
}

