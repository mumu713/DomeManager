package connector;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
public class JavaConnectSQLServer {
    public static Connection getConnection()
    {
        Connection conn;
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String connURL="jdbc:mysql://localhost:3306/user?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" +
                    "&?useUnicode=true&characterEncoding=utf8";
            conn=DriverManager.getConnection(connURL,"root","123456");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
