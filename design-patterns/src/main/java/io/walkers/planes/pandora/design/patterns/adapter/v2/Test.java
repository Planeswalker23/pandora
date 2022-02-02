package io.walkers.planes.pandora.design.patterns.adapter.v2;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-10
 */
public class Test {
    public static void main(String[] args) {
        // 张三原有的圆形插头耳机
        HeadsetOfRoundPlug oldHeadset = new HeadsetOfRoundPlug();

        // 适配器做转换
        HeadsetAdapter adapter = new HeadsetAdapter(oldHeadset);
        HeadsetOfTypeCPlug convert = adapter.convert();

        // 新买的手机播放音乐
        IPhone7 iPhone7 = new IPhone7();
        iPhone7.playMusic(convert);
    }
}
