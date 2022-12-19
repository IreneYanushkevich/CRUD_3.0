package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Writer;
import com.irinayanushkevich.crud_3.repository.WriterRepository;
import com.irinayanushkevich.crud_3.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibWriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer create(Writer writer) {
        try (Session session = HibernateUtil.openTransactionSession()) {
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
        try (Session session = HibernateUtil.openSession()) {
            writer = session.get(Writer.class, id);
        }
        return writer;
    }

    public Writer edit(Writer writer) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            session.merge(writer);
            session.getTransaction().commit();
            return writer;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            Writer writer = session.get(Writer.class, id);
            session.remove(writer);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;
        try (Session session = HibernateUtil.openSession()) {
            writers = session.createQuery("FROM Writer ", Writer.class).getResultList();
        }
        return writers;
    }
}



