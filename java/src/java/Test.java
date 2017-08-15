import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xu on 2017/8/15.
 */
public class Test implements Runnable{
    private int i;

    @Override
    public void run() {
        String result = sendGet("http://www.admin.com/","");
        System.out.println(Thread.currentThread().getName()+" "+result);
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param)
    {
        String result = "";
        BufferedReader in = null;
        try{
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            //connect
            URLConnection connection = realUrl.openConnection();
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }
        catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        for(int i = 0;i < 100;i++)
        {
            Test rtt = new Test();
            new Thread(rtt,"新线程"+i).start();
        }

    }
}
