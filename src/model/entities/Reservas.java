package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException( "Erro na reservacao data nao posterior (dps)");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
//		A duracao - noites data de hj menos data da saida
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void atualizacaoData(Date checkIn, Date checkOut)  {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainException( "Somente datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException( "Erro na reservacao data nao posterior (dps)");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	
	}

	@Override
	public String toString() {
		return "Reservas " + "Quartos " + numeroQuarto + ", check-in " + sdf.format(checkIn) + ", check-out "
				+ sdf.format(checkOut) + ", " + duracao() + " noites";
	}

}
