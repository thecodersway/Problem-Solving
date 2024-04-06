public class ImplementTrie {
    //https://leetcode.com/problems/implement-trie-prefix-tree/description/
    class Trie{
    boolean isEnd;
    Trie children[];
  public Trie() {
    isEnd=false;
    children=new Trie[26];
    } 
  public void insert(String word) {
      Trie node=this;
      for(int i=0;i<word.length();i++)
      {
      int index=word.charAt(i)-'a';
      if(node.children[index]==null)
      {
          node.children[index]=new Trie();
      }
      node=node.children[index];
      }
      node.isEnd=true;
  }
  
  public boolean search(String word) {
       Trie node=this;
    for(int i=0;i<word.length();i++)
      {
      int index=word.charAt(i)-'a';
      if(node.children[index]==null)
      {
          return false;
      }
      node=node.children[index];
      }
      if(node.isEnd)
       return true;
       return false;  
  }
  
  public boolean startsWith(String prefix) {
       Trie node=this;
    for(int i=0;i<prefix.length();i++)
      {
      int index=prefix.charAt(i)-'a';
      if(node.children[index]==null)
      {
          return false;
      }
      node=node.children[index];
      }
       return true; 
  }
}
}
