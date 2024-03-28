package com.shuuriye.Books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public Collection<Book> getBook(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id) {
        Book searched =  bookService.getBookById(id);
        if(searched == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id [" + id + "] not found");
        return ResponseEntity.status(HttpStatus.OK).body(searched);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteBookById(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable Long id,@RequestBody Book book){
        return bookService.updateBook(id, book);
    }
}
