import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] firms = new String[3];
        firms[0] = "Nike";
        firms[1] = "Adidas";
        firms[2] = "Puma";
        String[][] trainers = new String[3][2];
        trainers[0][0] = "Nike - Brand 1";
        trainers[0][1] = "Nike - Brand 2";
        trainers[1][0] = "Adidas - Brand 1";
        trainers[1][1] = "Adidas - Brand 2";
        trainers[2][0] = "Puma - Brand 1";
        trainers[2][1] = "Puma - Brand 2";
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите свои данные:");
            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Номер телефона: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Список доступных позиций в магазине:");
            for (int j = 0; j < firms.length; j++) {
                for (int k = 0; k < trainers[j].length; k++) {
                    System.out.println((j + 1) + "." + (k + 1) + " - " + trainers[j][k]);
                }
            }
            System.out.print("Выберите позицию (фирму и бренд): ");
            int firmIndex = Integer.parseInt(scanner.nextLine()) - 1;
            int brandIndex = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.print("Введите количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            Order order = new Order(trainers[firmIndex][brandIndex], quantity);
            Customer customer = new Customer(fullName, email, phoneNumber, order);
            customers.add(customer);
        }
        System.out.println("Информация о клиентах и заказах:");
        for (Customer customer : customers) {
            System.out.println("ФИО: " + customer.getFullName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Номер телефона: " + customer.getPhoneNumber());
            System.out.println("Заказ: " + customer.getOrder().getPosition() + ", Количество: " + customer.getOrder().getQuantity());
            System.out.println("---------------");
        }
    }
}
class Customer {
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    private final Order order;
    public Customer(String fullName, String email, String phoneNumber, Order order) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.order = order;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Order getOrder() {
        return order;
    }
}
class Order {
    private final String position;
    private final int quantity;
    public Order(String position, int quantity) {
        this.position = position;
        this.quantity = quantity;
    }
    public String getPosition() {
        return position;
    }

    public int getQuantity() {
        return quantity;
    }
}