package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class Test {

    public static void main(String[] args) {
        // 买一杯奶茶，不加任何配料
        Material milkTea = new MilkTea();
        System.out.println("奶茶费用 = " + milkTea.cost());

        // 买一被加椰果的奶茶
        Material milkTeaWithCoCo = new MilkTea();
        milkTeaWithCoCo = new NataDeCoco(milkTeaWithCoCo);
        System.out.println("椰果奶茶费用 = " + milkTeaWithCoCo.cost());

        // 买一被加布丁的玛奇朵
        Material MacchiatoWithPudding = new Macchiato();
        MacchiatoWithPudding = new Pudding(MacchiatoWithPudding);
        System.out.println("布丁玛奇朵费用 = " + MacchiatoWithPudding.cost());
    }
}
