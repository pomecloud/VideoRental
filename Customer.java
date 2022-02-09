import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public double getTotalCharge(){

		List<Rental> rentals = getRentals();
		double totalCharge = 0;

		for (Rental each : rentals) {
			double eachCharge = each.getVideo().getCharge(each.getDaysRented());
			totalCharge += eachCharge;
		}

		return totalCharge;
	}

	public int getTotalPoint(){

		List<Rental> rentals = getRentals();

		int totalPoint = 0;

		for (Rental each : rentals) {
			int eachPoint = 0 ;
			int daysRented = each.getDaysRented();

			eachPoint++;

			if ((each.getVideo().getPriceCode() == Video.NEW_RELEASE) )
				eachPoint++;

			if ( daysRented > each.getDaysRentedLimit() )
				eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty()) ;

			totalPoint += eachPoint ;
		}

		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return totalPoint;
	}

	public String generateReport() {
		String result = "Customer Report for " + getName() + "\n";
		result += "Total charge: " + getTotalCharge() + "\tTotal Point:" + getTotalPoint() + "\n";

		return result;
	}
}
