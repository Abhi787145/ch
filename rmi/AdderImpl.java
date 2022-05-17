import java.rmi.*;
import java.rmi.server.*;


public class AdderImpl extends UnicastRemoteObject implements Adder {
	public AdderImpl() throws RemoteException {
		super();
	}

	public int add(int x, int y) { return x+y; }
}
