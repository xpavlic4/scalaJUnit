package at.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Value object for list of {@link JdbcXml}.
 */
@XmlRootElement(name = "jdbc")
public class JdbcXml {
    private String connectionString;
    private String country;

    public JdbcXml() {
    }

    @SuppressWarnings(value = "unused")
    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @SuppressWarnings(value = "unused")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return connectionString;
    }
}
