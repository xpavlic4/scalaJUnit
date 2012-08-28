package at.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 */
@XmlRootElement(name = "jbdcs")
public class JdbcsXml {
    @XmlElement(name = "jdbc")
    private List<JdbcXml> l = new LinkedList<JdbcXml>();

    public void add(JdbcXml xml) {
        l.add(xml);
    }

}
