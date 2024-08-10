import java.util.*;


public class Carrentalproject {


    public static class Car{
        private String carId;
        private String brand;
        private String model;
        private double Priceperday;
        private boolean isAvailable;
    
        public Car(String id, String brand, String model, double price ){
            this.carId = id;
            this.brand = brand;
            this.model= model;
            this.Priceperday = price;
            this.isAvailable = true;
        }
     public String getcarId(){
        return carId;
     }
    
     public String getBrand(){
        return brand;
     }
    
     public String getmodel(){
        return model;
     }
    
     public double getPrice( int days){
        return Priceperday* days;
     }
    
    public boolean isAvailable(){
        return isAvailable;
    }
    
    public void rent(){
        isAvailable =false;
    }
    
    public void returnCar(){
        isAvailable =true;
    }
    }
    
   public  static class Customer {
    
    private String  name;
    private int id;
    
    public Customer(String name , int id ){
        this.name = name;
        this.id = id;
    }
    
    
    public String getname(){
        return name;
     }
    
    
     public int getCustomerId(){
        return id;
     }
    }
    
    public  static class Rental{
    
        private Car car; // creating a car type variable
        private Customer customer;
    
        private int days;
    
        public Rental(Car car, Customer customer, int days){
            this.car = car;
            this.customer= customer;
            this.days=days;
        }
        
    
        public Car getCar(){
            return car;
         }
        
        
         public Customer getCustomer(){
            return customer;
         }
    
         public int getDays(){
            return days;
         }
    }
    public static  class RentalSystem{
    
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    
    public RentalSystem(){
        cars = new ArrayList<>();
        customers= new ArrayList<>();
        rentals = new ArrayList<>();
    }
    
    public void Addcar(Car car){
        cars.add(car);
    }
    
    public void AddCustomer(Customer customer){
       customers.add(customer);
    }
    
    public void rentCar(Car car, Customer customer , int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println(" Sorry!,Car is already rented.");
        }
    }
    
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToremove = null;
    
        for(Rental rental:rentals){
            if(rental.getCar()==car){
                rentalToremove = rental;
                break;
            }
        }
        
        if(rentalToremove!=null){
            rentals.remove(rentalToremove);
           
        }
        else{
            System.out.println("Car was not rented");
        }
    }
    public void menu(){
    
        Scanner sc = new Scanner(System.in);
    
    while(true){
    
        System.out.println("****** Welcome to  Car Rental  System !******");
        System.out.println();
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            System.out.println();
    
           
    
                if(choice ==1){
                    System.out.println(" You choose renting a car");
                    System.out.println();
                    System.out.print(" Enter your name : ");
                   
                    String customerName = sc.nextLine();
                    System.out.println();
            for(Car car: cars){
                if(car.isAvailable()){
                    System.out.println(car.getcarId() + " - " + car.getBrand() + "  " + car.getmodel());
                }
            }
            System.out.println();
            System.out.print("Enter the car ID you want to select :  ");
            String carId = sc.nextLine();
    
            System.out.print("Enter the number of days for rental : ");
            int rentalDays = sc.nextInt();
            sc.nextLine();
            System.out.println();
    
            Customer newCustomer = new Customer(customerName,customers.size()+1);
            AddCustomer(newCustomer);
    
            Car selectedCar = null;
            for(Car car : cars){
                if(car.getcarId().equals(carId) && car.isAvailable()){
                    selectedCar = car;
                    break;
                }
            }
            if(selectedCar!=null){
                double totalprice = selectedCar.getPrice(rentalDays);
    
                System.out.println("***** Rental Information *****");
                System.out.println(" Customer ID : " + newCustomer.getCustomerId());
                System.out.println(" Customer Name : " + newCustomer.getname());
                System.out.println(" Car : " + selectedCar.getBrand() +" "+ selectedCar.getmodel());
                System.out.println(" Total Price : "+totalprice);
                System.out.println(" Car Id : " + selectedCar.getcarId());
                
                System.out.println();
                 System.out.print(" Confirm rental (Y/N) : ");
    
                 String confirm = sc.nextLine();
                 System.out.println();
    
                 if(confirm.equalsIgnoreCase("Y")){
                    rentCar(selectedCar,newCustomer,rentalDays);
                    System.out.println("Car rented successfully.");
                System.out.println();}
                    else{
                        System.out.println(" Rental canceled.");
                        System.out.println();

                    }
                 }
                 else{
                    System.out.println(" Invalid car selected or car not available for rent");
                    System.out.println();
                }
               
            }
            
            else if (choice ==2){
            System.out.println("***** Returning the Car ******");
            System.out.println();
            System.out.print(" Enter the car ID you want to return : ");
            String carid = sc.nextLine();
            Car carToReturn = null;
    
     for(Car car : cars){
                if(car.getcarId().equals(carid) && !car.isAvailable()){
                    carToReturn = car;
                    break;
                }
            }
            
    
            if (carToReturn!=null){ // finding the customer who rented the car
                Customer customer = null;
                for( Rental rental : rentals){
                    if(rental.getCar() == carToReturn){
                        customer  = rental.getCustomer();
                        break;
                    }
                }
            
    
            if(customer!=null){
                returnCar(carToReturn);
                System.out.println("Car returned successfully by : " + customer.getname());
                System.out.println();
            }
            else{
                System.out.println("Car was not returned or rental information is missing");
    
                System.out.println();
            }
        } else{
     System.out.println(" Invalid car Id or car is not rented");
     System.out.println();
        }
            }

        else if(choice == 3){
     System.out.println(" You choose quit");
        break;
        }
    else{
        System.out.println("Invalid input , Please enter a valid number.");
        }

        }  
    }
   
     }
     
     
    public static void main(String args[]){
  
       RentalSystem  carrent = new RentalSystem();
        Car car1 = new Car("C001","Toyota","Inova", 600);
        Car car2 = new Car("C002","Hyundai","Creta", 200);
        Car car3 = new Car("C003","Mahindra","Thar", 300);

        carrent.Addcar(car1);
        carrent.Addcar(car2);
        carrent.Addcar(car3);
        
        carrent.menu();

        System.out.println("Thank you for using our car rental Service !. Please make sure to visit us again. ");
    }
}
