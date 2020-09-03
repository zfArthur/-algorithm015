//解法一暴力版，业务拓展性差，简单，快
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                resList.add("FizzBuzz");
            }else if(i%3==0){
                resList.add("Fizz");
            }else if(i%5==0){
                resList.add("Buzz");
            }else{
                resList.add(i+"");
            }
        }
        return resList;
    }
}

//解法二 map  业务拓展性好

class Solution {
    public List<String> fizzBuzz(int n) {
        Map<Integer,String> fizzBuzzMap = new HashMap<>();
        fizzBuzzMap.put(3,"Fizz");
        fizzBuzzMap.put(5,"Buzz");
        List<String> ans = new ArrayList<>();
        for (int num = 1; num <=n; num++) {
            String strRes = "";
            for (Integer key :fizzBuzzMap.keySet()){
                if (num%key==0){
                    strRes+=fizzBuzzMap.get(key);
                }
            }
            if (strRes.equals("")){
                strRes+=num+"";
            }
            ans.add(strRes);
        }
        return ans;
    }
}