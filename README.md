# 🚗 Car Rental System – Java Console Application

This is a simple **Car Rental System** built using **Java**. It allows users to rent and return cars via a console-based interface. The system manages cars, customers, and rental transactions with a basic object-oriented approach.

---

## 📋 Features

- 📦 Add cars and customers
- 🚘 Rent available cars
- 🔁 Return rented cars
- 🧾 View rental confirmation with pricing
- 🧠 Simple object-oriented structure using `Car`, `Customer`, `Rental`, and `RentalSystem` classes
- 📟 Menu-driven interface

---

## 🛠️ Technologies Used

- Java (OOP concepts)
- Scanner for input handling
- Console-based interaction (no GUI)

---

## 🧩 Class Structure

### `Car`
- Holds information like ID, brand, model, rental price per day
- Manages availability status

### `Customer`
- Stores customer name and ID

### `Rental`
- Links a customer to a car for a specific number of rental days

### `RentalSystem`
- Manages the lists of cars, customers, and rental records
- Provides the menu interface for renting and returning cars

---

## 🚀 How to Run

### Prerequisites
- Java installed (JDK 8 or higher)
- Any IDE (like IntelliJ IDEA / Eclipse) or command line

### Steps
1. Clone or download this repository.
2. Open `Carrentalproject.java` in your IDE or editor.
3. Compile and run the file:
   ```bash
   javac Carrentalproject.java
   java Carrentalproject
   ```
4. Follow the on-screen instructions in the terminal.

---

## 💡 Sample Interaction

```
****** Welcome to  Car Rental  System !******

1. Rent a Car
2. Return a Car
3. Exit

Enter your choice : 1

You choose renting a car

Enter your name : Alex

Available Cars:
C001 - Toyota Inova
C002 - Hyundai Creta
C003 - Mahindra Thar

Enter the car ID you want to select : C002
Enter the number of days for rental : 3

***** Rental Information *****
Customer ID : 1
Customer Name : Alex
Car : Hyundai Creta
Total Price : 600.0
Car Id : C002

Confirm rental (Y/N) : Y
Car rented successfully.
```

---

## 📌 Notes

- The project runs in an infinite loop until the user chooses to exit.
- Car availability is checked before rental.
- When a car is returned, it's made available again.
- Each new customer is given an auto-incremented ID.

---

## 📈 Future Enhancements (Optional)

- Add date/time for rental start and end
- Store rental history
- Add file/database storage
- Create a GUI or web version

---


