public class MaximumXORof2Numbres {
    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    class Trie{
        Trie left;
        Trie right;
    }
    void insert(Trie root,int n)
    {
        Trie temp=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(n>>i)&1;
            if(bit==0)
            {
                if(temp.left==null)
                temp.left=new Trie();
                temp=temp.left;
            }
            else
            {
                if(temp.right==null)
                temp.right=new Trie();
                temp=temp.right;
            }
        }
    }
    int maxxor(Trie root,int num)
    {   int result=0;
        Trie node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(bit==0)
            {
                if(node.right!=null)
                {
                   result+=(int)Math.pow(2,i);
                   node=node.right; 
                }
                else
                node=node.left;
            }
            else
            {
              if(node.left!=null)
                {
                   result+=(int)Math.pow(2,i);
                   node=node.left; 
                }
                else
                node=node.right;  
            }
        }return result;
    }
    public int findMaximumXOR(int[] nums) {
        Trie root=new Trie();
        for(int i=0;i<nums.length;i++)
        {
            insert(root,nums[i]);
        }int ans=0;
        for(int i=0;i<nums.length;i++)
        {
         ans=Math.max(ans,maxxor(root,nums[i]));
        }return ans;
    }
}