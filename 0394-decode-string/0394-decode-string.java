class Solution {
    public String decodeString(String s) {
        
        String[] str = s.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=[\\[\\]])|(?=[\\[\\]])");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length; i++){

            if(str[i].equals("[")){

                stack.push(str[i]);
            }else if(str[i].matches("\\d+")){

                stack.push(str[i]);
            }else if(str[i].equals("]")){

                String temp = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    temp = stack.pop() + temp;
                }
                stack.pop();

                String toAdd = "";
                for(int count = 1; count <= Integer.parseInt(stack.peek()); count++){
                    toAdd += temp;
                }
                stack.pop();

                stack.add(toAdd);
            }else{

                stack.push(str[i]);
            }
        }

        String res = "";
        while(!stack.isEmpty()){

            res = stack.pop()+res;
        }
        
        return res;
    }
}