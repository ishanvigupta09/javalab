import java.util.ArrayList;
import java.util.Scanner;

class Book {
	private String ISBN;
	private String title;
	private String author;
	private double price;

	Book(String ISBN, String title, String author, double price) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void display() {
		System.out.println("ISBN: " + ISBN);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: Rs. " + price);
		System.out.println("--------------------");
	}
}

public class s2p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<>();

		int choice;

		do {
			System.out.println("\n1. Add Book");
			System.out.println("2. Search Book");
			System.out.println("3. Display All Books");
			System.out.println("4. Remove Book");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter ISBN: ");
				String isbn = sc.nextLine();

				boolean exists = false;

				for (Book b : books) {
					if (b.getISBN().equals(isbn)) {
						exists = true;
						break;
					}
				}

				if (exists) {
					System.out.println("Duplicate ISBN! Book not added.");
					break;
				}

				System.out.print("Enter title: ");
				String title = sc.nextLine();

				System.out.print("Enter author: ");
				String author = sc.nextLine();

				System.out.print("Enter price: ");
				double price = sc.nextDouble();
				sc.nextLine();

				books.add(new Book(isbn, title, author, price));
				System.out.println("Book added successfully!");
				break;

			case 2:
				System.out.print("Enter ISBN to search: ");
				String searchISBN = sc.nextLine();

				boolean found = false;

				for (Book b : books) {
					if (b.getISBN().equals(searchISBN)) {
						b.display();
						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("Book not found!");
				}
				break;

			case 3:
				if (books.isEmpty()) {
					System.out.println("No books available.");
				} else {
					for (Book b : books) {
						b.display();
					}
				}
				break;

			case 4:
				System.out.print("Enter ISBN to remove: ");
				String removeISBN = sc.nextLine();

				boolean removed = false;

				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getISBN().equals(removeISBN)) {
						books.remove(i);
						removed = true;
						System.out.println("Book removed successfully!");
						break;
					}
				}

				if (!removed) {
					System.out.println("Book not found!");
				}
				break;

			case 5:
				System.out.println("Exiting library system...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 5);

		sc.close();
	}
}
