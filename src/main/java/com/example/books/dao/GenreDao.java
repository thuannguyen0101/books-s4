package com.example.books.dao;

import com.example.books.entity.Book;
import com.example.books.entity.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    private final Connection conn;

    public GenreDao(Connection conn) {
        this.conn = conn;
    }
    public List<Genre> getAll(){
        List<Genre>genres = new ArrayList<>();
        String query = "select * from genres";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt(1),rs.getString(2),rs.getLong(3));
                genres.add(genre);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
}
