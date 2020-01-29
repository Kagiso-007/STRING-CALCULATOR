public class Main {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(StringCalculator.add("1,3,4"));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}