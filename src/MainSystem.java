
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class MainSystem {
    
    static String fileName = null;
    static Library lib = new Library();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;
    
    public static void main(String[] args){
        
        Scanner obj = new Scanner(System.in);
        User obj1 = new User();
        System.out.println("Enter Name: ");
        obj1.name = obj.nextLine();
        System.out.println("\nEnter User Id: ");
        obj1.id = obj.nextInt();
        
        obj1.getdata(obj1.name, obj1.id);
        obj1.setdata();
        
        
        while (running){
            System.out.println("\nEnter 0 to load the library."
                    + "\nEnter 1 to save and quit."
                    + "\nEnter 2 to list all books in the library."
                    + "\nEnter 3 to add book to the library.");
            int answer = in.nextInt();
            switch(answer){
            
            case 0:
             
                System.out.println("\nEnter the saved file name to load.");
                fileName = in.next();
               loadScript(fileName);
                break;
                
            case 1:
                saveAndQuit();
                break;
                
            case 2:
                System.out.println(lib.toString());
                break;
                
            case 3:
                addBook();
                break;
            }
        }
        System.exit(0);
    }
    
    private static void addBook(){
        String title, author;
        int isbn;
        
        System.out.println("\nEnter Book Title: ");
        title = in.next();
        
        System.out.println("\nEnter Author: ");
        author = in.next();
        
        System.out.println("\nEnter ISBN: ");
        isbn = in.nextInt();
        
        Book b = new Book(title, author, isbn);
        lib.addBook(b);
    }
    
    private static void saveAndQuit(){
        System.out.println("\nEnter File name: ");
        fileName = in.next() + ".ser";
        running = false;
                FileOutputStream fos = null;
                ObjectOutputStream out = null;
                try {
                    fos = new FileOutputStream(fileName);
                    out = new ObjectOutputStream(fos);
                    out.writeObject(lib);
                    fos.close();
                    out.close();
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
    }

    private static void loadScript(String fileName) {
                FileInputStream fis = null;
                ObjectInputStream in = null;
                
                File file = new File(fileName + ".ser");
                if (file.exists()){
                    try {
                        fis = new FileInputStream(file);
                        in = new ObjectInputStream(fis);
                        lib = (Library) in.readObject();
                        fis.close();
                        in.close();
                        
                    } catch (IOException e){
                        e.printStackTrace();
                    } catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("\nThe file does not exist.");
                }

    }
}
