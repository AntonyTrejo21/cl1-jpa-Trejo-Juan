package pe.edu.I202223136.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202223136.entity.Country;

public class JPARemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        String countryCode = "WKD";
        Country country = em.find(Country.class, countryCode);
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        System.out.println("Wakanda se ha ido con todos sus hijos en cascada.");

        em.close();
        emf.close();
    }
}
