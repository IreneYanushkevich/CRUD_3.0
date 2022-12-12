package com.irinayanushkevich.crud_3.repository.hib_rep;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.repository.LabelRepository;

import java.util.List;

public class HibLabelRepositoryImpl implements LabelRepository {

    public Label create(Label label) { /*
        Long id;
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatementWithKeys(SqlQuery.createLabel)) {
            preparedStatement.setString(1, label.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            id = getId(resultSet);
            label.setId(id);
        } catch (SQLIntegrityConstraintViolationException e) {
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return label; */
        return null;
    }

    public Label getById(Long id) { /*
        Label label = new Label();
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.getByIdLabel)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                label.setId(id);
                label.setName(resultSet.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return label; */
        return null;
    }

    public Label edit(Label label) { /*
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.editLabel)) {
            preparedStatement.setString(1, label.getName());
            preparedStatement.setLong(2, label.getId());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return label;*/
        return null;
    }

    public boolean delete(Long id) { /*
        boolean deleted = false;
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.deleteLabel)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            deleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted; */
        return false;
    }

    public List<Label> getAll() { /*
        List<Label> labels = new ArrayList<>();
        try (PreparedStatement preparedStatement = HibernateConnector.getPreparedStatement(SqlQuery.getAllLabels)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Label label = new Label();
                label.setId(resultSet.getLong("id"));
                label.setName(resultSet.getString("name"));
                labels.add(label);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labels; */
        return null;
    }
}
