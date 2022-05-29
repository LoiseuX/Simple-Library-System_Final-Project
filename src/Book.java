import java.io.Serializable;

public class Book implements Serializable{
    
    public String title, author;
    public int isbn;
    
    public Book(){
        title = null;
        author = null;
        isbn = 0;
    }
    
    public Book(String title, String author, int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    @Override
    public String toString(){
        return "\nTitle: " + title + "\nAuthor: " + author +
                "\nISBN: " + isbn + "\n";                
    }
}