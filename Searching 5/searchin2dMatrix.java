public class searchin2dMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/submissions/1211736998/
    
        static boolean blackbox(int matrix[][],int mid,int t)
        {
            int start=0,end=matrix[0].length-1;
            while(start<=end)
            {
                int m=start+(end-start)/2;
                if(matrix[mid][m]==t)
                return true;
                else if(matrix[mid][m]<t)
                start=m+1;
                else
                end=m-1;
            }return false;
    
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            int start=0;int end=matrix.length-1;
            while(start<=end)
            {
                int mid=start+(end-start)/2;
                if(matrix[mid][0]<=target&&matrix[mid][matrix[0].length-1]>=target)
                {
                return  blackbox(matrix,mid,target); 
                }
                else if(matrix[mid][0]<target)
                start=mid+1;
                else
                end=mid-1;
             }return false;
        }
    }

