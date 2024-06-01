package hr.stratusit.webshop;

import hr.stratusit.webshop.model.Boat;
import hr.stratusit.webshop.model.Product;
import hr.stratusit.webshop.model.RentalPeriod;
import hr.stratusit.webshop.model.ShoppingCart;
import hr.stratusit.webshop.service.IProduct;
import hr.stratusit.webshop.service.IShoppingCart;
import hr.stratusit.webshop.service.IShoppingItem;
import hr.stratusit.webshop.utills.Calculator;
import hr.stratusit.webshop.utills.LoadData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		/* Task 1 */
		//Reading csv file
		LoadData loadData = new LoadData();
	    List<Boat> boats = loadData.readCSV();

		System.out.println();
		System.out.println("**********  TAST 1 - CSV  **********");
		for (int i = 0; i < boats.size(); i++) {
			System.out.println(boats.get(i).getId() + " Boat: " + boats.get(i));
		}
		System.out.println();

		//Calculating rental price
		Calculator calculator = new Calculator();
		int id = 3;
		//String start = "2021-01-01";
		//String start = "2021-04-02";
		//String start = "2021-07-16";
		String start = "2021-10-02";
		int rentalDuration = 2;

	    BigDecimal price = calculator.calculatePrice(boats, id, start, rentalDuration);
		System.out.println("Rental price is: " + price);
		System.out.println();


		/* Task 2 */
		//Webshop
		System.out.println("**********  TASK 2 - WEBSHOP  **********");
		System.out.println("*** Cart before adding items ***");

		Product p = new Product(
				"Honda",
				"Yaht",
				"Lorem Ipsum is simply dummy text",
				new BigDecimal(100),
				new BigDecimal(100));

		Product p1 = new Product(
				"Honda2",
				"Boat",
				"Lorem Ipsum",
				new BigDecimal(170),
				new BigDecimal(200));

		Product p2 = new Product(
				"Yamaha",
				"Boat",
				"Lorem Ipsum - Lorem Ipsum",
				new BigDecimal(55),
				new BigDecimal(300));


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

    }
}

