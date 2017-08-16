import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xu on 2017/8/15.
 */
public class Colllections {
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    private  String string;
    public Colllections(String string )
    {
        this.string = string;
    }
    public static void main(String[] args)
    {
        Colllections c = new Colllections("dsfsadf");
        String test = c.getString();
        System.out.println(test);

        int array[] = {1,23,4,3,45,3,3,2 };
        List list = Arrays.asList(array);
        int b[] = new int[5];
        b[0] = 1;
        System.out.println(b[0]);

        ArrayList arrayList = new ArrayList();
        arrayList.add(0,"dsfdsafasf");
        arrayList.add(1,"dsfdsafasf");
        String[] string = new String[arrayList.size()];
        arrayList.toArray(string);
        System.out.println(string[0]);
        System.out.println(string);

        String dd[] = {"dfasdf","dfasdf"};

        int ddd[] = new int[5];
        ddd[0] = 333;
        ddd[0] = 333;
        ddd[0] = 333;
        ddd[0] = 333;
        System.out.println(Arrays.toString(ddd));

    }
}
