package ru.dolgosheev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dolgosheev.model.Item;
import ru.dolgosheev.model.Person;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            // Получение информации о человеке
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            // Получение информации о товаре
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//            Person person = item.getOwner();
//            System.out.println(person);

//            // Добавление нового товара человеку
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Vacuum Cleaner", person);
//            person.getItems().add(newItem);
//            session.persist(newItem);

//            // Создание нового человека и добавление ему нового товара
//            Person person = new Person("Edward", 35);
//            Item newItem = new Item("Laptop", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//            session.persist(person);
//            session.persist(newItem);

//            // Удаление всех товаров у человека
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            //SQL
//            for (Item item : items) {
//                session.remove(item);
//            }
//            //Не порождает SQL, но необходимо для того, чтобы в кэше все было верно
//            person.getItems().clear();

//            // Удаление человека
//            Person person = session.get(Person.class, 2);
//            //SQL
//            session.remove(person);
//            //Не порождает SQL, но необходимо для того, чтобы в кэше все было верно
//            person.getItems().forEach(i -> i.setOwner(null));

//            // Изменение владельца товара
//            Person person = session.get(Person.class, 4);
//            Item item = session.get(Item.class, 1);
//            item.getOwner().getItems().remove(item);
//            item.setOwner(person);
//            person.getItems().add(item);

            Person person = session.get(Person.class, 1);
            System.out.println("Take person");

            System.out.println(person.getItems());


//            Item item = session.get(Item.class, 1);
//            System.out.println("Получили товар");
//
//            System.out.println(item.getOwner());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
