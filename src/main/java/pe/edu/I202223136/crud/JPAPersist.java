package pe.edu.I202223136.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202223136.entity.City;
import pe.edu.I202223136.entity.Country;
import pe.edu.I202223136.entity.CountryLanguage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();
        Country country = new Country(
                "WKD",
                "Wakanda",
                "Asia",
                2024,
                123456.78f,
                "WRegion",
                7625676,
                80.5f,
                54321.0f,
                54320.0f,
                "Wakanda",
                "Pantera negra",
                "Wakanda forever",
                1200,
                "WD",
                null,
                null
        );
        City city1 = new City("WKD Sur", country, "Surinho", 900000);
        City city2 = new City("WKD Norte", country, "Nortinho", 800000);
        City city3 = new City("WKD Este", country, "Estinho", 750000);

        CountryLanguage lang1 = new CountryLanguage(country, "Wakandes", "T", 75.5f);
        CountryLanguage lang2 = new CountryLanguage(country, "Ingles", "F", 24.5f);

        city1.setCountry(country);
        city2.setCountry(country);
        city3.setCountry(country);
        List<City> cities = Arrays.asList(city1, city2, city3);

        country.setCities(cities);

        Set<CountryLanguage> languages = new HashSet<>(Arrays.asList(lang1, lang2));
        country.setLanguages(languages);

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        System.out.println("Wakanda ha llegado");
        em.close();
        emf.close();
    }
}
