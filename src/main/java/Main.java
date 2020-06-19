import com.google.gson.internal.$Gson$Preconditions;
import spark.Spark;

public class Main {
    public static void main(String[] args){
        System.out.println("i'm get sum spaghett");
        Spark.webSocket("/",webSocket.class);
        Spark.init();
    }
}
