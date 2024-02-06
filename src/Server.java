import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        double x;
        String op;
        double y;
        String answer;

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                System.out.println("SERVER: waiting for client...");
                Socket conn = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                PrintWriter printWriter = new PrintWriter(conn.getOutputStream());

                String line = bufferedReader.readLine();

                String[] splitStr;

                splitStr = line.split(" ");

                if (splitStr.length != 3) {
                    printWriter.println("Arrays to big or to small");
                    printWriter.flush();
                    continue;
                }

                try {
                    x = Double.parseDouble(splitStr[0]);
                    op = splitStr[1];
                    y = Double.parseDouble(splitStr[2]);

                    if (op.equals("+")) {
                        answer = String.valueOf(x + y);
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                    else if (op.equals("-")) {
                        answer = String.valueOf(x - y);
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                    else if (op.equals("/")) {
                        answer = String.valueOf(x / y);
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                    else if (op.equals("*")) {
                        answer = String.valueOf(x * y);
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                    else if (op.equals("%")) {
                        answer = String.valueOf(x % y);
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                    else if (op.equals("^")) {
                        answer = String.valueOf(Math.pow(x, y));
                        printWriter.println(answer);
                        printWriter.flush();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    printWriter.println("incorrect format");
                    printWriter.flush();
                }


                System.out.println("Server: received " + line);
                printWriter.println("Invalid Format");
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
