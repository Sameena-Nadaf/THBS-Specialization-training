import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.sql.PreparedStatement;

public class Main {
	public static void main(String[] args) throws IOException, InvalidPackageException {
		DBHandler db1 = new DBHandler();
//		 db1.estabilishConnection();
		TravelAgency tag = new TravelAgency();
		List<Package> list = tag.generatePackageCost("VarshTourPackageDetails.txt");
		System.out.println("VARSH TOUR PACKAGES :");
		System.out.println("-----------------------");
		java.util.Iterator<Package> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println();
		}

		System.out.println();
		System.out.println("PACKAGES WITH MINIMUM NUMBER OF DAYS : ");
		System.out.println("-----------------------------------------");
		List<Package> li1 = tag.findPackagesWithMinimunNumberOfDays();
		java.util.Iterator<Package> iterator1 = li1.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
			System.out.println();
		}
	}
}
