import java.util.regex.Pattern;
public class StringCalculator {
    static int add(String input) throws IllegalArgumentException{
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
            if(Pattern.compile("[/]{2}(\\[).+(])(\\[).+(])").matcher(str[0]).matches()) {
                String d = str[0].substring(2);
                delimiters = d.split("]");
                StringBuilder delimit2 = new StringBuilder();
                for (String a : delimiters) {
                    String escape = "\\";
                        if (a.equals(delimiters[delimiters.length - 1])) {
                            a = a.substring(1);
                            if (a.contains("\\")) {
                                a = a.replace("\\", "\\"+escape);
                            }
                            if (a.contains("-")) {
                                a = a.replace("-", escape+"-");
                            }
                            delimit2.append("[").append(a).append("]").append("+");
                        } else {
                            a = a.substring(1);
                            a = a.replace("-",escape+"-");
                            a = a.replace("\\",escape+"\\");
                            delimit2.append("[").append(a).append("]").append("+").append("|");
                        }
                }
                        values = Pattern.compile(delimit2.toString()).split(str[1]);
            }else {
                delimiter = str[0].substring(2);
                values = Pattern.compile("[" + delimiter + "]+").split(str[1]);
            }
        }else {
            values = input.split(",");
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