package at.focusmr.dblocator.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
@Table
@NamedQueries(
        {
                @NamedQuery(name = Databases.Q.ALL,
                        query = "select d from Databases d  where d.category = 'dataentry'"),

                @NamedQuery(name = Databases.Q.BY_COUNTRY,
                        query = "select m from Databases m where m.category = 'dataentry' and m.country = :country")
        })
public class Databases implements Serializable {
    public void setCountry(String country) {
        this.country = country;
    }

    public static final class Q {
        private Q() {
        }

        public static final String ALL = "all";
        public static final String BY_COUNTRY = "BY_COUNTRY";
    }

    /**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;

    //just use this, as we make only named queries
    @Id
    private String hostname;

    @Basic(optional = false)
    @Column(name = "TNSNAME")
    private String tnsName;

    @Basic(optional = true)
    private String sid;

    @Basic(optional = true)
    @Column(name = "service_name")
    private String serviceName;

    @Basic
    private int port;

    @Basic(optional = true)
    private String category;

    @Basic(optional = true)
    private String country;

    //generated

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTnsName() {
        return tnsName;
    }

    public void setTnsName(String tnsname) {
        this.tnsName = tnsname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

}