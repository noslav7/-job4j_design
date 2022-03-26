package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write("Hello, dear friend.".getBytes());
                    String str = in.readLine();
                    if (str.contains("/?msg=Hello")) {
                        System.out.println("Hello");
                    } else if (str.contains("/?msg=Exit")) {
                        server.close();
                    } else  if (str.contains("/?msg=" + "\\w+")) {
                        System.out.println("What");
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Mistake in entered information", e);
        }
    }
}
