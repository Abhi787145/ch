import java.io.*;
import java.net.*;



public class MyServer {
	public static void main(String args[]) {
		try{
		ServerSocket ss = new ServerSocket(5000);
		Socket s = ss.accept();

		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1="", str2="";

		while(!str2.equals("stops")) {
			str2 = (String) din.readUTF();
			System.out.println("client:: "+str2);
			str1 = br.readLine();
			dout.writeUTF(str1);
		}

		ss.close();
		s.close();
		din.close();
		dout.close();
		br.close();
		}
		catch(Exception e) { System.out.println(e); }
	}
}
