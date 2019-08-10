package multiUsers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A multithreaded chat room server.  When a client connects the
 * server requests a screen name by sending the client the
 * text "SUBMITNAME", and keeps requesting a name until
 * a unique one is received.  After a client submits a unique
 * name, the server acknowledges with "NAMEACCEPTED".  Then
 * all messages from that client will be broadcast to all other
 * clients that have submitted a unique screen name.  The
 * broadcast messages are prefixed with "MESSAGE ".
 *
 * Because this is just a teaching example to illustrate a simple
 * chat server, there are a few features that have been left out.
 * Two are very useful and belong in production code:
 *
 *     1. The protocol should be enhanced so that the client can
 *        send clean disconnect messages to the server.
 *
 *     2. The server should do some logging.
 */
public class Server {

    /**
     * The port that the server listens on.
     */
    private static final int PORT = 4444;
    
    private static int count= 0;

    /**
     * The set of all names of clients in the chat room.  Maintained
     * so that we can check that new clients are not registering name
     * already in use.
     */
    private static HashMap<Integer, String> client = new HashMap<Integer, String>();
    /**
     * The set of all the print writers for all the clients.  This
     * set is kept so we can easily broadcast messages.
     */
    private static HashMap<String, PrintWriter> clientOut = new HashMap<String,PrintWriter>();
    //client ip address.
    private static HashSet<InetAddress> ip= new HashSet<>();
    /**
     * The application main method, which just listens on a port and
     * spawns handler threads.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    /**
     * A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for a dealing with a single client
     * and broadcasting its messages.
     */
    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private int id;

        /**
         * Constructs a handler thread, squirreling away the socket.
         * All the interesting work is done in the run method.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a
         * screen name until a unique one has been submitted, then
         * acknowledges the name and registers the output stream for
         * the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
         */
        public void run() {
            try {

                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("..."+socket.getInetAddress());

                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                while (true) {
                    out.println("SUBMIT NAME");
                    name = in.readLine();
                	String[] arr= name.split(":", 2);
                	name= arr[1];
                    if (name == null) {
                        return;
                    }
                    if (!ip.contains(socket.getInetAddress())) {
                        ip.add(socket.getInetAddress());
                    }
                    else
                    {
                    	out.println("already opened once.");
                    	continue;
                    }
                    synchronized (clientOut) {
                        if (clientOut.get(name) == null) {
                            client.put(count, name);
                            id= count;
                            break;
                        }
                    }
                }

                // Now that a successful name has been chosen, add the
                // socket's print writer to the set of all writers so
                // this client can receive broadcast messages.
                clientOut.put(name, out);
                out.println("NAMEACCEPTED"+name);
                //adding online users to the new user.
                for (int i= 0;i < count;i++) {
                	String str;
					if((str= (String)client.get(i)) != null)
                		out.println("TAB"+i+str);
                }
                
                //adding new user to all the users who are online.
                for (int i= 0;i < count;i++) {
                	PrintWriter wrt;
                	if((wrt= clientOut.get(client.get(i))) != null)
                		wrt.println("TAB"+count+name);
                }
                count++;

                // Accept messages from this client and broadcast them.
                // Ignore other clients that cannot be broadcasted to.
                while (true) {
                	String input= in.readLine();
                	char c1;
                	int c2;
                	String[] arr= input.split(":", 2);
                	if(arr[0].equals("FILE"))
                	{
                		String[] arr1= input.split(":", 3);
                		PrintWriter p= clientOut.get(client.get(Integer.valueOf(arr1[1])));
                		p.println("FILE:"+id+":"+arr1[2]);
                		while((input= in.readLine()) != "stop")
                		{
                			p.println(input);
                			p.flush();
                		}
                		p.println("stop");
                		p.flush();
                		System.out.println("sent.........");
/*                		while((c2= in.read()) != -1)
                		{
                			c1= (char) c2;
                			p.print(c1);
                			p.flush();
                			System.out.print(c2);
                		}
                		System.out.println(c2+".......");
                		p.print((char)-1);*/
                	}
                	else
                		clientOut.get(client.get(Integer.valueOf(arr[0]))).println("MESSAGE:"+id+":"+name+":"+arr[1]);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
            	//remove this client from every other client.(TAB)
            	for (int i= 0;i < count;i++) {
            		PrintWriter wrt;
					if(i != id && (wrt= clientOut.get(client.get(i))) != null)
            			wrt.println("REMOVE"+id);
                }

                if (name != null) {
                	client.remove(id);
                	clientOut.remove(name);
                	ip.remove(socket.getInetAddress());
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}