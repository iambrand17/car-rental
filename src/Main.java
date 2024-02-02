class car{
    private String carId;
    private String brand;
    private String model;
    private  double basicPrisePerDay;
    private boolean isAvailabalNumber;



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
    private String coustomerID;
    private  String name;

    public customer (String coustomerID,String name){
        this.coustomerID=coustomerID;
        this.name=name;

    }
    public String getCoustomerID(){
        return  coustomerID;
    }
    public String getName(){
        return name;
    }
}

class Retal{

}