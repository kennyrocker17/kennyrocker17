
package audiocenter;
import java.util.Scanner;


public class AudioCenter {
    private boolean CC = false;
    private boolean CD = false;
    private boolean USB = false;
    private String curOut = "";
    private String plSong = "";
    private String plArtist = "";
    

    
    public AudioCenter(){}
   
  
    public AudioCenter createAC(){
     AudioCenter AC = new AudioCenter(); 
     return AC;
    }
    
    public void initialization(){
       
        System.out.println("Hello! Please, select storage: CD, USB, CC.");
        System.out.println("If you want to add storage, please enter NEW INPUT");
        System.out.println("If you want to find out info, please enter INFO ");
        System.out.println("If you want to remove storage, enter insert REMOVE ");
        System.out.println("If you want to turn off AudioCenter, enter insert STOP ");
          Scanner in = new Scanner(System.in);
          String whatsNext = in.nextLine();
            if(null == whatsNext) {System.out.println("Incorrect command. Please, try again."); initialization();} else 
            switch (whatsNext) {
            case "NEW INPUT":
                System.out.println("........................................");
                this.newInput();
                break;
            case "CD":
            case "CC":
            case "USB":
                System.out.println("........................................");
                this.songPlayer(whatsNext);
                break;
            case "INFO":
                 System.out.println("........................................");
                this.infoOut();
                break;
            case "REMOVE":
                System.out.println("........................................");
                this.remove();
                break;
             case "STOP":
                return;
            default:
                System.out.println("Incorrect command. Please, try again.");
                this.initialization();
                break;
        }
            
    }
    
   
    public void newInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please, insert storage");  
        String input = in.nextLine();
        if(null == input) {System.out.println("Incorrect input. Try again."); this.newInput();} else
          switch (input) {
            case "CC":
                this.CC = true;
                System.out.println("CC successfully set");
                break;
            case "CD":
                this.CD = true;
                System.out.println("CD successfully set");
                break;
            case "USB":
                this.USB = true;
                System.out.println("USB successfully set");
                break;
            default:
                System.out.println("Incorrect input. Try again.");
                this.newInput();
                break;
        }
        
         this.initialization();
    }
   
    public void songPlayer(String s){
        if(s.equals("CC") && !this.CC) {System.out.println("Storage not found");System.out.println("........................................"); this.initialization();}
        if(s.equals("CD") && !this.CD) {System.out.println("Storage not found");System.out.println("........................................"); this.initialization();}
        if(s.equals("USB") && !this.USB) {System.out.println("Storage not found");System.out.println("........................................"); this.initialization();}
        this.curOut = s;
        Scanner in = new Scanner(System.in);
          System.out.println("Choose artist");
             this.plArtist = in.nextLine();
             System.out.println("Choose song");
             this.plSong = in.nextLine();
              
          System.out.println("........................................");
          this.infoOut();
    }
   
    public void infoOut(){
        String outs = "";
        if(CC) outs += "CC ";
        if(CD) outs += "CD ";
        if(USB) outs += "USB ";
        String Song =this.plArtist + " - " + this.plSong;
        System.out.println("Available storages: " + outs);
        System.out.println("Current out: " + this.curOut);
        System.out.println("Playing song: " + Song);
  
        System.out.println("........................................");
        this.initialization();
        
    }
    
    public void remove(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pease, select storage you want to remove: ");
        String input = in.nextLine();
        if(null == input) {System.out.println("Incorrect input. Try again."); this.newInput();} else
          switch (input) {
            case "CC":
                this.CC = false;
                System.out.println("CC successfully removed");
                break;
            case "CD":
                this.CD = false;
                System.out.println("CD successfully removed");
                break;
            case "USB":
                this.USB = false;
                System.out.println("USB successfully removed");
                break;
            default:
                System.out.println("Incorrect input. Try again.");
                this.newInput();
                break;
        }
        System.out.println("........................................");
         this.initialization();
    }
    
    public static void main(String[] args) {
       AudioCenter au = new AudioCenter();
       AudioCenter aud = au.createAC();
        
        aud.initialization();
    }
    
}
