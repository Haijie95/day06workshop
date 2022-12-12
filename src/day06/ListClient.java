package day06;

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
        //System.out.printf("<<< %s\n",response);
        //Process response get the average

        String[] randNums=response.split(":");
        Integer totalSum=0;
        for (Integer i=0;i<randNums.length;i++){
            totalSum=totalSum+Integer.parseInt(randNums[i]);
        }
        Integer average=totalSum/randNums.length;
        System.out.printf("Average of the Numbers are: %d",average);

        socket.close();


    }
}
