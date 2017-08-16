package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xu on 2017/8/16.
 */
public class ServerThread extends Thread {
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //获取输入流，并读取客户端信息
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            String name = bufferedReader.readLine();
            while ((info=bufferedReader.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();
            //获取输出流，响应客户端的请求
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您:"+name);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            //关闭资源
            try {
                if(printWriter!=null)
                    printWriter.close();
                if(outputStream!=null)
                    outputStream.close();
                if(bufferedReader!=null)
                    bufferedReader.close();
                if(inputStreamReader!=null)
                    inputStreamReader.close();
                if(inputStream!=null)
                    inputStream.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
