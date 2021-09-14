import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        //lay the dang ki
        Registry reg = LocateRegistry.getRegistry("localhost" ,3232);

       PT server_remote = (PT) reg.lookup("server");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap a: ");
        float a =scanner.nextFloat();
        System.out.println("Nhap b: ");
        float b=scanner.nextFloat();
        System.out.println(server_remote.PT(a,b));




    }
}
