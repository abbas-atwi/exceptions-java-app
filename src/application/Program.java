package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Entre com o numero do quarto");
		int numeroQuarto = sc.nextInt();

		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
//Nao e dps
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reservacao data posterior");
		} else {
			Reservas res = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println(res);

			System.out.println();
			System.out.println("Atualizar a data");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = res.atualizacaoData(checkIn, checkOut);
			if(error != null) {
				System.out.println("Datas invalidas" + error);
			}else {
				System.out.println("Atualizacao : " + res);
			}
		
		
		}

		sc.close();
	}

}
