import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpClient {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 8080;
        // Create a TCP socket and connect to host:port.
        Socket socket = new Socket(host, port);
        // Create the input and output streams for the network socket.
        BufferedReader in
                = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        PrintWriter out
                = new PrintWriter(socket.getOutputStream());
        //Send request to the HTTP server.
        out.println("GET /index.html HTTP/1.1");
        out.println();
        out.flush();
        // Read the response and display on console.
        /* String line;
        // readline() returns null if server close the network.
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        */
        // Close the I/O streams.
        in.close();
        out.close();
    }
}
