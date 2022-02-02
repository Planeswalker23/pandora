package io.walkers.planes.pandora.design.patterns.adapter.v2;

/**
 * 耳机孔——圆型插头
 *
 * @author planeswalker23
 */
public class HeadsetOfRoundPlug implements Headset {

    @Override
    public void playMusic() {
        System.out.println("圆型插头耳机播放音乐");
    }
}
