import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public int id;
    public String name;
    public boolean status;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = true;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", status=" + status + "]";
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    public void borrowBook(int id) {
        Book found = null;
        for (Book book : books) {
            if (book.id == id) {
                found = book;
                book.status = false;
                break;
            }
        }
        System.out.printf(found!=null ? "Book found %s\n" : "Book not found\n", found);
    }

    public void returnBook(int id) {
        Book found = null;
        for (Book book : books) {
            if (book.id == id) {
                found = book;
                book.status = true;
                break;
            }
        }

        System.out.printf(found != null ? "Book returned %s\n" : "Book not found\n", found);
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added");
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void availableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.status) System.out.println(book);
        }
    }

    public void borrowedBooks() {
        System.out.println("\nBorrowed Books:");
        for (Book book : books) {
            if (!book.status) System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. View Available Books");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Name: ");
                    String name = scanner.nextLine();
                    library.addBook(new Book(id, name));
                    break;

                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;

                case 4:
                    System.out.println("\nAll Books:");
                    library.printBooks();
                    break;

                case 5:
                    library.availableBooks();
                    break;

                case 6:
                    library.borrowedBooks();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}