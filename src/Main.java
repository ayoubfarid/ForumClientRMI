import impl.Forum;
import impl.User;
import impl.UserImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
   // private UserInterface.ui.HomeFrame homeFrame;
    /*
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        int port= 1245;
        Forum forum = (Forum)Naming.lookup(String.format("rmi://localhost:%s/forum",port));
        System.out.println("forum is ready.");
        User user = new UserImpl(forum);
       // UserInterface.ui.HomeFrame  homeFrame=new UserInterface.ui.HomeFrame();
        System.out.println("impl.User created");

        Scanner sc = new Scanner(System.in);
        System.out.println("tapez votre nom :");
        String nom = sc.nextLine();
        ((UserImpl) user).setName(nom);
        System.out.println("tapez msg :");
        String msg = sc.nextLine();

        while (!msg.equals("exit")) {
            System.out.println("tapez msg :");
            user.ecrire(msg);
            msg = sc.nextLine();
        }

    }*/
   public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
       // port 1245 is used by the server
       int port= 1245;
       // forum is getted from the registry
       Forum forum = (Forum) Naming.lookup(String.format("rmi://localhost:%s/forum",port));
       System.out.println("forum is ready.");
       // create a new user
       new UserImpl(forum);
   }
}