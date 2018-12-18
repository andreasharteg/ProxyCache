import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Console output:
GET http://hmpg.net/ HTTP/1.1
Host: hmpg.net
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/*;q=0.8
        Accept-Language: da,en-US;q=0.7,en;q=0.3
        Accept-Encoding: gzip, deflate
        Connection: keep-alive
        Cookie: __utma=8033835.284852002.1541614084.1541614084.1541614084.1; __utmb=8033835; __utmc=8033835; __utmz=8033835.1541614084.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none)
        Upgrade-Insecure-Requests: 1
        If-Modified-Since: Thu, 26 Jul 2012 19:37:56 GMT
        Cache-Control: max-age=0
 */

public class ProxyServerPrintRequest {

    public static void main(String[] args) {

        int portNumber = 4000;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client found on " + clientSocket.getLocalPort());
            /*BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            */
            DataInputStream fromClient = new DataInputStream(clientSocket.getInputStream());
            String line;

            while ((line = fromClient.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Closing server");
            fromClient.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
