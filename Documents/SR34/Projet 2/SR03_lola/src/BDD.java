import java.sql.DriverManager;



public class BDD {
	public static void sauverEnBase(String login, String pwd, String bool_admin) {
		String url = "jdbc:mysql://tuxa.sme.utc/sr03p034";
		String identifiant = "sr03p034";
		String mot_de_passe = "20VKymsC";
		java.sql.Connection cn = null;
		java.sql.Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, identifiant, mot_de_passe);
			st = cn.createStatement();
			String sql = "INSERT INTO `User` (`login`, `mdp`, `admin`) values ('"+ login +"','"+ pwd+"','"+ bool_admin+"')";
			st.executeUpdate(sql);
		}
		catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void lireEnBase () {
		String url = "jdbc:mysql://tuxa.sme.utc/sr03p034";
		String identifiant = "sr03p034";
		String mot_de_passe = "20VKymsC";
		java.sql.Connection cn = null;
		java.sql.Statement st = null;
		java.sql.ResultSet rs = null;
		
		try {
			System.out.println("Base");
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, identifiant, mot_de_passe);
			st = cn.createStatement();
			String sql = "SELECT * FROM `User`";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("login"));
				System.out.println(rs.getString("mdp"));
				System.out.println(rs.getString("admin"));
			}
		}
		catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String verifLoginEnBase (String login, String pwd) {
		String url = "jdbc:mysql://tuxa.sme.utc/sr03p034";
		String identifiant = "sr03p034";
		String mot_de_passe = "20VKymsC";
		String admin = null;
		java.sql.Connection cn = null;
		java.sql.Statement st = null;
		java.sql.ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, identifiant, mot_de_passe);
			st = cn.createStatement();
			String sql = "SELECT * FROM `User` where login='"+ login +"' and mdp='"+pwd+"'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				admin = rs.getString("admin");
			}
		}
		catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	return admin;
	}
}
