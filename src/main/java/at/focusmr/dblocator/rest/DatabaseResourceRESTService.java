package at.focusmr.dblocator.rest;

import at.focusmr.dblocator.data.Jdbc;
import at.focusmr.dblocator.formatter.jdbc.JdbcStringBuilder;
import at.focusmr.dblocator.model.Databases;
import at.focusmr.dblocator.xml.JdbcXml;
import at.focusmr.dblocator.xml.JdbcsXml;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.TEXT_XML;

/**
 * This class produces a RESTful service to read the contents of the databases table.
 */
@Path("/databases")
@RequestScoped
public class DatabaseResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Path("/jdbcs")
    @Produces(TEXT_XML)
    public JdbcsXml listAllJdbcs() {
        final List<Databases> results = em.createNamedQuery(Databases.Q.ALL, Databases.class).getResultList();

        JdbcsXml l = new JdbcsXml();
        for (Databases d : results) {
            Jdbc xml = fromDatabase(d);

            JdbcXml jdbcXml = new JdbcXml();
            jdbcXml.setCountry(d.getCountry());
            jdbcXml.setConnectionString(xml.getValue());

            l.add(jdbcXml);
        }
        return l;
    }

    @GET
    @Path("/jdbcs/{country:[a-z][a-z]*}")
    @Produces(TEXT_XML)
    public JdbcXml lookupMemberById(@PathParam("country") String country) {
        TypedQuery<Databases> query = em.createNamedQuery(Databases.Q.BY_COUNTRY, Databases.class);
        query.setParameter("country", country);
        Databases d = query.getSingleResult();

        Jdbc jdbc = fromDatabase(d);
        JdbcXml jdbcXml = new JdbcXml();
        jdbcXml.setConnectionString(jdbc.getValue());
        jdbcXml.setCountry(country);
        return jdbcXml;
    }

    private Jdbc fromDatabase(Databases d) {
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost(d.getHostname());
        b.withPort(d.getPort());
        b.withService(d.getServiceName());
        b.withSid(d.getSid());
        return b.build();
    }
}
