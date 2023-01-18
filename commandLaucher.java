import java.util.Scanner;
import java.io.*;
import java.net.*;
public class commandLaucher extends Thread implements Runnable{
	public commandLaucher(Socket i){
sock = i;

}
public void run(){
 try{
	 out = new PrintWriter(sock.getOutputStream(), true);

Scanner sc = new Scanner(sock.getInputStream());
		 cmd = sc.nextLine();
	System.out.println("commande taper : " + cmd);
		Process p =	 Runtime.getRuntime().exec(cmd);
		InputStream in = p.getInputStream();
		StringBuilder build = new StringBuilder();
		char c = (char)in.read();
		while(c !=(char)-1){
		build.append(c);
		c = (char)in.read();
	}
	String response = build.toString();
		out.println(response);
		 }catch(Exception e){
			 out.println("\n" + cmd + ": erreur ");}

}
public PrintWriter out;
public String cmd;
public Socket sock ;
}