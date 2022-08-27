package com.example.books.dao;

import com.example.books.entity.Book;
import com.example.books.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final Connection conn;


    public BookDao(Connection conn) {
        this.conn = conn;
    }

    public boolean created(Book book) {
        String query = "Insert into books (name, author, storeId, genreId, publisherId, price, quantity, status) values (?, ?, ?, ?, ?, ?,?,?)";
        boolean check = false;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, 1);
            ps.setInt(4, book.getGenreId());
            ps.setInt(5, book.getPublisherId());
            ps.setInt(6, book.getPrice());
            ps.setInt(7, book.getQuantity());
            ps.setInt(8, Status.ACTIVE.getValue());
            check = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Book> getListAll() {
        List<Book> books = new ArrayList<>();
        return books;
    }
}
