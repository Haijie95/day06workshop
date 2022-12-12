package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListServer {
    
    public static void main(String[] args) throws Exception{
        
        Integer port=Integer.parseInt(args[0]);       
        ServerSocket ss = new ServerSocket(port);

        System.out.printf("Listening on port %d\n",port);
        Random rnd=new SecureRandom();

        while(true){
            
                Socket socket=ss.accept();
                System.out.printf("New connection on port %d using %d\n",socket.getLocalPort(),socket.getPort());

                //lecturer edition
                String payload=IOUtils.read(socket);
                String[] values=payload.split(" ");

                Integer count=Integer.parseInt(values[0]);
                Integer range=Integer.parseInt(values[1]);
                
                List<Integer> randNums=new LinkedList<>();
                for(Integer i=0;i<count;i++){
                    randNums.add(rnd.nextInt(range));
                }

                String response= randNums.stream().map(v -> v.toString()).collect(Collectors.joining(":"));

                IOUtils.write(socket,response);
                
                socket.close();
                

        }
        

    }
    

    
}
