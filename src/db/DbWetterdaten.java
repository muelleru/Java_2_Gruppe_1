package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbWetterdaten {

    @FunctionalInterface
    public interface Message {
        void send(String message);
    }
    // Singleton

    private Message message;

    private void sendMessage(String m) {
        if (message != null) {
            message.send(m);
        }
    }

    public void setMessager(Message messager) {
        this.message = messager;
    }

    private static String connectionString = "jdbc:mariadb://localhost:3306/wetter?sslMode=disabled";
    private static DbWetterdaten instance = null;

    private DbWetterdaten() {

    }

    public static DbWetterdaten getInstance() {
        if (instance == null) {
            instance = new DbWetterdaten();
        }
        return instance;
    }

    private Connection connection;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(connectionString, "root", "");
            sendMessage("Verbindung OK");
            return true;
        } catch (SQLException e) {
            sendMessage("Verbindung nicht möglich");
        }
        return false;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                sendMessage("Verbindung geschlossen");
            } catch (SQLException e) {
                connection = null;
                sendMessage("Verbindung nicht geschlossen oder schon geschlossen");
            }
        }
    }

    // Wetterdaten anhand Jahr und Monat auslesen
    public Wetterdaten getWetterdaten(int yyyy, int mm) {
        String sql =
                """
                        select yyyy, mm, rain, sun, tmax, tmin, af 
                        from wetterdaten
                        where yyyy = ? and mm = ?
                        """;
        Wetterdaten wetterdaten = new Wetterdaten();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, yyyy); // Für ? wird yyyy gesetzt
            statement.setString(2, "10");
             sendMessage(statement.toString());
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    wetterdaten.setYyyy(rs.getInt("yyyy"));
                    wetterdaten.setMm(rs.getInt("mm"));
                    wetterdaten.setRain(rs.getDouble("rain"));
                    wetterdaten.setSun(rs.getDouble("sun"));
                    wetterdaten.setTmax(rs.getDouble("tmax"));
                    wetterdaten.setTmin(rs.getDouble("tmin"));
                    wetterdaten.setAf(rs.getInt("af"));
                } else {
                    sendMessage("Vorsicht ... Daten nicht gefunden");
                }
            }
        } catch (Exception e) {
            sendMessage(e.getMessage());
        }
        return wetterdaten;
    }

    // Alle Wetterdaten auslesen
    // Iterable > Collection > List
    public List<Wetterdaten> getWetterdaten() {
        String sql =
                """
                        select yyyy, mm, rain, sun, tmax, tmin, af 
                        from wetterdaten                         
                        """;
        ArrayList<Wetterdaten> wetterdatenliste = new ArrayList<>();
        Wetterdaten wetterdaten = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    wetterdaten = new Wetterdaten();

                    wetterdaten.setYyyy(rs.getInt("yyyy"));
                    wetterdaten.setMm(rs.getInt("mm"));
                    wetterdaten.setRain(rs.getDouble("rain"));
                    wetterdaten.setSun(rs.getDouble("sun"));
                    wetterdaten.setTmax(rs.getDouble("tmax"));
                    wetterdaten.setTmin(rs.getDouble("tmin"));
                    wetterdaten.setAf(rs.getInt("af"));

                    wetterdatenliste.add(wetterdaten);
                }
            }
        } catch (Exception e) {
            sendMessage(e.getMessage());
        }
        return wetterdatenliste;
    }

    // Wetterdaten für einen Monat öndern

    public void setWetterdaten(int yyyy, int mm, Wetterdaten wetterdaten) {
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
        String sql = sb.toString();
        sendMessage("SQL: " + sql);

        if (connection != null) {
            try (Statement stmt = connection.createStatement()) {
                int result = stmt.executeUpdate(sql);
                sendMessage("Geänderte Datensätze: " + result);
            } catch (Exception e) {
                sendMessage("DB.Error:" + e.getMessage());
            }
        } else {
            sendMessage("Verbindung ist geschlossen");
        }
    }
    // Neue Wetterdaten einfügen

    public void addWetterdaten(Wetterdaten wetterdaten) {
        String sql = """
                insert into wetterdaten(yyyy,mm,rain,sun,tmax,tmin,af)
                values(?,?,?,?,?,?,?);    
                """;
        if (connection != null /*&& !connection.isClosed()*/) {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, wetterdaten.getYyyy());
                stmt.setInt(2, wetterdaten.getMm());
                stmt.setDouble(3, wetterdaten.getRain());
                stmt.setDouble(4, wetterdaten.getSun());
                stmt.setDouble(5, wetterdaten.getTmax());
                stmt.setDouble(6, wetterdaten.getTmin());
                stmt.setInt(7, wetterdaten.getAf());
                int result = stmt.executeUpdate();
                sendMessage("Geänderte Datensätze: " + result);
            } catch (Exception e) {
                sendMessage("Connection-Problem: " + e.getMessage());
            }
        } else {
            sendMessage("Verbindung ist geschlossen");
        }
    }


}
