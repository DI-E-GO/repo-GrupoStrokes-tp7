/**
 * 
 */
package ar.edu.unju.fi.tp6.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


/**
 * @author Diego
 *
 */
@Entity
@Table(name = "CLIENTES")
@Component("unCliente")
public class Cliente {
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nro_documento")
	private int nroDocumento;
	@Column(name = "nombre_apellido")
	private String nombreApellido;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column(name = "edad")
	private int edad;
	@Column(name = "cod_area_telefono")
	private int codigoAreaTelefono;
	@Column(name = "nro_telefono")
	private int nroTelefono;
	@Column(name = "fecha_ultima_compra")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tipoDocumento
	 * @param nroDocumento
	 * @param nombreApellido
	 * @param email
	 * @param password
	 * @param fechaNacimiento
	 * @param edad
	 * @param codigoAreaTelefono
	 * @param nroTelefono
	 * @param fechaUltimaCompra
	 */
	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int edad, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	/**
	 * @return String con los dias, meses y días desde la ultima compra de un cliente 
	 */
	public String getTiempoUltimaCompra() {
		Period p = Period.between(fechaUltimaCompra, LocalDate.now());
		return "Última compra:"+p.getYears()+"(años) "+p.getMonths()+"(meses) "+p.getDays()+"(días)";
	}
	/**
	 * @return String con los días desde la fechaNacimiento de un cliente hasta la fecha actual 
	 */
	public String getTiempoFechaNacimiento() {
		long p =ChronoUnit.DAYS.between(fechaNacimiento, LocalDate.now());
		return "Dias desde su nacimiento: "+(int)p+"(días)";
	}
	/**
	 * @return String con los días y hora, hasta el proximo cumpleaños de un cliente
	 */
	public String getTiempoHastaCumpleanos() {
		LocalTime tiempo = LocalTime.of(23, 59, 59);
		LocalTime ahora = LocalTime.now();
		LocalDate sigCumple = this.fechaNacimiento.withYear(LocalDate.now().getYear());
		if (sigCumple.isBefore(LocalDate.now()) || sigCumple.isEqual(LocalDate.now())) {
			sigCumple=sigCumple.plusYears(1);
		}
		tiempo=tiempo.minusHours(ahora.getHour());
		tiempo=tiempo.minusMinutes(ahora.getMinute());
		tiempo=tiempo.minusSeconds(ahora.getSecond());
		Period p = Period.between(LocalDate.now(), sigCumple);
		return "Prox. Cumpleaños: "+p.getDays()+"(días) "+p.getMonths()+"(meses) "+p.getYears()+"(años) "+tiempo.getHour()+":"+tiempo.getMinute()+":"+tiempo.getSecond()+" horas";
	}
	

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the nroDocumento
	 */
	public int getNroDocumento() {
		return nroDocumento;
	}

	/**
	 * @param nroDocumento the nroDocumento to set
	 */
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	/**
	 * @return the nombreApellido
	 */
	public String getNombreApellido() {
		return nombreApellido;
	}

	/**
	 * @param nombreApellido the nombreApellido to set
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the codigoAreaTelefono
	 */
	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	/**
	 * @param codigoAreaTelefono the codigoAreaTelefono to set
	 */
	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	/**
	 * @return the nroTelefono
	 */
	public int getNroTelefono() {
		return nroTelefono;
	}

	/**
	 * @param nroTelefono the nroTelefono to set
	 */
	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	/**
	 * @return the fechaUltimaCompra
	 */
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	/**
	 * @param fechaUltimaCompra the fechaUltimaCompra to set
	 */
	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono="
				+ nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}
	
}
