import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public class StringCalculator {
    static int add(String input) throws IllegalArgumentException{
        int sum = 0;
        String[] values = new String[0];
        String[] delimiters = new String[0];
        String delimiter = "";
        StringBuilder invalidValues = new StringBuilder();
        if(input.equals("")){
            return 0;
        }else if(input.contains("\n") && !input.startsWith("//")) {
            values = Pattern.compile("\\D").split(input);
        }else if(input.startsWith("//")){
            String[] str = input.split("\n");
            if(Pattern.compile("[/]{2}(\\[).+(])(\\[).+(])").matcher(str[0]).matches()) {
                delimiters = str[0].split("]");
                String
                String
                for (String a : delimiters) {
                    a = a.substring(1);

                }
                try {
                    values = Pattern.compile("(" + delimiter + ")").split(str[1]);
                } catch (PatternSyntaxException e) {
                    values = Pattern.compile("[" + delimiter.substring(delimiter.length() - 1) + "]{" + delimiter.length() + "}").split(str[1]);
                }
            }else {
                delimiter = str[0].substring(2);
            }
            try {
                values = Pattern.compile("(" + delimiter + ")").split(str[1]);
            } catch (PatternSyntaxException e) {
                values = Pattern.compile("[" + delimiter.substring(delimiter.length() - 1) + "]{" + delimiter.length() + "}").split(str[1]);
            }
        }else {
            values = input.split(",");
        }
        for (String a: values) {
            System.out.println(a);
            if(Integer.parseInt(a)<0){
                invalidValues.append(a).append(",");
            }else if(Integer.parseInt(a)>= 1000){
                continue;
            }else {
                sum += Integer.parseInt(a);
            }
            if(a.equals(values[values.length-1]) && !(invalidValues.toString().isEmpty())){
                invalidValues = new StringBuilder(invalidValues.substring(0, invalidValues.length() - 1));
                throw new IllegalArgumentException("ERROR: negatives not allowed "+invalidValues);
            }
        }
        return sum;
    }
}