import java.awt.*;
import java.lang.invoke.StringConcatException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class car{
    private String carId;
    private String brand;
    private String model;
    private  double basicPrisePerDay;

    private boolean isAvailabal;




    public car(String carId,String brand,String model,double basicPrisePerDay,boolean isAvailabal){
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.basicPrisePerDay=basicPrisePerDay;

    }
    public String getCarId(){
        return carId;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public  double calculatePrice(int rentalDay){
        return basicPrisePerDay* rentalDay;

    }
    public boolean isAvailabal(){
        return true;
    }
    public void rent(){
        isAvailabal=false;
    }
    public void returnCar(){
        isAvailabal=true;
    }
}
class customer{
    private String customerID;
    private  String name;

    public customer (String customerID,String name){
        this.customerID=customerID;
        this.name=name;

    }
    public String getCustomerID(){
        return  customerID;
    }
    public String getName(){
        return name;
    }
}
class Rental{
private  car car;
private customer customer;

private int days;


public Rental(car car,customer customer,int days){
        this.car=car;
        this.customer= customer;
        this.days=days;
        }

public car getCar(){
        return car;
        }
public customer getCustomer(){
        return customer;
        }
public int getDays(){
        return days;
        }

        }

class CarRentalSystem {
    private List<car> cars;
    private List<customer> customers;
    private List<Rental> rentals;


    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(car car) {
        cars.add(car);

    }

    public void addCustomer(customer customer) {
        customers.add(customer);
    }

    public void rentCar(car car, customer customer, int days) {
        if (car.isAvailabal()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));


        } else {
            System.out.println("car is not avilabal for rent");
        }
    }

    public void returncar(car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("car return succesfully ");

        } else {
            System.out.println("car is not rentd");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== car rental system ====== ");
            System.out.println("1.rent a car");
            System.out.println("2.return a car");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("\n== Reant a car ==\n");
                System.out.println("Enter your name");
                String customerName = scanner.nextLine();

                System.out.println("\n avilabal car:");
                for (car car : cars) {
                    if (car.isAvailabal()) {
                        System.out.println(car.getCarId() + "-" + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.println("/n Enter a carID you want to rent");
                String carID = scanner.nextLine();

                System.out.println("Enter a numbar of days for rental");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();
                customer newCustomer = new customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                car selectedCar = null;
                for (car car : cars) {
                    if (car.getCarId().equals(carID) && car.isAvailabal()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n==Rental information ==\n");
                    System.out.println("customer ID" + newCustomer.getCustomerID());
                    System.out.println("customer Name" + newCustomer.getName());
                    System.out.println("car:" + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("rental days" + rentalDays);
                    System.out.println("total price :$%.2f%n" + totalPrice);
                    ;

                    System.out.println("\ncofirm rental (Y/N)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\n car rented succesfully");

                    } else {
                        System.out.println("\n Reantal cancled");
                    }
                } else {
                    System.out.println("\ninvalid car selection or car not avilabal or rent");
                }


            } else if (choice == 2) {
                customer customer = null;

                System.out.println("\n==Return a car==\n");
                System.out.println("Enter a car ID you want to return :");
                String carID = scanner.nextLine();


                car carToReturn = null;
                for (car car : cars) {
                    if (car.getCarId().equals(carID) && !car.isAvailabal()) {
                        carToReturn = car;
                        break;
                    }

                }
                if (carToReturn !=null){
                    customer customer1 =null;
                    for (Rental rental:rentals){
                        if (rental.getCar()== carToReturn){
                            customer=rental.getCustomer();
                            break;
                        }
                    }
                    if (customer !=null){
                        returncar(carToReturn);
                        System.out.println("car return succesully by "+customer.getName());


                    }else {
                        System.out.println("car was not rented or rental imformation is missing");
                    }

                }
                else {
                    System.out.println("invalid car id or car is not rented");
                }

                } else if (choice==3) {
                break;
                
            }
            else {
                System.out.println("invalid chice plse enter a valid option");
            }


        }
        System.out.println("\n Thank you for using the car rental system");
        }
    }
    public class Main {
    public static void main(String[]args){
        CarRentalSystem rentalSystem= new CarRentalSystem();


        car car1=new car("1001","bmw","6x",150.00, true);
        car car2=new car("1002","lambo","6x",150.00, true);
        car car3=new car("1003","fortuner","6x",150.00, true);
        car car4=new car("1004","thar","6x",150.00, true);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.menu();



    }
}
