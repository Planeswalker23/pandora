package io.walkers.planes.pandora.spring.resource;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 带字符编码的资源示例
 *
 * @author planeswalker23
 * @date 2021/11/25
 */
public class EncodeFileSystemResourceDemo {

    @Test
    public void encode() throws IOException {
        String dir = "src/main/java/io/walkers/planes/pandora/spring/resource/EncodeFileSystemResourceDemo.java";
        FileSystemResource fileSystemResource = new FileSystemResource(dir);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
