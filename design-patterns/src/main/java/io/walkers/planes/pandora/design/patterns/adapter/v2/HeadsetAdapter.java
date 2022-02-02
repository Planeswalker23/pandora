package io.walkers.planes.pandora.design.patterns.adapter.v2;

/**
 * 耳机插头适配器
 *
 * @author planeswalker23
 */
public class HeadsetAdapter {

    private HeadsetOfRoundPlug headset;

    public HeadsetAdapter(HeadsetOfRoundPlug headset) {
        this.headset = headset;
    }

    public HeadsetOfTypeCPlug convert() {
        System.out.println("耳机插头适配器将圆形转化为TypeC插头");
        return new HeadsetOfTypeCPlug();
    }
}
