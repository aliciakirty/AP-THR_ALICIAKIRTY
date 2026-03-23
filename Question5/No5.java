import java.util.*;

class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        if (title.length() > 255) throw new IllegalArgumentException("Title too long");
        if (author.length() > 50) throw new IllegalArgumentException("Author too long");
        if (year <= 1800 || year >= 2026) throw new IllegalArgumentException("Invalid year");

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}

class GeneralBook extends Book {
    private String genre;

    public GeneralBook(String title, String author, int year, String genre) {
        super(title, author, year);

        if (genre.length() > 30) throw new IllegalArgumentException("Genre too long");
        this.genre = genre;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class ChildrenBook extends Book {
    private int minAge;
    private boolean hasVisualisation;

    public ChildrenBook(String title, String author, int year, int minAge, boolean hasVisualisation) {
        super(title, author, year);

        if (minAge <= 3 || minAge >= 12) throw new IllegalArgumentException("Invalid age");
        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisualisation ? "Yes" : "No"));
    }
}

public class No5 {
    static Stack<Book> books = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        books.push(new Book("Why Black Moves First", "Wesley So", 2025));
        books.push(new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        books.push(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));
        books.push(new GeneralBook("Space Odyssey", "Arthur Clarke", 1968, "Sci-Fi"));
        books.push(new ChildrenBook("Fun with Numbers", "Alice Smith", 2010, 6, false));

        int choice;
        do {
            System.out.println("\n=== Library of Alexandria ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> deleteBook();
            }

        } while (choice != 4);
    }

    static void addBook() {
        System.out.println("1. General Book");
        System.out.println("2. Children Book");
        System.out.print("Choose type: ");
        int type = sc.nextInt();
        sc.nextLine();

        try {
            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Year: ");
            int year = sc.nextInt();
            sc.nextLine();

            if (type == 1) {
                System.out.print("Genre: ");
                String genre = sc.nextLine();

                books.push(new GeneralBook(title, author, year, genre));

            } else if (type == 2) {
                System.out.print("Min Age: ");
                int age = sc.nextInt();

                System.out.print("Has Visualisation (true/false): ");
                boolean vis = sc.nextBoolean();

                books.push(new ChildrenBook(title, author, year, age, vis));
            }

            System.out.println("Book added!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); 
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        int i = 1;
        for (Book b : books) {
            System.out.println("\nBook #" + i++);
            b.getInfo();
        }
    }

    static void deleteBook() {
        if (books.isEmpty()) {
            System.out.println("No books to delete.");
            return;
        }

        viewBooks();
        System.out.print("\nEnter book number to delete: ");
        int index = sc.nextInt();

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid index!");
            return;
        }

        books.remove(index - 1);
        System.out.println("Book deleted!");
    }
}