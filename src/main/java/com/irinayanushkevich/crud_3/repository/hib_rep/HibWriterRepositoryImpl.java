package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Writer;
import com.irinayanushkevich.crud_3.repository.WriterRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.List;

public class HibWriterRepositoryImpl implements WriterRepository {

    private final HibernateConnector hibernateConnector = new HibernateConnector();

    @Override
    public Writer create(Writer writer) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            session.persist(writer);
            Long id = (Long) session.getIdentifier(writer);
            session.getTransaction().commit();
            writer.setId(id);
            return writer;
        }
    }

    @Override
    public Writer getById(Long id) {
        Writer writer;
        try (Session session = hibernateConnector.openSession()) {
            writer = session.get(Writer.class, id);
        }
        return writer;
    }

    public Writer edit(Writer writer) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            session.merge(writer);
            session.getTransaction().commit();
            return writer;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            Writer writer = session.get(Writer.class, id);
            session.remove(writer);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;
        try (Session session = hibernateConnector.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Writer> query = builder.createQuery(Writer.class);
            query.from(Writer.class);
            writers = session.createQuery(query).getResultList();
        }
        return writers;
    }
}



