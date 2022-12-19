package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.repository.LabelRepository;
import com.irinayanushkevich.crud_3.util.HibernateUtil;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;

import java.util.List;

public class HibLabelRepositoryImpl implements LabelRepository {

    @Override
    public Label create(Label label) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            session.persist(label);
            Long id = (Long) session.getIdentifier(label);
            session.getTransaction().commit();
            label.setId(id);
            return label;
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Override
    public Label getById(Long id) {
        Label label;
        try (Session session = HibernateUtil.openSession()) {
            label = session.get(Label.class, id);
        }
        return label;
    }

    @Override
    public Label edit(Label label) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            session.merge(label);
            session.getTransaction().commit();
            return label;
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            Label label = session.get(Label.class, id);
            session.remove(label);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels;
        try (Session session = HibernateUtil.openSession()) {
            labels = session.createQuery("FROM Label", Label.class).getResultList();
        }
        return labels;
    }
}
