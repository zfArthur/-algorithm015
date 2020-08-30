import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        //stack 练习
        Stack<String> myStack = new Stack<>();
        //push 先入后出
        myStack.push("first_elment");
        myStack.push("second_elment");
        myStack.push("three_elment");
        //返回栈顶元素
        String peelElment = myStack.peek();
        System.out.println(peelElment); //输出: second_elment
        System.out.println(myStack); //输出: [first_elment,second_elment]
        //pop  返回栈顶元素，并删除栈顶元素
        String popElment = myStack.pop();
        System.out.println(popElment); //输出: second_elment
        System.out.println(myStack); //输出: [first_elment]
        //empty
        boolean isempty = myStack.empty();
        //search 注意返回的是基于1的位置从堆栈的顶部，即栈顶为1,下一个为2，依次类推，找不到返回-1
        int searchNums = myStack.search("first_elment");
        System.out.println(searchNums); //输出: 3

    }
}