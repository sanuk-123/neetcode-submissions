class Solution {
    //length prefix code
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s).append('#');
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        int start=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='#'){
                list.add(str.substring(start,i));
                start=i+1;
            }
        }
        return list;
    }
}
