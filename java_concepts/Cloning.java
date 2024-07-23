package java_concepts;

import java.util.ArrayList;
import java.util.List;

class Book {
    String name;
    int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", pages=" + pages + "]";
    }

}

class Student implements Cloneable {
    String name;
    List<Book> books;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", books=" + books + "]";
    }

    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.books = List.copyOf(this.books);
        return s;
    }
}

public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {

        Book book1 = new Book("Harry Potter", 500);
        Book book2 = new Book("Kite runner", 257);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Student s1 = new Student("Sadiq");
        s1.setBooks(books);

        Student s2 = (Student) s1.clone();

        System.out.println(s1);
        System.out.println(s2);

        // adding books in s1
        s1.getBooks().add(new Book("To kill a mockingbird", 200));
        System.out.println(s1);
        System.out.println(s2); // even for s2 we will get 3 books [ This is shallow copy ]

        // individual items are not copied deeply
        s1.books.get(0).setName("Test");

        System.out.println(s1);
        System.out.println(s2);

    }

}
