package spe.mch;

import java.sql.*;
import java.util.Stack;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 5;
    private final Stack<Connection> myDBStack = new Stack<>();
    private static ConnectionPool pool = null;

    //Singleton-Entwurfsmuster ==> privater Konstruktor
    private ConnectionPool() {
    }

    public static synchronized ConnectionPool createConnectionPool() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    private synchronized Connection createConnection(Connection conn) {
        String user = "spe";
        String password = "spe";
        String url = "jdbc:derby://localhost:1527/dvdshop";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public synchronized Connection getConnection() {
        Connection conn = null;

        if (myDBStack.empty()) {
            conn = createConnection(conn);
        } else {
            conn = myDBStack.pop();
        }
        return conn;
    }

    public synchronized void releaseConnection(Connection conn) {
        if (conn != null && myDBStack.size() >= MAX_CONNECTIONS) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        } else if (conn != null) {
            try {
                conn.commit();
                myDBStack.push(conn);
            } catch (SQLException e) {
            }

        }
    }
}
