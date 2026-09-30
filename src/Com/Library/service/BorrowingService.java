package Com.Library.service;

import Com.Library.model.Book;
import Com.Library.model.BorrowRecord;
import Com.Library.repository.LibraryRepository;
import Com.Library.repository.UserRepository;

import java.util.ArrayList;

public class BorrowingService {

    private LibraryRepository libraryRepository;
    private UserRepository userRepository;
    private ArrayList<BorrowRecord> borrowRecords;

    public BorrowingService(LibraryRepository libraryRepository,
                            UserRepository userRepository) {

        this.libraryRepository = libraryRepository;
        this.userRepository = userRepository;
        this.borrowRecords = new ArrayList<>();
    }

    public void borrowBook(int bookId, int userId) {

        Book book = libraryRepository.getBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (userRepository.getUserById(userId) == null) {
            System.out.println("User not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        BorrowRecord record = new BorrowRecord(bookId, userId);
        borrowRecords.add(record);

        book.setAvailable(false);

        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int bookId, int userId) {

        Book book = libraryRepository.getBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        for (BorrowRecord record : borrowRecords) {

            if (record.getBookId() == bookId &&
                    record.getUserId() == userId) {

                borrowRecords.remove(record);
                book.setAvailable(true);

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Borrow record not found.");
    }

    public ArrayList<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }
}