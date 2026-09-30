package Com.Library.service;

import Com.Library.model.Book;
import Com.Library.repository.LibraryRepository;

import java.util.ArrayList;

public class BookService {

    private LibraryRepository libraryRepository;

    public BookService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void addBook(Book book) {
        libraryRepository.addBook(book);
    }

    public Book getBookById(int id) {
        return libraryRepository.getBookById(id);
    }

    public ArrayList<Book> getAllBooks() {
        return libraryRepository.getAllBooks();
    }

    public void updateBook(int id, String newTitle,
                           String newAuthor, String newCategory) {

        libraryRepository.updateBook(id, newTitle, newAuthor, newCategory);
    }

    public void deleteBook(int id) {
        libraryRepository.deleteBook(id);
    }

    public ArrayList<Book> searchBooks(String keyword) {
        return libraryRepository.searchBooks(keyword);
    }
}