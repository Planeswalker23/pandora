package io.walkers.planes.pandora.design.patterns.adapter.v2;

/**
 * 耳机孔——TypeC插头
 *
 * @author planeswalker23
 */
public class HeadsetOfTypeCPlug implements Headset {

    @Override
    public void playMusic() {
        System.out.println("TypeC插头耳机播放音乐");
    }
}
