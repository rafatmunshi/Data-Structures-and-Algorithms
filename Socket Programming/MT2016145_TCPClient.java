package tcp2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MT2016145_TCPClient {
	public static void main(String[] args){
		int arr[]=new int[10];
		int arrFromServer[]=new int[10];
		Scanner inFromUser= new Scanner(System.in);
		try (Socket clientSocket = new Socket("localhost",6786)) {
		    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		    DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		    for(int i=0;i<10;i++)
		        arr[i]=inFromUser.nextInt();

		    for(int i=0;i<10;i++)
		        outToServer.writeInt(arr[i]);

		    for(int i=0;i<10;i++)
		        arrFromServer[i]=inFromServer.readInt();

		    for (int i = 0; i < arrFromServer.length; i++) {
		        System.out.println("From Server::"+arrFromServer[i]);
		    }
		    clientSocket.close();
		}
		catch (Exception e) {
			System.out.println("Exception:"+e);
		}
	}
}
