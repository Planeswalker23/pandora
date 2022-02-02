package io.walkers.planes.pandora.design.patterns.adapter.v2;

/**
 * IPhone7 手机
 *
 * @author planeswalker23
 */
public class IPhone7 {

    /**
     * 只能使用 TypeC 插头的耳机播放音乐
     */
    public void playMusic(HeadsetOfTypeCPlug headset) {
        headset.playMusic();
    }
}
