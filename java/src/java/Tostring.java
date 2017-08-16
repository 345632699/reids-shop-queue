/**
 * Created by xu on 2017/8/16.
 */
public class Tostring {
    public String lastName;
    public String firstName;
    public Tostring(String last, String first) {
        this.lastName = last;
        this.firstName = first;
    }
    public String toString()
    {
        return this.lastName + " " + this.firstName;
    }

    public static void main(String[] args) throws Exception{
        Tostring test = new Tostring("dafsda","dfasfsa");
        System.out.println(test);
        Thread.sleep(60000*10);
    }
}
