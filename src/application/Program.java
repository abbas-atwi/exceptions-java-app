package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {

			System.out.println("Entre com o numero do quarto");
			int numeroQuarto = sc.nextInt();

			System.out.print("Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check-Out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservas res = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println(res);

			System.out.println();
			System.out.println("Atualizar a data");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			res.atualizacaoData(checkIn, checkOut);
			System.out.println(res);

		} catch (ParseException e) {
			System.out.println("Data invalida");
		} catch (DomainException e) {
			System.out.println("Error na reservacao " + e.getMessage());
		}catch(RuntimeException e ) {
			System.out.println("Error inesperado");
		}
		sc.close();
	}

}
