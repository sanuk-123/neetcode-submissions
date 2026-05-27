class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n<2){
            return n;
        }
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> present=new HashSet<>();
        int index=0;
        for(int num:nums){
            if(list.isEmpty()){
                list.add(num);
                present.add(num);
                continue;
            }
            if(list.get(index)>=num){
                int value=list.get(index);
                list.remove(index);
                list.add(num);
                present.remove(value);
                present.add(num);
            }else if(!present.contains(num)){
                list.add(num);
                present.add(num);
                index++;
            }
        }
        return list.size();
    }
}
