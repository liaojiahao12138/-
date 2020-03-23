public class Java8Test {

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
       Java8Test java8Test = new Java8Test();
       MathOperation addition = (int a,int b ) -> a + b ;

       MathOperation subtraction = ( a, b) -> a - b;

       MathOperation multiplication = (int a , int b) -> { return a * b ; };





    }
}
