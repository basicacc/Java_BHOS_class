import java.util.ArrayList;
import java.util.List;

public class things {
    // Book class
    static class Book {
        private String title;
        private String author;
        private String ISBN;

        public Book(String title, String author, String ISBN) {
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
        }

        public String getISBN() {
            return ISBN;
        }
    }

    // Member class
    static class Member {
        private final int memberId;
        private final String name;
        private final List<Book> borrowedBooks;

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

        public int getMemberId() {
            return memberId;
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }
    }

    // Library class
    static class Library {
        private final List<Book> availableBooks;
        private final List<Member> members;

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
}