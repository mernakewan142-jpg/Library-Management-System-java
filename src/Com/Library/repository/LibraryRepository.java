package Com.Library.repository;

import Com.Library.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryRepository {

    private ArrayList<Book> books;
    private HashMap<Integer, Book> booksById;
    private HashSet<String> isbnSet;

    public LibraryRepository() {
        this.books = new ArrayList<>();
        this.booksById = new HashMap<>();
        this.isbnSet = new HashSet<>();
    }

    public void addBook(Book book) {
        if (isbnSet.contains(book.getIsbn())) {
            System.out.println("Book with ISBN already exists");
            return;
        }
        isbnSet.add(book.getIsbn());

        books.add(book);

        booksById.put(book.getId(), book);

    }

    public Book getBookById(int id) {
        return booksById.get(id);
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void updateBook(int id, String newTitle, String newAuthor, String newCategory) {
        Book book = getBookById(id);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        book.setAuthor(newAuthor);
        book.setCategory(newCategory);
        book.setTitle(newTitle);
    }

    public void deleteBook(int id) {
        Book book = getBookById(id);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        books.remove(book);
        booksById.remove(id);
        isbnSet.remove(book.getIsbn());
    }

    public ArrayList<Book> searchBooks(String keyword) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword)
                    ||
                    book.getAuthor().equalsIgnoreCase(keyword)
                    ||
                    book.getCategory().equalsIgnoreCase(keyword)) {
                result.add(book);

            }
        }
        return result;
    }

}
