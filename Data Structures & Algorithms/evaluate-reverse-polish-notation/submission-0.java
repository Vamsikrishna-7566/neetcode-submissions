class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                int firstElement = stack.pop();
                int secondElement = stack.pop();

                int result  =  secondElement + firstElement;
                stack.push(result);

            }
            else if(tokens[i].equals("-")){
                int firstElement = stack.pop();
                int secondElement = stack.pop();

                int result  = secondElement - firstElement;
                stack.push(result);

            }
            else if(tokens[i].equals("*")){
                int firstElement = stack.pop();
                int secondElement = stack.pop();
                int result  = secondElement * firstElement;
                stack.push(result);

            }
            else if(tokens[i].equals("/")){
                int firstElement = stack.pop();
                int secondElement = stack.pop();

                int result  = secondElement / firstElement;
                stack.push(result);

            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            
        }

        return stack.peek();
    }
}
