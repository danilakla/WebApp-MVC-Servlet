package com.example.webappmvcservlet.repository;

import com.example.webappmvcservlet.builder.Builder;
import com.example.webappmvcservlet.repository.dbconstants.SQLHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class AbstractRepository<T> implements Repository<T>{
    private Connection connection;
    private static final String GET_ALL_QUERY = "SELECT * FROM ";
    private final String WHERE_ID_CONDITION = " WHERE id_" + getTableName() + "=(?)";
    protected final String DELETE_QUERY = "DELETE from " + getTableName() + " where id_" + getTableName() + "=(?)";
    protected abstract String getTableName();
    AbstractRepository(Connection connection) {
        this.connection = connection;
    }
    // Prepare request with params
    public static void prepare(PreparedStatement preparedStatement, List<Object> parameters) throws SQLException {
        int length = parameters.size();
        for (int i = 0; i < length; i++) {

            preparedStatement.setObject(i + 1, parameters.get(i));

        }
    }

    public static void prepare(PreparedStatement preparedStatement, Map<String, Object> fields, String tableName) throws SQLException {
        int i = 1;
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (!key.equals(SQLHelper.ID)) {

                    preparedStatement.setObject(i++, value);
            }
        }
        Object id = fields.get(SQLHelper.ID);
        if (id != null) {
            preparedStatement.setString(i++, String.valueOf(id));
        }
    }
    List<T> executeQuery(String sql, Builder<T> builder, List<Object> parameters) throws Exception {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            prepare(preparedStatement, parameters);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
        return objects;
    }


}
