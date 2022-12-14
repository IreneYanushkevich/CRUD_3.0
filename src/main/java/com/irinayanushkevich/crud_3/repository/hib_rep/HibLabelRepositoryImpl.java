package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.repository.LabelRepository;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.List;

public class HibLabelRepositoryImpl implements LabelRepository {

    private final HibernateConnector hibernateConnector = new HibernateConnector();

    @Override
    public Label create(Label label) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            session.persist(label);
            Long id = (Long) session.getIdentifier(label);
            session.getTransaction().commit();
            label.setId(id);
            return label;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Label getById(Long id) {
        Label label;
        try (Session session = hibernateConnector.openSession()) {
            label = session.get(Label.class, id);
        }
        return label;
    }

    @Override
    public Label edit(Label label) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            session.merge(label);
            session.getTransaction().commit();
            return label;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            Label label = session.get(Label.class, id);
            session.remove(label);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels;
        try (Session session = hibernateConnector.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Label> query = builder.createQuery(Label.class);
            query.from(Label.class);
            labels = session.createQuery(query).getResultList();
        }
        return labels;
    }
}
