class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map= new HashMap<>();
        
        fill(root, map);
        
        int max=0;
        int size=0;  
        
        for(Map.Entry<Integer, Integer> ele : map.entrySet())
        {  
            if(ele.getValue()> max) max=ele.getValue();
        }
        
        for(Map.Entry<Integer, Integer> ele : map.entrySet())
        {
            if(ele.getValue()==max) size++;
        }
        
        int res[]= new int[size]; int i=0;  
        
        for(Map.Entry<Integer, Integer> ele : map.entrySet())
        {  
            if(ele.getValue()==max) {
                res[i]=ele.getKey();
                i++;
            }
        }
        
        return res;
        
    }
	
    public void fill(TreeNode root, HashMap<Integer, Integer> map)
    { 
        if(root==null) return;
        else
        {
            if(map.containsKey(root.val))
            {
                map.put(root.val, map.get(root.val)+1);
            }
            else
            {
                map.put(root.val, 1);
            }
        }
        
        fill(root.left, map);
        fill(root.right, map);
    }
}
