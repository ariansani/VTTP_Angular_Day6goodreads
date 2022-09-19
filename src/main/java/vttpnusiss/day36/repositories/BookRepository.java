package vttpnusiss.day36.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttpnusiss.day36.models.BookDetails;
import vttpnusiss.day36.models.BookSummary;

@Repository
public class BookRepository {

    private static final String SQL_GET_BOOKS = "SELECT book_id, title FROM book2018 ORDER BY title ASC LIMIT ? OFFSET ?";

    private static final String SQL_GET_BOOK = "SELECT * from book2018 WHERE book_id LIKE ?";

    @Autowired
    private JdbcTemplate template;

    public List<BookSummary> getBooks(Integer limit, Integer offset) {
        
        List<BookSummary> summaries = new LinkedList<>();

        SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOKS,limit, offset);
        while (rs.next()){
           BookSummary summary = BookSummary.create(rs);
           summaries.add(summary);
        }
        return summaries;
    }
    public BookDetails getBook(String bookId){
        BookDetails book = new BookDetails();
        SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOK,bookId);
        if(rs.next()){
            book = BookDetails.create(rs);
        }
        return book;
    }
}
