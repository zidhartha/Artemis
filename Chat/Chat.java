

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Chat extends MiniJava {
    public static void main(String[] args) throws IOException {
        Socket sock = null;
        boolean isServer = false;

        while (true) {
            String input = readString(
                    "Enter <port> in order to start the chat server "
                            + "or <host>:<port> in order to connect to a running server. "
                            + "Enter exit for exiting the chat.\n");
            if (input.equals("exit")) {
                System.out.println("Exiting... ");
                return;
            }

            try {
                int colonIndex = input.indexOf(":");

                if (colonIndex != -1) {
                    String host = input.substring(0, colonIndex);
                    int port = Integer.parseInt(input.substring(colonIndex + 1));
                    sock = new Socket(host, port);
                } else {
                    int port = Integer.parseInt(input);
                    ServerSocket serverSocket = new ServerSocket(port);
                    System.out.println("Server has been established");
                    sock = serverSocket.accept();
                    serverSocket.close();
                    isServer = true;
                }

                break;
            } catch (UnknownHostException e) {
                System.out.println("Incorrect host, try again");
            } catch (NumberFormatException e) {
                System.out.println("Such port does not exist, try agin");
            } catch (IOException e) {
                System.out.println("I/O exception");
            }

        }
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter out = new PrintWriter(sock.getOutputStream())
        ) {

            if (isServer) {
                System.out.println("Server has connected user, you can chat");
                String write = readString("> ");
                out.println(write);
                out.flush();
            } else {
                System.out.println("You connected to a server");
            }

            while (true) {
                // read
                String reader = in.readLine();
                if (reader.equals("exit")) {
                    break;
                }
                System.out.println(reader);

                // write
                String write = readString("> ");
                boolean exit = write.equals("exit");
                write = (isServer ? "Server: " : "Client: ") + write;
                out.println(write);
                out.flush();
                if (exit) {
                    break;
                }
            }

            System.out.println("Exiting... ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sock.close();
        }
    }
}
