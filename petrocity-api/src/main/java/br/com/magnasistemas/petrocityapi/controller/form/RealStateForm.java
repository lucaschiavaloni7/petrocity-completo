package br.com.magnasistemas.petrocityapi.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.magnasistemas.petrocityapi.model.RealState;

public class RealStateForm {

	@NotNull
	private String name;

	@NotNull
	private int area;

	@NotNull
	private int toilets;

	@NotNull
	private int parkingSpace;

	@NotNull
	private String price;

	@NotNull
	@NotEmpty
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getToilets() {
		return toilets;
	}

	public void setToilets(int toilets) {
		this.toilets = toilets;
	}

	public int getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método responsável pela conversão de RealStateForm para RealState
	 * 
	 * 
	 * @return Objeto convertido.
	 */
	public RealState converter() {
		return new RealState(name, area, toilets, parkingSpace, new BigDecimal(price), description);
	}

	/**
	 * Método responsável pela atualização do cadastro de imoveis
	 * 
	 * @param realState
	 * 
	 * @return Imovel populado conforme formulario
	 */
	public RealState update(RealState realState) {
		realState.setName(this.name);
		realState.setArea(this.area);
		realState.setToilets(this.toilets);
		realState.setParkingSpace(this.parkingSpace);
		realState.setPrice(new BigDecimal(this.price));
		realState.setDescription(this.description);

		return realState;
	}
}
