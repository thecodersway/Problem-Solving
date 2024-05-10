class holdingHands
{
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        djs(row.length);
        for(int i=0 ; i<row.length ;i= i+2){
            union(row[i],row[i+1]);
        }
        int count = 0;
        for(int i=0 ; i<n ; i=i+2){
            if(union(i,i+1)){
                count ++;
            }
        }
        return count;
    }
    int [] parent = new int [100];
    void djs(int n){
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
    }
    int find(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    boolean union (int u, int v){
        u = find(u);
        v = find(v);
        if(u!=v){
            parent[v]  = u;
            return true; 
        }
        return false;
    }
    }
