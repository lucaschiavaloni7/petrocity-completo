package br.com.magnasistemas.petrocityapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfVisit;

	@ManyToOne(fetch = FetchType.EAGER)
	private Interested interested;

	@ManyToOne(fetch = FetchType.EAGER)
	private Realtor realtor;

	public Schedule() {
	}

	public Schedule(Date dateOfVisit, Interested interested, Realtor realtor) {
		this.dateOfVisit = dateOfVisit;
		this.interested = interested;
		this.realtor = realtor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Interested getInterested() {
		return interested;
	}

	public void setInterested(Interested interested) {
		this.interested = interested;
	}

	public Realtor getRealtor() {
		return realtor;
	}

	public void setRealtor(Realtor realtor) {
		this.realtor = realtor;
	}

}
