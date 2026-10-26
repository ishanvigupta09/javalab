
import java.util.ArrayList;

class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;

    // Parameterized constructor
    Book(String ISBN, String title, String author, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter for ISBN
    public String getISBN() {
        return ISBN;
    }

    // Display book details
    public void displayBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs. " + price);
        System.out.println("-------------------------");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                System.out.println("Book with this ISBN already exists!");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Search book by ISBN
    public void searchBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                System.out.println("Book found:");
                b.displayBook();
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nLibrary Book List:");
        for (Book b : books) {
            b.displayBook();
        }
    }

    // Remove book using ISBN
    public void removeBook(String ISBN) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().equals(ISBN)) {
                books.remove(i);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }
}

public class s2p4 {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book("B101",
                "Java Programming", "Tawqeer ul Islam", 450));

        library.addBook(new Book("B102",
                "C++ Programming", "John Smith", 500));

        library.addBook(new Book("B103",
                "Python Basics", "James Brown", 400));

        // Try adding duplicate ISBN
        library.addBook(new Book("B102",
                "Advanced Java", "Amit Kumar", 600));

        // Search book
        System.out.println("\nSearching for ISBN B102:");
        library.searchBook("B102");

        // Remove book
        library.removeBook("B101");

        // Display remaining books
        library.displayBooks();
    }
}
