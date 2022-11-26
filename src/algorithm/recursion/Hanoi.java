package algorithm.recursion;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Real
 * Date: 2022/11/26 23:04
 */
public class Hanoi {
    private static Integer m = 0;
    private static final MyStack stackA = new MyStack("A");
    private static final MyStack stackB = new MyStack("B");
    private static final MyStack stackC = new MyStack("C");

    public static void main(String[] args) {
        initHanoi(stackA, 10);
        System.out.println(Arrays.toString(stackA.toArray()));
        hanoi(stackA.size(), stackA, stackB, stackC);

        System.out.println(Arrays.toString(stackA.toArray()));
        System.out.println(Arrays.toString(stackB.toArray()));
        System.out.println(Arrays.toString(stackC.toArray()));
    }

    public static void hanoi(int size, MyStack a, MyStack b, MyStack c) {
        if (size == 1) {
            System.out.println("第 " + m++ + " 步，从 " + a.getName() + " 移动了 " + a.peek() + " 到了 " + c.getName());
            c.push(a.pop());
        } else {
            hanoi(size - 1, a, c, b);
            System.out.println("第 " + m++ + " 步，从 " + a.getName() + " 移动了 " + a.peek() + " 到了 " + c.getName());
            c.push(a.pop());
            hanoi(size - 1, b, a, c);
        }
    }

    public static void initHanoi(MyStack initStack, int n) {
        while (n > 0) {
            initStack.push(n--);
        }
    }

}

class MyStack {
    private final String name;
    private final Stack<Integer> data;

    public MyStack(String name) {
        this.name = name;
        data = new Stack<>();
    }

    public String getName() {
        return this.name;
    }

    public void push(int data) {
        if (!this.data.isEmpty() && this.data.peek() < data) {
            System.out.println("出错");
        }
        this.data.push(data);
    }

    public int peek() {
        return data.peek();
    }

    public int pop() {
        return data.pop();
    }

    public int size() {
        return data.size();
    }

    public Integer[] toArray() {
        return data.toArray(Integer[]::new);
    }
}

