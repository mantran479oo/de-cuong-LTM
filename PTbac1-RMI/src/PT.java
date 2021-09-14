import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PT extends Remote {
    public String PT(float a, float b) throws RemoteException;
}
