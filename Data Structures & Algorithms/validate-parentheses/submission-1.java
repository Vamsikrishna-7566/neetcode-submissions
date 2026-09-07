class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 !=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
       

        int j=0;
        while(j<s.length()){
            if(s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{'){
                stack.push(s.charAt(j));
            }
            else{
            
            if(!stack.isEmpty() && s.charAt(j) == ')' && stack.peek() == '(' ){
                stack.pop();
            }
            else if(!stack.isEmpty() && s.charAt(j) == ']' && stack.peek() == '[' ){
                stack.pop();
            }
            else if(!stack.isEmpty() && s.charAt(j) == '}' && stack.peek() == '{'){
                stack.pop();     
            }
            else{
                stack.push(s.charAt(j));
            }
            }
            j++;
            
        }

        return stack.isEmpty();

        
    }
}
