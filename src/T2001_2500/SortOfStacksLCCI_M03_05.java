package T2001_2500;

import java.util.Stack;

/**
 * @ author : Real
 * @ date : 2021/10/28 20:37
 * @ description : 实现双栈排序 、 面试题03.05
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortOfStacksLCCI_M03_05 {
    class SortedStack {
        /**
         * Your SortedStack object will be instantiated and called as such:
         * SortedStack obj = new SortedStack();
         * obj.push(val);
         * obj.pop();
         * int param_3 = obj.peek();
         * boolean param_4 = obj.isEmpty();
         */
        private Stack<Integer> stack;
        private Stack<Integer> tempStack;

        public SortedStack() {
            stack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void push(int val) {
            // 添加的时候要求将小的数字放到栈顶
            // 完成的状态应该是tempStack为空，stack为满
            while (!stack.isEmpty() && stack.peek() < val) {
                // 添加策略就是将stack中的数据全部添加进tempStack中变成有序
                Integer pop = stack.pop();
                tempStack.push(pop);
            }
            // 循环结束的时候应该是两个栈各自有序，再将自己添加进stack
            stack.push(val);
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else {
                return -1;
            }
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}
