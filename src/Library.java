import exceptions.*;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Book should not be null.");
        }
        books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books == null) {
            throw new EmptyLibraryException("Library is empty, no books to borrow.");
        }
        Book requestedBook = this.findBook(title);
        if (requestedBook == null) {
            throw new BookNotFoundException("Book with title " + title + " not found.");
        }

        System.out.println("Book with title " + requestedBook.getTitle() + "Has been successfully borrowed.\n" +
                "Book properties: \n" +
                "Title: " + requestedBook.getTitle() + "\n" +
                "Page count: " + requestedBook.getPageCount() + "\n");
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book requestedBook = this.findBook(title);
        if (requestedBook == null) {
            throw new BookNotFoundException("Cannot return. Book with title " + title + " not found.");
        }

        System.out.println("Book with title " + requestedBook.getTitle() + "Has been successfully returned.\n" +
                "Book properties: \n" +
                "Title: " + requestedBook.getTitle() + "\n" +
                "Page count: " + requestedBook.getPageCount());
    }

    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty.");
        }

        System.out.println("Books in the library: ");
        System.out.println("------------------------------------------");
        for (Book book : books) {
            System.out.println("Book properties: \n" +
                    "Title: " + book.getTitle() + "\n" +
                    "Page count: " + book.getPageCount() + "\n" +
                    "------------------------------------------");
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
