package Com.Library;

import Com.Library.model.Book;
import Com.Library.model.User;
import Com.Library.repository.LibraryRepository;
import Com.Library.repository.UserRepository;
import Com.Library.service.BookService;
import Com.Library.service.UserService;
import Com.Library.service.BorrowingService;
import java.util.InputMismatchException;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        LibraryRepository libraryRepository = new LibraryRepository();
        UserRepository userRepository = new UserRepository();

        BookService bookService =
                new BookService(libraryRepository);

        UserService userService =
                new UserService(userRepository);

        BorrowingService borrowingService =
                new BorrowingService(
                        libraryRepository,
                        userRepository
                );

        int choice = 0;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Book Management");
            System.out.println("2. User Management");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.please enter a number");
                scanner.nextLine();
                continue;
            }


            switch (choice) {


                case 1:

                    int bookChoice;

                    do {

                        System.out.println();
                        System.out.println("==============================");
                        System.out.println("       BOOK MANAGEMENT");
                        System.out.println("==============================");
                        System.out.println("1. Add Book");
                        System.out.println("2. View All Books");
                        System.out.println("3. Update Book");
                        System.out.println("4. Delete Book");
                        System.out.println("5. Search Book");
                        System.out.println("0. Back");
                        System.out.print("Enter your choice: ");

                        bookChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (bookChoice) {


                            case 1:

                                System.out.println();
                                System.out.println("--- Add Book ---");

                                System.out.print("Enter Book ID: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter ISBN: ");
                                String isbn = scanner.nextLine();

                                System.out.print("Enter Title: ");
                                String title = scanner.nextLine();

                                System.out.print("Enter Author: ");
                                String author = scanner.nextLine();

                                System.out.print("Enter Category: ");
                                String category = scanner.nextLine();

                                Book book = new Book(
                                        author,
                                        true,
                                        category,
                                        id,
                                        isbn,
                                        title
                                );

                                bookService.addBook(book);

                                System.out.println(
                                        "Book added successfully."
                                );

                                break;


                            case 2:

                                System.out.println();
                                System.out.println("--- All Books ---");

                                if (bookService.getAllBooks().isEmpty()) {

                                    System.out.println(
                                            "No books found."
                                    );

                                } else {

                                    for (Book b :
                                            bookService.getAllBooks()) {

                                        System.out.println(
                                                "------------------------------"
                                        );

                                        System.out.println(
                                                "ID: " + b.getId()
                                        );

                                        System.out.println(
                                                "ISBN: " + b.getIsbn()
                                        );

                                        System.out.println(
                                                "Title: " + b.getTitle()
                                        );

                                        System.out.println(
                                                "Author: " + b.getAuthor()
                                        );

                                        System.out.println(
                                                "Category: "
                                                        + b.getCategory()
                                        );

                                        System.out.println(
                                                "Available: "
                                                        + (b.isAvailable()
                                                        ? "Yes"
                                                        : "No")
                                        );
                                    }

                                    System.out.println(
                                            "------------------------------"
                                    );
                                }

                                break;


                            case 3:

                                System.out.println();
                                System.out.println("--- Update Book ---");

                                System.out.print("Enter Book ID: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                Book bookToUpdate =
                                        bookService.getBookById(updateId);

                                if (bookToUpdate == null) {

                                    System.out.println(
                                            "Book not found."
                                    );

                                } else {

                                    System.out.print(
                                            "Enter New Title: "
                                    );
                                    String newTitle =
                                            scanner.nextLine();

                                    System.out.print(
                                            "Enter New Author: "
                                    );
                                    String newAuthor =
                                            scanner.nextLine();

                                    System.out.print(
                                            "Enter New Category: "
                                    );
                                    String newCategory =
                                            scanner.nextLine();

                                    bookService.updateBook(
                                            updateId,
                                            newTitle,
                                            newAuthor,
                                            newCategory
                                    );

                                    System.out.println(
                                            "Book updated successfully."
                                    );
                                }

                                break;


                            case 4:

                                System.out.println();
                                System.out.println("--- Delete Book ---");

                                System.out.print("Enter Book ID: ");
                                int deleteId = scanner.nextInt();
                                scanner.nextLine();

                                Book bookToDelete =
                                        bookService.getBookById(deleteId);

                                if (bookToDelete == null) {

                                    System.out.println(
                                            "Book not found."
                                    );

                                } else {

                                    bookService.deleteBook(deleteId);

                                    System.out.println(
                                            "Book deleted successfully."
                                    );
                                }

                                break;


                            case 5:

                                System.out.println();
                                System.out.println("--- Search Book ---");

                                System.out.print(
                                        "Enter Title, Author or Category: "
                                );

                                String keyword =
                                        scanner.nextLine();

                                if (bookService
                                        .searchBooks(keyword)
                                        .isEmpty()) {

                                    System.out.println(
                                            "No books found."
                                    );

                                } else {

                                    for (Book b :
                                            bookService
                                                    .searchBooks(keyword)) {

                                        System.out.println(
                                                "------------------------------"
                                        );

                                        System.out.println(
                                                "ID: " + b.getId()
                                        );

                                        System.out.println(
                                                "ISBN: " + b.getIsbn()
                                        );

                                        System.out.println(
                                                "Title: " + b.getTitle()
                                        );

                                        System.out.println(
                                                "Author: " + b.getAuthor()
                                        );

                                        System.out.println(
                                                "Category: "
                                                        + b.getCategory()
                                        );

                                        System.out.println(
                                                "Available: "
                                                        + (b.isAvailable()
                                                        ? "Yes"
                                                        : "No")
                                        );
                                    }
                                }

                                break;


                            case 0:

                                System.out.println(
                                        "Returning to main menu..."
                                );

                                break;


                            default:

                                System.out.println(
                                        "Invalid choice."
                                );
                        }

                    } while (bookChoice != 0);

                    break;


                case 2:

                    int userChoice;

                    do {

                        System.out.println();
                        System.out.println("==============================");
                        System.out.println("       USER MANAGEMENT");
                        System.out.println("==============================");
                        System.out.println("1. Add User");
                        System.out.println("2. View All Users");
                        System.out.println("0. Back");
                        System.out.print("Enter your choice: ");

                        userChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (userChoice) {


                            case 1:

                                System.out.println();
                                System.out.println("--- Add User ---");

                                System.out.print("Enter User ID: ");
                                int userId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter User Name: ");
                                String userName =
                                        scanner.nextLine();

                                User user =
                                        new User(
                                                userId,
                                                userName
                                        );

                                userService.addUser(user);

                                System.out.println(
                                        "User added successfully."
                                );

                                break;


                            case 2:

                                System.out.println();
                                System.out.println("--- All Users ---");

                                if (userService
                                        .getAllUsers()
                                        .isEmpty()) {

                                    System.out.println(
                                            "No users found."
                                    );

                                } else {

                                    for (User u :
                                            userService.getAllUsers()) {

                                        System.out.println(
                                                "------------------------------"
                                        );

                                        System.out.println(
                                                "ID: " + u.getId()
                                        );

                                        System.out.println(
                                                "Name: " + u.getName()
                                        );
                                    }

                                    System.out.println(
                                            "------------------------------"
                                    );
                                }

                                break;


                            case 0:

                                System.out.println(
                                        "Returning to main menu..."
                                );

                                break;


                            default:

                                System.out.println(
                                        "Invalid choice."
                                );
                        }

                    } while (userChoice != 0);

                    break;


                case 3:

                    System.out.println();
                    System.out.println("--- Borrow Book ---");

                    System.out.print("Enter Book ID: ");
                    int borrowBookId =
                            scanner.nextInt();

                    System.out.print("Enter User ID: ");
                    int borrowUserId =
                            scanner.nextInt();

                    scanner.nextLine();

                    borrowingService.borrowBook(
                            borrowBookId,
                            borrowUserId
                    );

                    break;


                case 4:

                    System.out.println();
                    System.out.println("--- Return Book ---");

                    System.out.print("Enter Book ID: ");
                    int returnBookId =
                            scanner.nextInt();

                    System.out.print("Enter User ID: ");
                    int returnUserId =
                            scanner.nextInt();

                    scanner.nextLine();

                    borrowingService.returnBook(
                            returnBookId,
                            returnUserId
                    );

                    break;


                case 5:

                    System.out.println();
                    System.out.println("==============================");
                    System.out.println("           REPORTS");
                    System.out.println("==============================");

                    if (borrowingService
                            .getBorrowRecords()
                            .isEmpty()) {

                        System.out.println(
                                "No books are currently borrowed."
                        );

                    } else {

                        System.out.println(
                                "Currently Borrowed Books:"
                        );

                        borrowingService
                                .getBorrowRecords()
                                .forEach(record -> {

                                    System.out.println(
                                            "Book ID: "
                                                    + record.getBookId()
                                    );

                                    System.out.println(
                                            "User ID: "
                                                    + record.getUserId()
                                    );

                                    System.out.println(
                                            "------------------------------"
                                    );
                                });
                    }

                    System.out.println();
                    System.out.println("Currently Available Books:");

                    boolean hasAvailableBooks = false;

                    for (Book book : bookService.getAllBooks()) {
                        if (book.isAvailable()) {
                            hasAvailableBooks = true;

                            System.out.println("----------------------");
                            System.out.println("Book ID: " + book.getId());
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("Category: " + book.getCategory());
                        }
                    }

                    if (!hasAvailableBooks) {
                        System.out.println("No books are currently available.");
                    }

                    System.out.println("----------------------");

                    break;


                case 0:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Library Management System!"
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }


        }   while (choice != 0);


                    scanner.close();

        }
    }



