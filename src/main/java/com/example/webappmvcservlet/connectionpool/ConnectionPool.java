package com.example.webappmvcservlet.connectionpool;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final String PROPERTY_PATH = "db";
    private static final int INITIAL_CAPACITY = 10;
    private ArrayBlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<>(INITIAL_CAPACITY);
    private ArrayBlockingQueue<Connection> releaseConnections = new ArrayBlockingQueue<>(INITIAL_CAPACITY);
    private static ReentrantLock lock = new ReentrantLock();
    private volatile static ConnectionPool connectionPool;


    public static  ConnectionPool getInstance(){
        try{
            lock.lock();
            if(connectionPool==null){
                connectionPool=new ConnectionPool();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return  connectionPool;

    }
    private ConnectionPool() throws SQLException {
        try {
            lock.lock();
            if (connectionPool != null) {
                throw new UnsupportedOperationException();
            } else {
                init();
            }

        }            catch(Exception e){

        } finally {
            lock.unlock();
        }
    }
    private void init()throws SQLException, ClassNotFoundException  {
        Properties properties = new Properties();

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LastLab?allowPublicKeyRetrieval=true&useSSL=false", "root", "yyyytyt123");
                freeConnections.add(connection);
            } catch (SQLException e) {
                throw new RuntimeException("Pool can not initialize", e);
            }
        }

    }

    public Connection getConnection() {
        try {
            Connection connection = freeConnections.take();
            releaseConnections.offer(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException("Can not get database", e);
        }
    }
}
