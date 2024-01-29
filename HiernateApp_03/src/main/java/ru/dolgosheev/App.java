package ru.dolgosheev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dolgosheev.model.Actor;
import ru.dolgosheev.model.Movie;
import ru.dolgosheev.model.Passport;
import ru.dolgosheev.model.Person;

import java.util.ArrayList;
import java.util.Collections;
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

//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//
//            actor.getMovies().add(movie);
//
//            session.persist(movie);
//            session.persist(actor);

            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor);

            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}
