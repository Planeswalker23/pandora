package io.walkers.planes.pandora.redis.sign.controller;

import io.walkers.planes.pandora.redis.sign.util.BitmapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author planeswalker23
 * @date 2022/2/26
 */
@RestController
public class BitmapController {

    @Autowired
    private BitmapUtil bitmapUtil;

    @GetMapping("/bitmap/setBit")
    public Boolean setBit(String key, long offset, boolean value) {
        return bitmapUtil.setBit(key, offset, value);
    }

    @GetMapping("/bitmap/getBit")
    public Boolean getBit(String key, long offset) {
        return bitmapUtil.getBit(key, offset);
    }

    @GetMapping("/bitmap/bitCountTrue")
    public Long bitCountTrue(String key) {
        return bitmapUtil.bitCountTrue(key);
    }

    @GetMapping("/bitmap/bitCountTrueRange")
    public Long bitCountTrueRange(String key, long start, long end) {
        return bitmapUtil.bitCountTrue(key, start, end);
    }

    @GetMapping("/bitmap/bitPos")
    public Long bitPos(String key, boolean value) {
        return bitmapUtil.bitPos(key, value);
    }

    @GetMapping("/bitmap/bitPosRange")
    public Long bitPosRange(String key, boolean value, long start, long end) {
        return bitmapUtil.bitPos(key, value, start, end);
    }

    @GetMapping("/bitmap/getBitmap")
    public String getBitmap(String key) {
        return bitmapUtil.getBitmapUsingString(key);
    }
}
