import java.rmi.*;
import java.rmi.registry.*;


public class MyServer {
	public static void main(String args[]) {
		try{
		Adder stub = new AdderImpl();
		Naming.rebind("rmi://localhost:5000/add", stub);
		System.out.println("server is started!");
		}
		catch(Exception e) { System.out.println(e); }
	}
}
