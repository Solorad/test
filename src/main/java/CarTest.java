import java.util.Scanner;

/**
 * @author emorenkov
 */
public class CarTest {
    static class Car {
        public int cost;
        public double mpg;

        public void enterInfo(Scanner reader) {
            System.out.println("Enter cost: ");
            this.cost = reader.nextInt(); // Scans the next token of the input as an int.
            System.out.println("Enter MPG: ");
            this.mpg = reader.nextDouble();
            reader.close();
        }
    }


//    public class App {
//        public static void main(String[] args) {
//            try (Scanner reader = new Scanner(System.in)) {
//                Car car1 = new Car();
//                car1.enterInfo(reader);
//
//                Car car2 = new Car();
//                car2.enterInfo(reader);
//
//                System.out.println(car1.cost);
//            }
//        }
//    }


}
