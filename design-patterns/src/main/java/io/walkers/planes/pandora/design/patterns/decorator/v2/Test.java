package io.walkers.planes.pandora.design.patterns.decorator.v2;

import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.Macchiato;
import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.MilkyTea;
import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.Pudding;
import io.walkers.planes.pandora.design.patterns.decorator.v2.decorator.CustomMacchiato;
import io.walkers.planes.pandora.design.patterns.decorator.v2.decorator.CustomMilkyTea;
import io.walkers.planes.pandora.design.patterns.decorator.v2.decorator.CustomPudding;

/**
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class Test {

    public static void main(String[] args) {
        // 未装饰前的布丁奶茶
        MilkyTea pudding = new Pudding();
        System.out.println(pudding.description());
        // 装饰后的布丁奶茶，需要将装饰目标传入装饰器
        CustomMilkyTea customPudding = new CustomPudding(pudding);
        System.out.println(customPudding.description());

        // 未装饰前的玛奇朵
        MilkyTea macchiato = new Macchiato();
        System.out.println(macchiato.description());
        // 装饰后的玛奇朵，需要将装饰目标传入装饰器
        CustomMilkyTea customMacchiato = new CustomMacchiato(macchiato);
        System.out.println(customMacchiato.description());
    }
}
