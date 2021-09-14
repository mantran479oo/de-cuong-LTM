import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements PT{
    public server() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(3232);
        registry.rebind("server", this);
    }

    @Override
    public String PT(float a, float b) throws RemoteException {
        float x=0;
        String kq;
        if(a>0||a<0){
            x=  (-b/a);
            kq="Phuong trinh co nghiem duy nhat: "+x;
        }
        else if (a==0&b==0){
            kq="Phuong trinh co vo so nghiem";

        }
        else  {
            kq="Phuong trinh vo nghiem ";
        }
        return kq;

    }
    public static void main(String[] args) throws RemoteException {
        server s = new server();
    }
}