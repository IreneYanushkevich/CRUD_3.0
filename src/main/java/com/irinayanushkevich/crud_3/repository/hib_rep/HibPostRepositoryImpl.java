package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Post;
import com.irinayanushkevich.crud_3.model.PostStatus;
import com.irinayanushkevich.crud_3.repository.PostRepository;
import com.irinayanushkevich.crud_3.util.HibernateUtil;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;

import java.util.List;

public class HibPostRepositoryImpl implements PostRepository {

    @Override
    public Post create(Post post) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            post.setStatus(PostStatus.REVIEW);
            session.persist(post);
            Long id = (Long) session.getIdentifier(post);
            session.getTransaction().commit();
            post.setId(id);
            return post;
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Override
    public Post getById(Long id) {
        Post post;
        try (Session session = HibernateUtil.openSession()) {
            post = session.get(Post.class, id);
        }
        return post;
    }

    @Override
    public Post edit(Post post) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            post.setStatus(PostStatus.ACTIVE);
            session.merge(post);
            session.getTransaction().commit();
            post.setUpdated(session.get(Post.class, post.getId()).getUpdated());
            return post;
        } catch (PersistenceException e) {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateUtil.openTransactionSession()) {
            Post post = session.get(Post.class, id);
            post.setStatus(PostStatus.DELETED);
            session.merge(post);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts;
        try (Session session = HibernateUtil.openSession()) {
            posts = session.createQuery("FROM Post ", Post.class).getResultList();
        }
        return posts;
    }
}
