package at.focusmr.dblocator.data;

import at.focusmr.dblocator.model.Databases;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
@SuppressWarnings(value = "unused")
public class DatabasesListProducer {
    @Inject
    private EntityManager em;

    private List<Databases> databases;

    @Produces
    @Named
    public List<Databases> getDatabases() {
        return databases;
    }

    @PostConstruct
    public void retrieveAllDatabases() {
        databases = em.createNamedQuery(Databases.Q.ALL, Databases.class).getResultList();
    }
}