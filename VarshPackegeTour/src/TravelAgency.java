import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelAgency {

	List<Package> generatePackageCost(String filePath) throws IOException, InvalidPackageException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		List<Package> li = new ArrayList<Package>();

		String line;
		while ((line = br.readLine()) != null) {

			String packageId;
			String sourcePlace;
			String destinationPlace;
			String basicFare;
			String noOfdays;
			String packageCost;

			String[] str = line.split(",");
			packageId = str[0];
			sourcePlace = str[1];
			destinationPlace = str[2];
			basicFare = str[3];
			double basFa = Double.parseDouble(basicFare);
			noOfdays = str[4];
			int nod = Integer.parseInt(noOfdays);

			boolean res = validate(packageId);
			if (res == true) {
				Package object = new Package();
				object.setPackageId(packageId);
				object.setSourcePlace(sourcePlace);
				object.setDestinationPlace(destinationPlace);
				object.setBasicFare(basFa);
				object.setNoOfdays(nod);
				object.calculatePackageCost();
				li.add(object);
			}

		}

		return li;

	}
	
		
	
	boolean validate(String packageId) throws InvalidPackageException {

		if (packageId.matches("[0-9]{3}[/]{1}[A-Z]{3}")) {
			return true;
		} else {
			throw new InvalidPackageException();
		}

	}
	
	List<Package> findPackagesWithMinimunNumberOfDays() {
		DBHandler dao = new DBHandler();
		Connection con = dao.estabilishConnection();
		List<Package> li1 = new ArrayList<Package>();

		String query = "SELECT FROM package_details  WHERE no_of_days IN (SELECT min(no_of_days)  FROM package_details  ) ;";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String sp = rs.getString(2);
				String dp = rs.getString(3);
				int bf = rs.getInt(4);
				int nod = rs.getInt(5);
				int pc = rs.getInt(6);
				Package object1 = new Package();
				object1.setPackageId(id);
				object1.setSourcePlace(sp);
				object1.setDestinationPlace(dp);
				object1.setBasicFare(bf);
				object1.setNoOfdays(nod);
				object1.setPackageCost(pc);
				li1.add(object1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return li1;
	}
}
