import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("[Error] Cannot list library books. There are no books in the library.");
        }


        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        Book book4 = null;


        try {
            book1 = new Book("Java Programming", 300);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] Cannot create book object \"book1\". Either the title is null, or page count is not positive.");
        }

        try {
            book2 = new Book("Design Patterns", -3);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] Cannot create book object \"book2\". Either the title is null, or page count is not positive.");
        }

        try {
            book3 = new Book(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] Cannot create book object \"book3\". Either the title is null, or page count is not positive.");
        }
        try {
            book4 = new Book("", 400);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] Cannot create book object \"book4\". Either the title is null, or page count is not positive.");
        }


        try {
            library.addBook(book1);
        } catch (InvalidBookException e) {
            System.out.println("[Error] Cannot add book1 to library. Book is null.");
        }

        try {
            library.addBook(book2);
        } catch (InvalidBookException e) {
            System.out.println("[Error] Cannot add book2 to library. Book is null.");
        }

        try {
            library.addBook(book3);
        } catch (InvalidBookException e) {
            System.out.println("[Error] Cannot add book3 to library. Book is null.");
        }

        try {
            library.addBook(book4);
        } catch (InvalidBookException e) {
            System.out.println("[Error] Cannot add book4 to library. Book is null.");
        }


        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("[Error] Cannot list library books. There are no books in the library.");
        }


        try {
            library.borrowBook("Java Programming");
        } catch (BookNotFoundException e) {
            System.out.println("[Error] Cannot borrow book. Book is not found in the library.");
        } catch (EmptyLibraryException e) {
            System.out.println("[Error] Cannot borrow book. Library is empty");
        }

        try {
            library.borrowBook("Clean Code");
        } catch (BookNotFoundException e) {
            System.out.println("[Error] Cannot borrow book. Book is not found in the library.");
        } catch (EmptyLibraryException e) {
            System.out.println("[Error] Cannot borrow book. Library is empty");
        }

        try {
            library.returnBook("Java Programming");
        } catch (BookNotFoundException e) {
            System.out.println("[Error] Cannot return book. Book is not found in the library.");
        }
    }
}