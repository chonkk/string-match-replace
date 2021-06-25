import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args){
        String msg = "{\"id\":\"333\",\"passwd\":4545,\"others\":\"test\",\"account_pwd\":\"12345abcd\",\"some\":\"some\"}";
        System.out.println("main::"+msg);
        replaceFunction3(msg);
       replaceFunction1(msg);
        replaceFunction2(msg);
    
        
    }

    private static void replaceFunction3(String msg) {
        Pattern pattern = Pattern.compile("\"account_pwd\":\"(\\w*)\"");
        Matcher matcher = pattern.matcher(msg);
        if(matcher.find()){
            String replace = matcher.group(1).replaceAll("\\w","*");
            String rMsg = "\"account_pwd\":\""+replace+"\"";
            System.out.println("replaceFunction3::"+matcher.replaceAll(rMsg));
        }
    }

    private static void replaceFunction2(String msg) {
        String maskedPassword = msg.replaceAll("\"account_pwd\":\"(\\w*)\"", "\"account_pwd\":\"****\"");
        System.out.println("replaceFunction2::"+maskedPassword);
    }

    private static void replaceFunction1(String msg) {    
        Pattern pattern = Pattern.compile("\"passwd\":(\\d{1,5}),(.*)\"account_pwd\":\"(\\w*)\"");
        Matcher matcher = pattern.matcher(msg);
        if(matcher.find()){
            System.out.println("replaceFunction1::"+matcher.replaceAll("\"passwd\":****,$2\"account_pwd\":\"****\""));
        }
    }
}
