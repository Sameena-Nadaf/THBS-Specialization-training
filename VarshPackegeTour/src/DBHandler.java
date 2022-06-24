import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHandler {
	Connection con = null;

	Connection estabilishConnection() {
		try {
			FileReader reader = new FileReader("db.properties");
			Properties p = new Properties();
			p.load(reader);
			Class.forName(p.getProperty("db.classname"));

			return DriverManager.getConnection(
					p.getProperty("db.url"),
					p.getProperty("db.username"),
					p.getProperty("db.password")
			);

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}
}