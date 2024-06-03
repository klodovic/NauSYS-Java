package hr.stratusit.webshop;

import hr.stratusit.webshop.dal.ProductLoader;
import hr.stratusit.webshop.model.Boat;
import hr.stratusit.webshop.model.Product;
import hr.stratusit.webshop.service.ShoppingCart;
import hr.stratusit.webshop.service.IShoppingItem;
import hr.stratusit.webshop.utills.Calculator;
import hr.stratusit.webshop.utills.LoadData;
import hr.stratusit.webshop.utills.Validation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;


@SpringBootApplication
public class Main {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(Main.class, args);

		/* Task 1 */
		//Reading csv file
		LoadData loadData = new LoadData();
	    List<Boat> boats = loadData.readCSV();

		System.out.println();
		System.out.println("**********  TASK 1 - CSV  **********");
        for (Boat boat : boats) {
            System.out.println(boat.getId() + " Boat: " + boat);
        }
		System.out.println();

		// Calculator
		Calculator calculator = new Calculator();
		Validation validation = new Validation();

		// User inputs
		int id = 3;
		String rentalStart = "06.01.2021";
		String rentalEnd = "08.01.2021";

		// Input validation and calculation
		if (!validation.isDateValid(rentalStart, rentalEnd)){
			System.out.println("Error: The date must be in 2021.");
		}
		else if (!validation.isRentalEndsBeforeRentalStart(rentalStart, rentalEnd)){
			System.out.println("Error: End of rental date can't be lower than start of rental date...");
		}
		else {
			String output = calculator.calculatePrice(boats, id, rentalStart, rentalEnd);
			System.out.println("Rental price is: " + output);
		}

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println();

		/* Task 2 */
		//Web shop
		System.out.println("**********  TASK 2 - WEB SHOP  **********");
		System.out.println("*** Cart before adding items ***");

		// Products
		ProductLoader productLoader = new ProductLoader();
		Product p = productLoader.getProducts().get(0);
		Product p1 = productLoader.getProducts().get(1);
		Product p2 = productLoader.getProducts().get(2);

		//Creating cart
		ShoppingCart cart = new ShoppingCart(2L,"Marko");

		//Shopping cart is empty
		System.out.println("Number of items: " + cart.getItems());
		System.out.println();

		cart.addItem(p, new BigDecimal(1));
		cart.addItem(p1, new BigDecimal(1));
		cart.addItem(p1, new BigDecimal(1));
		cart.addItem(p2, new BigDecimal(2));

		System.out.println("*** Shopping cart after adding items ***");
		for (IShoppingItem c : cart.getItems()){
			System.out.println(c);
		}

		//Total Price
		System.out.println("Total Price: " + cart.getTotalPrice());
		System.out.println();

		System.out.println("*** Shopping cart after removing item ***");
		cart.removeItem(p1,new BigDecimal(1));
		cart.removeItem(p1,new BigDecimal(1));
		cart.removeItem(p2, new BigDecimal(1));
		for (IShoppingItem c : cart.getItems()){
			System.out.println(c);
		}

		//Total Price
		System.out.println("Total Price: " + cart.getTotalPrice());
		System.out.println("------------------------------------------------------------------------------------------------------------------------");

	}
}

