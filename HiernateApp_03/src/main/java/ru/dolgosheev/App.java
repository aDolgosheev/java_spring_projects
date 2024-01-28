package ru.dolgosheev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dolgosheev.model.Actor;
import ru.dolgosheev.model.Movie;
import ru.dolgosheev.model.Passport;
import ru.dolgosheev.model.Person;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
//                .addAnnotatedClass(Person.class)
//                .addAnnotatedClass(Passport.class);
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        // try with resources
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = session.get(Person.class, 1);
//            session.remove(person);

//            person.getPassport().setPassportNumber(555777);
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = session.get(Passport.class, 1);
//            System.out.println(passport.getPerson().getName());

//            session.persist(person);

            Movie movie = new Movie("Pulp function", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));

            session.getTransaction().commit();
        }
    }
}
