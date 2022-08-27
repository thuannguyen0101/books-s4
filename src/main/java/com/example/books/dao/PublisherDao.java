package com.example.books.dao;

import com.example.books.entity.Genre;
import com.example.books.entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDao {
    private final Connection conn;

    public PublisherDao(Connection conn) {
        this.conn = conn;
    }
    public List<Publisher> getAll(){
        List<Publisher>publishers = new ArrayList<>();
        String query = "select * from publishers";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Publisher publisher = new Publisher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6));
                publishers.add(publisher);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }
}
