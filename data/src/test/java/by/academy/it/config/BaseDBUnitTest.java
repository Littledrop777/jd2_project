package by.academy.it.config;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDBUnitTest {

    private IDatabaseConnection connection;
    private IDataSet dataSet;

    private final static Logger log = Logger.getLogger(BaseDBUnitTest.class.getName());

    public void cleanInsert(String resourceName) {
        try {
            if (connection == null) {
                connection = new MySqlConnection(
                        MySqlDataSource.getTestConnection(),
                        "social_media_test");
            }
            dataSet = new FlatXmlDataSetBuilder().build(BaseDBUnitTest.class
                    .getResourceAsStream(resourceName));
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void deleteDataset() {
        try {
            DatabaseOperation.DELETE.execute(connection, dataSet);
            connection.close();
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class MySqlDataSource {

    private final static Logger log = Logger.getLogger(MySqlDataSource.class.getName());
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(MySqlDataSource.class
                    .getResourceAsStream("/social_media_test.db.properties"));
            Class.forName(properties.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException | IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties
        );
    }
}
