package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		catch(ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
				
		sc.close();
	}
}

/*
-----------------------------------------------------------------------------------------
Program:
System.out.println(reservation.updateDates(checkIn, checkOut);

-----------------------------------------------------------------------------------------

Reservation:
Date now = new Date();
if (checkIn.before(now) || checkOut.before(now)) {
	return "Error in reservation: Reservation dates for update must be future dates.";
}
else if (checkOut.before(checkIn)) {
	return "Error in reservation: Check-out date must be after check-in date.";
}
else {
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	return toString();
}
------------------------------------------------------------------------------------------
*/
