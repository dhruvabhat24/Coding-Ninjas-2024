public class Solution{
    static class Stack {
        int [] s;
        int top;
        Stack(int capacity) {
            // Write your code here.
            s=new int[capacity];
            top=-1;
        }
        public void push(int num) {
            // Write your code here.
            if(top==s.length-1){
                //System.out.println("Stack is full");
                return;
            }
            ++top;
            s[top]=num;

        }
        public int pop() {
            if(top==-1){
                //System.out.println("Stack is empty");
                return -1;
            }
            return s[top--]; 
        }
        public int top() {
            if(top==-1){
                //System.out.println("Stack is Empty");
                return -1;
            }
            return s[top];
        }
        public int isEmpty() {
            return (top==-1)?1:0;
        }
        public int isFull() {
            return (top==s.length-1)?1:0;
        }
    }
}
