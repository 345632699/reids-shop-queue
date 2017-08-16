package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by xu on 2017/8/16.
 */
public class Client implements Runnable{
    public static void main(String[] args){
        for (int i=0;i<=10;i++){
            Client c = new Client();
            Thread th = new Thread(c,"新线程"+i);
            th.start();
            System.out.println(th.getName());
        }
    }
    public static void send(){
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2.获取输出流，向服务器端发送信息
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out);
            pw.write(Thread.currentThread().getName());
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String info = null;

            while (( info = br.readLine()) != null){
                System.out.println("我是客户端，服务器说："+info);
            }
            //4.关闭资源
            br.close();
            in.close();
            pw.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        send();
    }
}
