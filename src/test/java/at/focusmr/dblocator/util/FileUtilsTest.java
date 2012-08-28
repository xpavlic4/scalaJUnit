package at.focusmr.dblocator.util;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileUtilsTest {
    @Test
    public void testFileExists() {
        URL url = this.getClass().getResource("/test.txt");
        File file = new File(url.getFile());
        Assert.assertTrue(file.isFile());

    }

    @Test
    public void shouldReadFileContents() throws IOException {
        URL url = this.getClass().getResource("/test.txt");
        String s2 = FileUtils.readFile(url.getPath());
        Assert.assertEquals("hi", s2);
    }
}
