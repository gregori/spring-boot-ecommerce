package tech.gregori.springbootecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.gregori.springbootecommerce.db.BookRepository;
import tech.gregori.springbootecommerce.model.Book;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

    private byte[] bytes;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Book book) throws IOException {
        book.setPicBype(this.bytes);
        bookRepository.save(book);
        this.bytes = null;
    }

    @DeleteMapping("/{id}")
    public Book DeleteBook(@PathVariable("id") long id) {
        Book book = bookRepository.getOne(id);
        bookRepository.deleteById(id);
        return book;
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}
