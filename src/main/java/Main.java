public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            System.out.println(StringCalculator.add("//***\n3***5***4"));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}