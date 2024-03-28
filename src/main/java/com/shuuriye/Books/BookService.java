package com.shuuriye.Books;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    Map<Long , Book> books = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    //methods
    public Collection<Book> getBooks(){
        return books.values();
    }

    //getbook by id
    public Book getBookById(Long id){
        return books.get(id);
    }

    //delete book
    public Book deleteBook(Long id){
        Book deleted = books.remove(id);
        return deleted;
    }

    //save book
    public Book saveBook(Book book){
        Long id = book.getId() != null ?
                book.getId() :
                counter.incrementAndGet();

        book.setId(id);
        books.put(id, book);

        return book;
    }

    //update book
    public Book updateBook(Long id , Book book){
        if(books.containsKey(id)){
            Book oldBook = books.get(id);

            oldBook.setAuthor(book.getAuthor());
            oldBook.setTitle(book.getTitle());

            books.put(id, oldBook);
            return oldBook;
        }
        return null;
    }
}
