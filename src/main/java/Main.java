public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        try {
            System.out.println(StringCalculator.add("1,2,3,4"));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}