import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;
    private String ISBN;
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
}

// Member class
class Member {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;
    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}

// Library class
class Library {
    private List<Book> availableBooks;
    private List<Member> members;
    public Library() {
        this.availableBooks = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    public void addBook(Book book) {
        availableBooks.add(book);
    }
    public void registerMember(Member member) {
        members.add(member);
    }
    public void checkoutBook(String ISBN, int memberId) {
        Member member = members.stream()
                .filter(m -> m.getMemberId() == memberId)
                .findFirst()
                .orElse(null);

        Book book = availableBooks.stream()
                .filter(b -> b.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);

        if (member != null && book != null) {
            availableBooks.remove(book);
            member.borrowBook(book);
            System.out.println("Book checked out");
        } else {
            System.out.println("Checkout failed.");
        }
    }

    public void returnBook(String ISBN, int memberId) {
        Member member = members.stream()
                .filter(m -> m.getMemberId() == memberId)
                .findFirst()
                .orElse(null);

        if (member != null) {
            Book book = member.getBorrowedBooks().stream()
                    .filter(b -> b.getISBN().equals(ISBN))
                    .findFirst()
                    .orElse(null);

            if (book != null) {
                member.returnBook(book);
                availableBooks.add(book);
                System.out.println("Book returned");
            } else {
                System.out.println("Return failed.");
            }
        } else {
            System.out.println("Return failed.");
        }
    }
}

// Main class to test the system
public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Add books
        library.addBook(new Book("Gatsby", "Scott", "313-1231123"));
        library.addBook(new Book("2025", "Fuad", "055-8023131"));
        
        // Register members
        library.registerMember(new Member(1, "Alice Smith"));
        library.registerMember(new Member(2, "Bob Johnson"));
        
        // Test checkout
        library.checkoutBook("313-1231123", 1);
        library.checkoutBook("978-0000000000", 1);
        library.checkoutBook("978-0451524935", 99);
        
        // Test return
        library.returnBook("313-1231123", 1);
        library.returnBook("978-0743273565", 1);
    }
}