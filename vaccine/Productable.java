package vaccine;

public interface Productable {
	public abstract VaccineProduct product(int vaccineNum, double capacity, Date productDate, Date expireDate);
	public abstract Date calcProductTime(int productNum);
}