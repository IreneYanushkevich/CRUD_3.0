package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.model.Post;
import com.irinayanushkevich.crud_3.model.PostStatus;
import com.irinayanushkevich.crud_3.repository.PostRepository;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class HibPostRepositoryImpl implements PostRepository {

    private final HibernateConnector hibernateConnector = new HibernateConnector();

    @Override
    public Post create(Post post) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            post.setCreated(getDate().toLocalDateTime());
            post.setUpdated(getDate().toLocalDateTime());
            post.setStatus(PostStatus.REVIEW);
            session.persist(post);
            Long id = (Long) session.getIdentifier(post);
            session.getTransaction().commit();
            post.setId(id);
            return post;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post getById(Long id) {
        Post post;
        try (Session session = hibernateConnector.openSession()) {
            post = session.get(Post.class, id);
        }
        return post;
    }

    @Override
    public Post edit(Post post) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            Post postEdited = session.get(Post.class, post.getId());
            postEdited.setContent(post.getContent());
            postEdited.setUpdated(getDate().toLocalDateTime());
            postEdited.setStatus(PostStatus.ACTIVE);
            postEdited.setLabels(post.getLabels());
            session.merge(postEdited);
            session.getTransaction().commit();
            return postEdited;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = hibernateConnector.openTransactionSession()) {
            Post post = session.get(Post.class, id);
            session.remove(post);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts;
        try (Session session = hibernateConnector.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> query = builder.createQuery(Post.class);
            query.from(Post.class);
            posts = session.createQuery(query).getResultList();
        }
        return posts;
    }

    private Timestamp getDate() {
        return new Timestamp(new Date().getTime());
    }
}
