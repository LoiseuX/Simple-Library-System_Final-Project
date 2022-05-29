
import java.io.Serializable;


public class User implements Serializable{
    public String name;
    public int id;
    
    public void getdata(String name, int id){
        
        this.name=name;
        this.id=id;
    }
    
    public void setdata(){
        System.out.println("\nName: " + name);
        System.out.println("User Id: " + id);
    } 
}
