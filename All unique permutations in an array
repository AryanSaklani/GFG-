class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    static Set<ArrayList<Integer>> set;
    Solution(){
        this.ans =  new ArrayList<>();
        this.set = new HashSet<>();
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
       
        unique_Permutation(arr,n,0);
        
        Collections.sort(ans,(x,y)->{
            for(int i=0;i<x.size();i++){
                if(x.get(i)!=y.get(i)) return x.get(i)-y.get(i);
            }
            return x.get(x.size())-y.get(y.size());
        });
        
        return ans;
    }
    public static void unique_Permutation(ArrayList<Integer> arr,int n,int pos){
        
        if(pos==n){
            if(!set.contains(arr)){
                ans.add(new ArrayList<>(arr));
                set.add(new ArrayList<>(arr));
            }
            return;
        }
        for(int i=pos;i<n;i++){
            swap(arr,pos,i);//Collections.swap(arr,pos,i);
            unique_Permutation(arr,n,pos+1);
            swap(arr,i,pos);//backtracking part
        }
    }
    public static void swap(ArrayList<Integer> arr,int i,int j){
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
}
