package org.example.crud;

import org.apache.log4j.Logger;
import org.example.entity.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaAPI {

    private CriteriaAPI() {

    }

    private static final Logger LOGGER = Logger.getLogger(CriteriaAPI.class);

    public static List<Resident> residentProcessWithCritoriaAPI(EntityManager entityManager) {
        LOGGER.info("Start query");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Resident> criteriaQuery = criteriaBuilder.createQuery(Resident.class);
        Root<Resident> root = criteriaQuery.from(Resident.class);

        Join<Resident, Charter> charterJoin = root.join("charters");

        criteriaQuery.where(
                criteriaBuilder.equal(root.get("residence"), "1"),
                criteriaBuilder.equal(charterJoin.get("ownership"), 1),
                criteriaBuilder.equal(charterJoin.get("autopark"), "0"));
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

        TypedQuery<Resident> query = entityManager.createQuery(criteriaQuery);

        LOGGER.info("Exit method");

        return query.getResultList();
    }
}
