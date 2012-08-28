package at.focusmr.dblocator.formatter.tnsnames;

import at.focusmr.dblocator.data.TnsName;

/**
 * Creates TNSNAMES.ORA file
 * <pre>
 * ORA11 =
 * (DESCRIPTION =
 * (ADDRESS_LIST =
 * (ADDRESS = (PROTOCOL = TCP)(HOST = 127.0.0.1)(PORT = 1521))
 * )
 * (CONNECT_DATA =
 * (SERVICE_NAME = ORA11)
 * )
 * )
 * </pre>
 */
public class TnsNamesBuilder {
    private String tnsName;
    private String host;
    private String serviceName;
    private int port;
    private String sid;

    public TnsNamesBuilder withTnsName(String tnsName) {
        this.tnsName = tnsName;
        return this;
    }

    public TnsNamesBuilder withHost(String host) {
        this.host = host;
        return this;
    }

    public TnsNamesBuilder withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;

    }

    public TnsName build() {
        StringBuilder sb = new StringBuilder();
        sb.append(tnsName);
        sb.append("=(DESCRIPTION = ");
        sb.append("(ADDRESS_LIST =");
        sb.append("(ADDRESS = (PROTOCOL = TCP)(HOST = ");
        sb.append(host);
        sb.append(")(PORT = ");
        sb.append(port);
        sb.append("))");
        sb.append(")");
        sb.append("(CONNECT_DATA =");
        sb.append("(SERVICE_NAME = ");
        if (null != serviceName && !serviceName.isEmpty()) {
            sb.append(serviceName);
        } else if (null != sid && !sid.isEmpty()) {
            sb.append(sid);
        } else {
            throw new IllegalStateException("Either servicename or sid has to be entered.");
        }

        sb.append(")");
        sb.append(")");
        sb.append(")");
        return new TnsName(sb.toString().replaceAll("\\s", ""));

    }

    public TnsNamesBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public TnsNamesBuilder withSid(String sid) {
        this.sid = sid;
        return this;
    }
}
