/**
 * @Author zhj
 * @Description 9.用两个栈实现队列
 * @Date 15:43 2020/12/11
 **/
public class AppendTail {
    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 147 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
//    Stack<Integer> stack = new Stack<>();
//    Stack<Integer> tmpStack = new Stack<>();

        int[] array = new int[16383];
        int head = -1;
        int tail = -1;

        public CQueue() {

        }

        public void appendTail(int value) {
            head = (head + 1) & 16383;
            array[head] = value;
//        stack.push(value);
        }

        public int deleteHead() {
            if (head == tail) {
                return -1;
            }
            tail = (tail + 1) & 16383;
            return array[tail];
//        if (stack.isEmpty()) {
//            return -1;
//        }
//        while (!stack.isEmpty()) {
//            tmpStack.push(stack.pop());
//        }
//        int res = tmpStack.pop();
//        while (!tmpStack.isEmpty()) {
//            stack.push(tmpStack.pop());
//        }
//        return res;
        }
    }
    //这个是正解，我写的太lj
//    class CQueue {
//        //成员变量
//        Stack<Integer> A,B;
//
//        //构造方法
//        public CQueue() {
//            A = new Stack<>();
//            B = new Stack<>();
//        }
//
//        public void appendTail(int value) {
//            A.push(value);
//        }
//
//        public int deleteHead() {
//            if(B.isEmpty()){
//                if(A.isEmpty()){
//                    return -1;
//                }
//                while(!A.isEmpty()){
//                    B.push(A.pop());
//                }
//            }
//            return B.pop();
//        }
//    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
