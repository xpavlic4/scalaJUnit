package at.focusmr.dblocator.formatter.jdbc;

import at.focusmr.dblocator.data.Jdbc;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class JdbcStringBuilderTest {
    Logger log = Logger.getAnonymousLogger();

    @Test
    public void shouldGenerateCorrectSidString() {
        String result = "jdbc:oracle:thin:@glob01.focusmr.co.at:1521:AEMGLOB.FOCUSMR";
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("glob01.focusmr.co.at");
        b.withPort(1521);
        b.withSid("AEMGLOB.FOCUSMR");
        Jdbc s = b.build();

        Assert.assertEquals(result, s.getValue());

    }

    @Test
    public void shouldGenerateCorrectServiceString() {
        String result = "jdbc:oracle:thin:@//orac01.focusmr.co.at:1521/WEBDB1.FOCUSMR";
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("orac01.focusmr.co.at");
        b.withPort(1521);
        b.withService("WEBDB1.FOCUSMR");
        Jdbc s = b.build();

        Assert.assertEquals(result, s.getValue());

    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingWithoutSidAndService() {

        JdbcStringBuilder b = new JdbcStringBuilder();
        b.build();
    }

    @Test
    public void testGeneratingJdbcString() {
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("glob01.focusmr.co.at");
        b.withUser("db_locator");
        b.withPassword("nvvo4fx6");
        b.withPort(1521);
        b.withService("aemglob.focusmr");
        Jdbc jdbcXml = b.build();
        log.info(jdbcXml.getValue());

    }

}
