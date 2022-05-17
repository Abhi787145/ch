import java.rmi.*;
import java.rmi.server.*;



public interface Adder extends Remote {
	public int add(int x, int y) throws RemoteException;
}
