package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 异常在 jvm 字节码的示例
 * @author Planeswalker23
 * @date Created in 2020/5/18
 */
public class ExceptionDemo {

    /**
     * 若在 try 语句块中抛出了异常 A，而 catch 语句块指定的异常 >= 异常 A，则 catch 语句块会将异常 A 捕获，从而执行 catch 语句块的语句
     * 若在 catch 语句块中抛出了异常 B，会先执行 finally 语句块，然后抛出 catch 抛出的异常 B
     * 若在 finally 语句块中又抛出了异常 C，会中断 finally 的执行，然后抛出异常 C（意味着catch语句块抛出的异常 B 被"吞"了）
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        try {
            System.out.println("try");
            throw new Exception("try");
        } catch (Exception e) {
            System.out.println("catch");
            throw new RuntimeException("catch");
        } finally {
            System.out.println("finally");
            throw new RuntimeException("finally");
        }
    }
}
