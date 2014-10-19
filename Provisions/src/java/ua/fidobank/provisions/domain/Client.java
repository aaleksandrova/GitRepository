package ua.fidobank.provisions.domain;

import java.util.Map;

public class Client {

	private String inn;
	private Long id;
	private String name;
	private String finStatus;
	private int points;
	private String residency;
	private String insiders;
	public Map<Long, Deal> deals;

	public Client() {

	}

	public Client(String inn, Long id, String name, String finStatus,
			int points, String residency, String insiders, Map<Long, Deal> deals) {

		this.inn = inn;
		this.id = id;
		this.name = name;
		this.finStatus = finStatus;
		this.points = points;
		this.residency = residency;
		this.insiders = insiders;
		this.deals = deals;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFinStatus() {
		return finStatus;
	}

	public void setFinStatus(String finStatus) {
		this.finStatus = finStatus;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getResidency() {
		return residency;
	}

	public void setResidency(String residency) {
		this.residency = residency;
	}

	public String getInsiders() {
		return insiders;
	}

	public void setInsiders(String insiders) {
		this.insiders = insiders;
	}

	public Map<Long, Deal> getDeals() {
		return deals;
	}

	public void setDeals(Map<Long, Deal> deals) {
		this.deals = deals;
	}

	@Override
	public String toString() {
		return "Client [inn=" + inn + ", id=" + id + ", name=" + name
				+ ", finStatus=" + finStatus + ", points=" + points
				+ ", residency=" + residency + ", insiders=" + insiders
				+ ", deals=" + deals + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
