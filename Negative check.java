import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        try{
            checkNegativeNumber(number);
            System.out.println("The number is: "+number);
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        } catch(Exception e){
            System.out.println("An unexcepted error: "+e.getMessage());
        }finally{
            scanner.close();
        }
    }
    public static void checkNegativeNumber(int number){
        if(number < 0){
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
    }
}
