package vttpnusiss.day36.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttpnusiss.day36.models.BookDetails;
import vttpnusiss.day36.models.BookSummary;
import vttpnusiss.day36.services.BookService;
@RestController
@RequestMapping(path="/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BooksRestController {

    @Autowired
    private BookService bookSvc;

    @GetMapping
    public ResponseEntity<String> getBooks(@RequestParam(defaultValue = "20") Integer limit, 
            @RequestParam(defaultValue = "0") Integer offset) {

        List<BookSummary> summaries = bookSvc.search(limit, offset);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (BookSummary summary: summaries)
            arrBuilder.add(summary.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping(("{bookId}"))
    public ResponseEntity<String> getBook(@PathVariable String bookId) {
        System.out.println(">>>>>>>>>>>>>>TEST");
        BookDetails book = bookSvc.getDetails(bookId);

        book.toJson();
        return ResponseEntity.ok(book.toJson().toString());
    }
    
}