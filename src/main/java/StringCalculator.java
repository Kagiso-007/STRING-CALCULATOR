import java.util.regex.Pattern;
public class StringCalculator {
    static int add(String input) throws IllegalArgumentException {
        int sum = 0;
        String[] values;
        String[] delimiters;
        String delimiter;
        StringBuilder invalidValues = new StringBuilder();
        if(input.equals("")){
            return 0;
        }else if(input.contains("\n") && !input.startsWith("//")) {
            values = Pattern.compile("\\D").split(input);
        }else if(input.startsWith("//")){
            String[] str = input.split("\n");
            //Pattern below used to match different delimiters of any length
            if(Pattern.compile("[/]{2}(\\[).+(])(\\[).+(])").matcher(str[0]).matches()) {
                delimiters = str[0].substring(2).split("]");
                for (String a: delimiters) {
                    a = a.substring(1);
                    str[1] = str[1].replace(a,",");
                }
                values = str[1].split(",");
            }else {
                delimiter = str[0].substring(2);
                values = Pattern.compile("[" + delimiter + "]+").split(str[1]);
            }
        }else {
            values = input.split(",");
        }
        if(input.startsWith(" ")|input.contains("//")&&!input.startsWith("//")|!Character.isDigit(input.charAt(input.length()-1))){
            throw new IllegalArgumentException("ERROR: invalid input");
        }
        for (String a: values) {
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