import redis.clients.jedis.Jedis;

/**
 * Created by xu on 2017/8/16.
 */
public class Redis {
    private static Jedis jedis;
    public static Jedis getJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        jedis.auth("root");
        System.out.println("连接服务成功");
        return jedis;
    }


    public static void main(String[] args){
        Redis.getJedis();
    }
}
