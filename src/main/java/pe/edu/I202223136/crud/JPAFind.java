package pe.edu.I202223136.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202223136.entity.Country;

public class JPAFind {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();
        String countryCode = "PER";
        Country country = em.find(Country.class, countryCode);
        System.out.printf("País: %s%n", country.getName());
        System.out.println("Ciudades con mas de 700k personas:");
        country.getCities().stream()
                                    .filter(city -> city.getPopulation() > 700_000)
                                    .forEach(city ->
                                    System.out.printf("%s (Población: %d)%n", city.getName(), city.getPopulation())
                                    );

            em.close();
            emf.close();
        }
    }
