package io.walkers.planes.pandora.spring.resource;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 使用 {@link FileSystemResourceLoader} 加载文件资源
 *
 * @author planeswalker23
 * @date 2021/11/25
 */
public class EncodeFileSystemResourceLoaderDemo {

    @Test
    public void encode() throws IOException {
        String dir = "src/main/java/io/walkers/planes/pandora/spring/resource/EncodeFileSystemResourceDemo.java";

        // 使用 ResourceLoader 加载文件资源
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(dir);

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
