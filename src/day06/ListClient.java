package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ListClient {
    
    public static void main(String[] args) throws Exception {
        Integer port=Integer.parseInt(args[3]);
        String host=args[2];
        Integer limit=Integer.parseInt(args[1]);
        Integer n=Integer.parseInt(args[0]);

        Socket socket=new Socket(host,port);
        System.out.printf("Connected to %s : %d on %d\n", host, port,socket.getPort());

        // lecturer edition
        IOUtils.write(socket, "%d %d".formatted(n,limit));

        String response = IOUtils.read(socket);

        socket.close();


    }
}
