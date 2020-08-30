import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        //deque(双端队列) 练习
        Deque<String> myDeque = new LinkedList<>();
        //add
        myDeque.add("first_elment");
        myDeque.add("second_elment");
        System.out.println(myDeque);
        //peek
        String peekElment =  myDeque.peek();
        System.out.println(peekElment);
        System.out.println(myDeque);
        //pop
        String popElment = myDeque.pop();
        System.out.println(popElment);
        System.out.println(myDeque);

        //addFirst 从头插入
        myDeque.addFirst("first_elment");
        myDeque.addFirst("first1_elment");
        //addLast 从头插入
        myDeque.addLast("last_elment");
        System.out.println(myDeque);//[first1_elment, first_elment, last_elment]

    }
}