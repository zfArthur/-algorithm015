import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        //queue 练习
        Queue<String> myQueue = new LinkedList<>();
        //Throws exception 会抛对应异常的操作
        //add
        myQueue.add("first_elment");
        myQueue.add("second_elment");
        System.out.println(myQueue); //输出:[first_elment, second_elment]
        //remove
        String removeElment = myQueue.remove();
        System.out.println(removeElment);//输出:first_elment 验证先入先出
        System.out.println(myQueue);//输出:[second_elment]
        //返回队列的头,但不删除队头
        String elment = myQueue.element();
        System.out.println(elment);//输出:first_elment

        //Returns special value 不抛异常而是返回对应的值,返回null
        Queue<String> myQueue1 = new LinkedList<>();
        //offer 等同 add
        myQueue1.offer("first_elment");
        myQueue1.offer("second_elment");
        System.out.println(myQueue1); //输出:[first_elment, second_elment]
        //poll 等同 remove
        String pollElment = myQueue1.poll();
        System.out.println(pollElment);//输出:first_elment 验证先入先出
        //peek 等同 element
        String peekElment = myQueue1.peek();
        System.out.println(peekElment);//输出:first_elment 验证先入先出
        System.out.println(myQueue1);//输出:[first_elment, second_elment]

    }
}