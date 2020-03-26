package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-In data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Data de check-In deve ser menor que a de Check-Out!");
		} else {
			Reservation reservation = new Reservation (number,checkIn,checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Entre com a alteração da reserva:");
			
			System.out.println("Check-In data (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Datas nao podem ser passadas");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Data de check-In deve ser menor que a de Check-Out!");
			} else {
				reservation.updataDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);				
			}

		}
		
	}

}
