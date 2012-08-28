package at.focusmr.dblocator.data;

/**
 * Value object for JDBC connection string.
 */
public class Jdbc {
    public Jdbc(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
