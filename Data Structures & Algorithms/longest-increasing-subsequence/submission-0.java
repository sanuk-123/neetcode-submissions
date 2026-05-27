class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n<2){
            return n;
        }
        ArrayList<Integer> list=new ArrayList<>();
        int index=0;
        for(int num:nums){
            if(list.isEmpty()){
                list.add(num);
                continue;
            }
            if(list.get(index)>=num){
                list.remove(index);
                list.add(num);
            }else{
                list.add(num);
                index++;
            }
        }
        return list.size();
    }
}
