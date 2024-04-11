import java.util.*;
public class Replacewords {
    //https://leetcode.com/problems/replace-words/description/
    class Solution {
        class Trie {
            Trie children[];
            int lastindex;
    
            Trie() {
                children = new Trie[26];
                lastindex = -1;
            }
        }
    
        void insert(String s, Trie root, int in) {
            Trie node = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (node.children[index] == null)
                    node.children[index] = new Trie();
                node = node.children[index];
            }
            node.lastindex = in;
        }
    
        void query(Trie root,String s,List<String> dict,int in,String[] words)
        {
            Trie node =root;
            for(int i=0;i<s.length();i++)
            {   int index = s.charAt(i) - 'a';
                if(node.children[index]==null)
                {
                    break;
                }
                if(node.lastindex!=-1){
                 String rootword = dict.get(node.lastindex);
                  if(words[in].length()>rootword.length())
                  words[in]=rootword;
               break;}
                 node=node.children[index];
            }
            if(node.lastindex==-1)
            {
                return;
            } String rootword = dict.get(node.lastindex);
           if(words[in].length()>rootword.length())
               words[in]=rootword;
    
        }
    
        public String replaceWords(List<String> dictionary, String sentence) {
            String words[] = sentence.split(" ");
            Trie root = new Trie();
            for (int i = 0; i < dictionary.size(); i++) {
                insert(dictionary.get(i), root, i);
            }
            for (int i = 0; i < words.length; i++) {
                query(root, words[i], dictionary, i, words);
            }
            sentence = "";
            for (int i = 0; i < words.length; i++) {
                sentence += words[i] + " ";
            }
            return sentence.trim();
        }
    }
}
