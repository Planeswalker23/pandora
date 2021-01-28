package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 37. 简单的字节码剖析
 * javap 是 sun 提供的对 class 文件进行反编译的工具
 * <p>
 * 在命令行输入：
 * cd jvm/target/classes
 * javap -c bytecode.ByteCodeDemo1 反编译输出字节码
 * javap -verbose bytecode.ByteCodeDemo1 反编译输出字节码，附带冗余信息(包括魔数，版本号、常量池、类信息、类的构造方法、类中的方法信息、类变量与成员变量等信息)
 * <p>
 * <p>
 * .class字节码文件分析：
 * 1. 第1~4个字节：魔数，魔数值为固定值：0xCAFEBABE，它标志了一个文件是否是class类型的文件
 * 2. 第5、6个字节：minor version 次版本号
 * 3. 第7、8个字节：mahor version 主版本号，16进制
 * 4. 常量池（constant pool）：一个Java中定义的很多信息都是由常量池来维护和描述的，可以将常量池看作是 class 文件的资源仓库，比如说 Java 类中定义的方法与变量信息，都是存储在常量池中。
 * 常量池中主要存储两类常量：字面量与符号引用。字面量如文本字符串，Java 中声明的 final 的常量值等。而符号引用如类和接口的全局限定名，字段的名称和描述符、方法的名称和描述符号。
 * 常量池的总体结构：Java类所对应的常量池主要由常量池数量与常量池数组共同构成。
 * 第9、10个字节：常量池数量紧跟在主版本号后面，占据2个字节。
 * 常量池数组则紧跟在常量池数量之后。常量池数组与一般的数组不同的是，常量池数组中不同的元素类型、结构是不同的，但是每一种元素的第一个数据都是一个u1类型，这是一个标志类，占据1个字节。JVM在解析常量池时，会根据这个u1类型来获取元素的具体类型。如01代表 utf-8 格式的字符串。
 * 值得注意的是，常量池数组中元素的个数=常量池数-1（其中0暂时不使用），目的是某些常量池索引值的数据在特定情况下需要表达「不引用任何一个常量池」的含义；
 * 根本原因在于，索引为0也是一个常量（保留常量），只不过它不位于常量表中，这个常量就对应null值，所以，常量池的索引从1而非0开始。
 * 在JVM规范中，每个变量/字段都有描述信息，描述信息主要的作用是描述字段的数据类型、方法的参数列表（包括数量、类型与顺序）与返回值。根据描述符规则，基本数据类型和代表无返回值的void类型都用一个大写字符来表示，对象类型则使用字符L加对象的全限定名称来表示。为了压缩字节码文件的体积，对于基本数据类型，JVM都只是用一个大写字母来表示。
 * 如B - byte, C - char, D - double, F - float, I - int, J -long, S - short, Z - boolean, V - void, L - 对象类型(Ljava/lang/String)
 * 而对于数组类型来说，每一个纬度使用一个前置的[来表示，如int[]被标记为[I，String[][]被标记为[[Ljava/lang/String
 * 用描述符描述方法时，按照先参数列表，后返回值的顺序来描述。参数列表按照参数的严格顺序放在一组()之内，如方法 String getByIdAndName(int id, String name)的描述符为：(I, Ljava/lang/String;) Ljava/lang.String;
 *
 * @author Planeswalker23
 * @date Created in 2020/4/27
 */
public class ByteCodeDemo1 {

    private int a = 1;

    /**
     * 对于非静态方法而言，都会有一个由 JVM 隐式传入的局部变量 this，所以该方法的局部变量表有至少一个元素
     * @return
     */
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
