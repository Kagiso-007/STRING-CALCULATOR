import java.util.regex.Pattern;
public class StringCalculator {
    public static void main(String[] args) {
        System.out.println(add("//13\n21358"));
    }
    static int add(String input){
        int sum = 0;
        String[] values;
        if(input.equals("")){
            return 0;
        }else if(input.contains("\n") && !input.startsWith("//")) {
            values = Pattern.compile("\\D").split(input);
        }else if(input.startsWith("//")){
            String[] str = input.split("\n");
            String delimiter = str[0].substring(2);
            values = Pattern.compile(delimiter).split(str[1]);
        }else {
            values = input.split(",");
        }
        for (String a: values) {
            sum+=Integer.parseInt(a);
        }
        return sum;
    }
}