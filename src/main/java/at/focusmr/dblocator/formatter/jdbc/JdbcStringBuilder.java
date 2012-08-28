package at.focusmr.dblocator.formatter.jdbc;

import at.focusmr.dblocator.data.Jdbc;

/**
 * Builder for well formated JDBC Oracle connection .
 * For SID:
 * <pre>jdbc:oracle:thin:[USER/PASSWORD]@[HOST][:PORT]:SID</pre>
 * For Service:
 * <pre>jdbc:oracle:thin:[USER/PASSWORD]@//[HOST][:PORT]/SERVICE</pre>
 */
public class JdbcStringBuilder {
    private String host;
    private int port;
    private String sid;
    private String service;
    private String user;
    private String password;

    public void withHost(String s) {
        host = s;
    }

    public void withPort(int i) {
        port = i;
    }

    public void withSid(String s) {
        sid = s;
    }

    public Jdbc build() {

        check();

        StringBuilder sb = new StringBuilder("jdbc:oracle:thin:");
        if (user != null) {
            sb.append(user);
            sb.append("/");
        }
        if (password != null) {
            sb.append(password);
        }

        sb.append("@");
        if (null != service) {
            sb.append("//");
        }
        sb.append(host);
        sb.append(":");
        sb.append(port);
        if (null != sid) {
            sb.append(":");
            sb.append(sid);
        }
        if (null != service) {
            sb.append("/");
            sb.append(service);
        }
        return new Jdbc(sb.toString());
    }

    private void check() {
        boolean sidOk = false;
        if (sid != null && !sid.isEmpty()) {
            sidOk = true;
        }
        boolean serviceOk = false;
        if (service != null && !service.isEmpty()) {
            serviceOk = true;
        }

        if (!sidOk && !serviceOk) {
            throw new IllegalStateException();
        }
    }

    public void withService(String s) {
        service = s;
    }

    public void withUser(String user) {
        this.user = user;

    }

    public void withPassword(String pwd) {
        this.password = pwd;
    }
}
