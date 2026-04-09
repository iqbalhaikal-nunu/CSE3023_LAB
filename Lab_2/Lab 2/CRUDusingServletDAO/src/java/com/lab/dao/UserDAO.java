package com.lab.dao;

import com.lab.model.User;
import java.sql.*;
import java.util.*;

public class UserDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/CSE3023";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    // 🔹 CONNECT DB
    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 🔹 INSERT
    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, password, roles) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 SELECT ALL
    public List<User> selectAllUsers() {
        List<User> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("roles")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 SELECT ONE
    public User selectUser(int id) {
        User user = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        id,
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("roles")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // 🔹 UPDATE
    public boolean updateUser(User user) {
        boolean rowUpdated = false;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE users SET username=?, password=?, roles=? WHERE id=?")) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());
            ps.setInt(4, user.getId());

            rowUpdated = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // 🔹 DELETE
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "DELETE FROM users WHERE id=?")) {

            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }
}