import java.rmi.*;
import java.rmi.registry.*;



public class MyClient {
	public static void main(String args[]) {
		try{
		Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/add");
		System.out.println(stub.add(3,6));
		}
		catch(Exception e) { System.out.println(e); }
	}
}
