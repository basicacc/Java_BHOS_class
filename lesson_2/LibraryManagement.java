public class LibraryManagement {
    public static void main(String[] args) {
        things.Library library = new things.Library();
        
        // Add books
        library.addBook(new things.Book("Gatsby", "Scott", "313-1231123"));
        library.addBook(new things.Book("2025", "Fuad", "055-8023131"));
        
        // Register members
        library.registerMember(new things.Member(1, "Alice Smith"));
        library.registerMember(new things.Member(2, "Bob Johnson"));
        
        // Test checkout
        library.checkoutBook("313-1231123", 1);
        library.checkoutBook("055-8023131", 1);
        library.checkoutBook("978-0451524935", 99);
        
        // Test return
        library.returnBook("313-1231123", 1);
        library.returnBook("055-8023131", 1);
    }
}
