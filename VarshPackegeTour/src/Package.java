
public class Package {
	String packageId;
	String sourcePlace;
	String destinationPlace;
	double basicFare;
	int noOfdays;
	double packageCost;
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfdays() {
		return noOfdays;
	}
	public void setNoOfdays(int noOfdays) {
		this.noOfdays = noOfdays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	
	void calculatePackageCost() {
		double gst = 0.12;
		if (noOfdays > 0 && noOfdays <= 5) {
			double ct = basicFare * noOfdays;
			double s = ((ct - 0) * gst);
			packageCost = ((ct - 0) + s);

		} else if (noOfdays > 5 && noOfdays <= 8) {
			double ct = basicFare * noOfdays;
			double discount = ct * 0.03;
			double s = (ct - discount) * gst;
			packageCost = (ct - discount) + s;
		} else if (noOfdays > 8 && noOfdays <= 10) {
			double ct = basicFare * noOfdays;
			double discount = ct * 0.05;
			double s = (ct - discount) * gst;
			packageCost = (ct - discount) + s;
		} else if (noOfdays > 10) {
			double ct = (basicFare * noOfdays);
			double discount = ct * (0.07);
			double s = (ct - discount) * gst;
			packageCost = (ct - discount) + s;
		} else {
			System.out.println("Invalid");
		}

	}
	
	
	

}
