package es.jpa;

import es.entities.Articulo;
import es.entities.ArticuloJpaController;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAArticulos1Test {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    private static EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("JPAArticulos1PU");
        em = emf.createEntityManager();
        return em;
    }

    public static void main(String[] args) throws Exception {
        em = getEntityManager();

        /*em.getTransaction().begin();

        Articulo art1 = new Articulo(122, "ESQUI", "ESQUIES ASSANGE 40", 250.30);

        em.persist(art1);

        em.getTransaction().commit();

        System.out.println(art1);

        em.close();*/
        Articulo art2 = new Articulo(453, "ESQUI", "ESQUIES ASSANGE 40", 250.30);
        ArticuloJpaController ajc = new ArticuloJpaController(emf);
        ajc.create(art2);
        Query query = em.createNamedQuery("Articulo.findAll");
        List<Articulo> lista = query.getResultList();
        for (Iterator<Articulo> it = lista.iterator(); it.hasNext();) {
            Articulo articulo = it.next();
            System.out.println(articulo);
            
        }
    }
}
