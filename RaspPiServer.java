import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RaspPiServer {
    
    private ServerSocket server;

    public RaspPiServer(){
    }

    public static void main(String[] args){
        RaspPiServer server = new RaspPiServer();
        server.runServer();
    }

    public void runServer(){
        try{
            server = new ServerSocket(12345,100);
            while (true){
                new Controller(server.accept()).start();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private class Controller extends Thread {

        private Socket socket;
        private ObjectInputStream input;
        private String in;

        public Controller(Socket socket){
            this.socket = socket;
            System.out.println("New client at " + socket.getRemoteSocketAddress());
        }

        @Override
        public void run(){
            try{
                input = new ObjectInputStream(socket.getInputStream());
                while (!(in = (String)input.readObject()).equals("close")){
                    System.out.println(in);
                }
            } catch(Exception e){
                e.printStackTrace();
            } finally {
                closeConnection();
                System.out.println("Connection with client @ " + socket.getRemoteSocketAddress() + " closed");
            }
        }

        private void closeConnection() {
            try {
                input.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}