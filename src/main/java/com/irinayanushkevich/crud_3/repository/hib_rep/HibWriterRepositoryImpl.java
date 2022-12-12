package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Writer;
import com.irinayanushkevich.crud_3.repository.WriterRepository;

import java.util.List;

public class HibWriterRepositoryImpl implements WriterRepository {
    private final HibPostRepositoryImpl postRepository = new HibPostRepositoryImpl();

    @Override
    public Writer create(Writer writer) {/*        Long id;
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatementWithKeys(SqlQuery.createWriter)) {
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(2, writer.getLastName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            id = getId(resultSet);
            writer.setId(id);
            setWriterIdToPost(writer.getPosts(), id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return writer; */ return null;
    }

    @Override
    public Writer getById(Long id) { /*
        Writer writer;
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.getByIdWriter)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                writer = mapResultSetToWriter(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return writer;*/
        return null;
    }

    public Writer edit(Writer writer) { /*
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.editWriter)) {
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(2, writer.getLastName());
            preparedStatement.setLong(3, writer.getId());
            preparedStatement.executeUpdate();
            deleteOldDependencies(writer.getId());
            setWriterIdToPost(writer.getPosts(), writer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return writer;*/
        return null;
    }

    @Override
    public boolean delete(Long id) { /*
        boolean deleted = false;
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.deleteWriter)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            deleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;*/
        return false;
    }

    @Override
    public List<Writer> getAll() { /*
        List<Writer> writers = new ArrayList<>();
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.getAllWriters)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Writer writer = mapResultSetToWriter(resultSet);
                writers.add(writer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return writers; */
        return null;
    }
/*
    private Writer mapResultSetToWriter(ResultSet resultSet) {
        try {
            Writer writer = new Writer();
            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setPosts(getWriterPosts(writer.getId()));
            return writer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Post> getWriterPosts(Long writerId) {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.getWriterPosts)) {
            preparedStatement.setLong(1, writerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = postRepository.mapResultSetToPost(resultSet);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return posts;
    }

    private Long getId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet != null && resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void setWriterIdToPost(List<Post> posts, Long id) {
        for (Post post : posts) {
            try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.setWriterIdToPost)) {
                preparedStatement.setLong(1, id);
                preparedStatement.setLong(2, post.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteOldDependencies(Long id) {
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.deleteOldDependenciesWP)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
