package at.focusmr.dblocator.formatter.tnsnames;

import at.focusmr.dblocator.util.FileUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.net.URL;

/**
 *
 */
public class TnsnamesBuilderTest {
    @Test
    public void shouldFindTestFile() throws Exception {
        URL url = this.getClass().getResource("/test-service.ora");
        String s2 = FileUtils.readFile(url.getPath());

        Assert.assertTrue(s2 != null);
        Assert.assertTrue(!s2.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNeitherServiceNameNorSidEntered() {

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.build();
    }

    @Test
    public void shouldCheckServiceNameEntered() throws Exception {
        URL url = this.getClass().getResource("/test-service.ora");
        String result = FileUtils.readFile(url.getPath());
        result = result.replaceAll("\\s", "");

//        Logger.getAnonymousLogger().info(result);

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.withServiceName("ORA11");
        String s = b.build().getValue();

        Assert.assertEquals(result, s);
    }

    @Test
    public void shouldCheckSidEntered() throws Exception {
        URL url = this.getClass().getResource("/test-service.ora");
        String result = FileUtils.readFile(url.getPath());
        result = result.replaceAll("\\s", "");

//        Logger.getAnonymousLogger().info(result);

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.withSid("ORA11");
        String s = b.build().getValue();

        Assert.assertEquals(result, s);
    }
}
