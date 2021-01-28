package io.walkers.planes.pandora.jvm.geektime;

/**
 * Lesson1: Java代码是怎么运行的？
 * 测试示例: boolean类型在JVM中的表示
 * @author Planeswalker23
 * @date Created in 2020/5/2
 */
public class Chapter1Foo {

    /**
     * 输入 javap -c Foo 后的字节码文件
     * public static void main(java.lang.String[]);
     *     Code:
     *        0: iconst_1
     *        1: istore_1
     *        2: iload_1
     *        3: ifeq          14
     *        6: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        9: ldc           #3                  // String Hello, Java!
     *       11: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *       14: iload_1
     *       15: iconst_1
     *       16: if_icmpne     27
     *       19: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       22: ldc           #5                  // String Hello, JVM!
     *       24: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *       27: return
     * @param args
     */
    public static void main(String[] args) {
        boolean flag = true;
        // ifeq 14: 判断flag == 0，若为true 跳转到14行
        // 即若 flag！=0, 则执行if语句
        if (flag) {
            System.out.println("Hello, Java!");
        }
        // if_icmpne 27: 比较栈顶两 int 型数值大小，当结果不等于0时跳转到27行
        // 即若 flag==1，执行if语句
        if (flag == true) {
            System.out.println("Hello, JVM!");
        }
    }
}