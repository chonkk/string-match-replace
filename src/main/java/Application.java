import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args){
        String msg = "{\"id\":\"333\",\"passwd\":4545,\"others\":\"test\",\"account_pwd\":\"12345\",\"some\":\"some\"}";
        System.out.println(msg);
        Pattern pattern = Pattern.compile("\"passwd\":(\\d{1,5}),(.*)\"account_pwd\":\"(\\w*)\"");
        Matcher matcher = pattern.matcher(msg);
        if(matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.replaceAll("\"passwd\":****,$2\"account_pwd\":\"****\""));
        }
    }
}
