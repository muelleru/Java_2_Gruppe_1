package db;

import global.Workable;

import java.sql.*;
import java.util.Locale;

public class JDBCTest implements Workable {

    private static String url = "jdbc:mariadb://localhost:3306/wetter?sslMode=disabled&useServerPrepStmts=true";

    @Override
    public void dowork() {
        test3();
    }

    public void test3() {
        DbWetterdaten.getInstance().setMessager(x -> System.out.println("DB: " + x));
        if (DbWetterdaten.getInstance().open()) {

           Wetterdaten wd1 = DbWetterdaten.getInstance().getWetterdaten(2026, 11);
             System.out.println(wd1);

//            for(Wetterdaten wd : DbWetterdaten.getInstance().getWetterdaten()) {
//                System.out.println(wd);
//            }


          //  Wetterdaten wd2 = new Wetterdaten(2026, 11, 90.0, 15.0, 14.3, 3.2, 1);
          //  DbWetterdaten.getInstance().addWetterdaten(wd2);


            DbWetterdaten.getInstance().close();
        }

    }


    /***************************************************************************/
    public void test1() {
        Wetterdaten wd = new Wetterdaten(2026, 11, 90.0, 15.0, 14.3, 3.2, 1);
        insertTest(wd);
        printYearRain(2026);
        // printYearRain( wd.getYyyy() );
    }

    public void test2() {
        Wetterdaten wd = new Wetterdaten(2026, 11, 12.0, 24.0, null, null, 1);
        updateTest(2026, 10, wd);
        printYearRain(2026);
    }

    // Ohne PreparedStatement
    public void updateTest(int yyyy, int mm, Wetterdaten wetterdaten) {
        String sql = """
                    update wetterdaten set 
                        rain = **rain**, 
                        sun = **sun**,
                        tmin = **tmin**,
                        tmax = **tmax**,
                        af = **af**
                     where yyyy = **yyyy** and mm= **mm**;  
                """;
        sql = sql.replace("**rain**", wetterdaten.getRain() == null ? "NULL" : wetterdaten.getRain().toString()).
                replace("**sun**", wetterdaten.getSun() == null ? "NULL" : wetterdaten.getSun().toString()).
                replace("**tmin**", wetterdaten.getTmin() == null ? "NULL" : wetterdaten.getTmin().toString()).
                replace("**tmax**", wetterdaten.getTmax() == null ? "NULL" : wetterdaten.getTmax().toString()).
                replace("**af**", wetterdaten.getAf() == null ? "NULL" : wetterdaten.getAf().toString()).
                replace("**yyyy**", Integer.toString(yyyy)).
                replace("**mm**", Integer.toString(mm));

        System.out.println("SQL (replace): " + sql);
        // update wetterdaten set
        //                        rain = **rain**,
        //                        sun = **sun**
        //                     where yyyy = **yyyy** and mm= **mm**;

        StringBuffer sb = new StringBuffer();
        sb.append("update wetterdaten set ");

        if (wetterdaten.getRain() != null) {
            sb.append("rain = ").append(wetterdaten.getRain()).append(",");
        }
        if (wetterdaten.getSun() != null) {
            sb.append("sun = ").append(wetterdaten.getSun()).append(",");
        }
        if (wetterdaten.getTmax() != null) {
            sb.append("tmax = ").append(wetterdaten.getTmax()).append(",");
        }
        if (wetterdaten.getTmin() != null) {
            sb.append("tmin = ").append(wetterdaten.getTmin()).append(",");
        }
        if (wetterdaten.getAf() != null) {
            sb.append("af = ").append(wetterdaten.getAf()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1); // Letztes Komma löschen
        sb.append(" where yyyy = ").append(yyyy).append(" and ").
                append("mm = ").append(mm).append(";");
        sql = sb.toString();
        System.out.println("SQL: " + sql);

        try (Connection connection = DriverManager.getConnection(url, "root", "")) {
            try (Statement stmt = connection.createStatement()) {
                int result = stmt.executeUpdate(sql);
                System.out.println("Geänderte Datensätze: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertTest(Wetterdaten wetterdaten) {
        String sql = """
                insert into wetterdaten(yyyy,mm,rain,sun,tmax,tmin,af)
                values(?,?,?,?,?,?,?);    
                """;
        try (Connection connection = DriverManager.getConnection(url, "root", "")) {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setInt(1, wetterdaten.getYyyy());
                stmt.setInt(2, wetterdaten.getMm());
                stmt.setDouble(3, wetterdaten.getRain());
                stmt.setDouble(4, wetterdaten.getSun());
                stmt.setDouble(5, wetterdaten.getTmax());
                stmt.setDouble(6, wetterdaten.getTmin());
                stmt.setInt(7, wetterdaten.getAf());

                int result = stmt.executeUpdate();
                System.out.println("Geänderte Datensätze: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printYearRain(int yyyy) {
        String sql =
                """
                        select yyyy, mm, rain, sun, tmax, tmin, af 
                        from wetterdaten
                        where yyyy = ?
                        """;
        try (Connection con = DriverManager.getConnection(url, "root", "")) {
            System.out.println("CONNECTED");
            // con.createStatement(sql)
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, yyyy); // Für ? wird yyyy gesetzt
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        int jahr = rs.getInt("yyyy");
                        int monat = rs.getInt(2);
                        double rain = rs.getDouble("rain");
                        System.out.printf("%d/%d => Rain: %.2f\n", jahr, monat, rain);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
