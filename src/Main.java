import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        this.isAvailabal=true;
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
        return isAvailabal;
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

class Rentals{
    private  car car;
    private customer customer;

    private int days;


    public Rentals(car car,customer customer,int days){
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
  class CarReantalSystem{
    private List<car> cars;
    private List<customer> customers;
  private List<Rentals> rental;

  public CarReantalSystem(){
      cars=new ArrayList<>();
      customers=new ArrayList<>();
      rental=new ArrayList<>();

  }

  public void addCar(car car){
      cars.add(car);
  }
  public void addCustomer(customer customer){
      customers.add(customer);

  }
  public void rentCar(car car,customer customer,int days){
      if (car.isAvailabal()){
          car.rent();
          rental.add(new Rentals(car,customer,days));
      }else {
          System.out.println("car is not avilabale for rent mo cars in ");
      }
  }
  public void retunCar(car car){
      car.returnCar();
      Rentals rentalToRemove=null;
      for (Rentals rental:rental);

  }
  }

