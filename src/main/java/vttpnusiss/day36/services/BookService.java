package vttpnusiss.day36.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttpnusiss.day36.models.BookDetails;
import vttpnusiss.day36.models.BookSummary;
import vttpnusiss.day36.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;

    
    public List<BookSummary> search(Integer limit, Integer offset){
        return bookRepo.getBooks(limit, offset);
    }

    public BookDetails getDetails(String bookId){
        return bookRepo.getBook(bookId);
    }
}
