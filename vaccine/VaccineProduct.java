package vaccine;

public class VaccineProduct {
	private int vaccineNum;
	private double capacity;
	private Date productDate;
	private Date expireDate;
	
	public VaccineProduct(int vaccineNum, double capacity, Date productDate, Date expireDate) {
		this.vaccineNum = vaccineNum;
		this.capacity = capacity;
		this.productDate = new Date(productDate);
		this.expireDate = new Date(expireDate);
	}

	public int getVaccineNum() {
		return vaccineNum;
	}

	public void setVaccineNum(int vaccineNum) {
		this.vaccineNum = vaccineNum;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date limitDate) {
		this.expireDate = limitDate;
	}
	
	public String toString() {
		return String.format("%d �� | %.2f ml | ������ %s | ��ȿ�� %s", vaccineNum, capacity, productDate.toString(), expireDate.toString());
	}
}
