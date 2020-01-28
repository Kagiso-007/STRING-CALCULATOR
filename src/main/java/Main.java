public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            System.out.println(StringCalculator.add("//[\\*][%]\n1\\*2%3"));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}