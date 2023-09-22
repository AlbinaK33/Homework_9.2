package org.example;

import org.apache.log4j.Logger;
import org.example.crud.*;
import org.example.entity.*;

import javax.persistence.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;
    private static final File file = new File("osbb.txt");

    public static void main(String[] args) {

        LOGGER.info("Starting logger");

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnitName");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            List<Resident> residents = CriteriaAPI.residentProcessWithCritoriaAPI(entityManager);
            printWriteList(residents);

            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            LOGGER.error(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        LOGGER.info("Finish program");
    }

    public static <T> void printWriteList(List<T> list) {
        try (FileWriter writer = new FileWriter(file)) {
            for (T item : list) {
                String line = item.toString();
                if (line != null) {
                    writer.write(line);
                    writer.flush();
                }
                System.out.println(item);
            }
        } catch (IOException e) {
            LOGGER.fatal(e);
        }

    }
}


