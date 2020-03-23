package ua.nure.chernykh.Practice10.db;

import ua.nure.chernykh.Practice10.db.entity.User;

import java.sql.*;

public class DBManager {

    private static final String CONNECTION_URL =
            "jdbc:mysql://localhost/practice10db?"
                    + "user=practice10user&password=pass10";
    private static final String SQL_FIND_USER_BY_LOGIN_AND_PASS =
            "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD=?";

    public static boolean checkUser(String login,String pass)
    {
        boolean st =false;
        try{

            //creating connection with the database
            Connection con= getConnection();
            PreparedStatement ps =con.prepareStatement
                    (SQL_FIND_USER_BY_LOGIN_AND_PASS);
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }

    public User getUser(String login, String password) throws SQLException {
        Connection con = getConnection();
        User result = getUser(con, login, password);
        DBUtils.close(con);
        return result;
    }

    private User getUser(Connection con, String login, String password) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN_AND_PASS);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        } finally {
            if (rs != null) {
                DBUtils.close(rs);
            }
            if (pstmt != null) {
                DBUtils.close(pstmt);
            }
        }
        return null;
    }

    private static User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRole_id(rs.getInt("role_id"));
        return user;
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // adjust your connection
        return con;
    }
}
