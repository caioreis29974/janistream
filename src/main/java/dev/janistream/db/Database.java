package dev.janistream.db;

import dev.janistream.model.Anime;
import dev.janistream.model.Episode;
import dev.janistream.model.HistoryEntry;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String DB_PATH = System.getProperty("user.home") + "/.janistream/history.db";
    private Connection connection;

    public Database() throws SQLException {
        new File(System.getProperty("user.home") + "/.janistream").mkdirs();
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        createTable();
    }

    private void createTable() throws SQLException {
        String sql = """
        CREATE TABLE IF NOT EXISTS history (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            anime_title TEXT NOT NULL,
            episode_number INTEGER NOT NULL,
            episode_title TEXT,
            watched_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
    """;
        connection.createStatement().execute(sql);
    }

    public void saveHistory(Anime anime, Episode episode) throws SQLException {
        String sql = "INSERT INTO history (anime_title, episode_number, episode_title) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, anime.getTitle());
        stmt.setInt(2, episode.getNumber());
        stmt.setString(3, episode.getTitle());
        stmt.executeUpdate();
    }

    public List<HistoryEntry> getHistory() throws SQLException {
        String sql = "SELECT * FROM history ORDER BY watched_at DESC";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        List<HistoryEntry> history = new ArrayList<>();
        while (rs.next()){
            history.add(new HistoryEntry(
                    rs.getInt("id"),
                    rs.getString("anime_title"),
                    rs.getInt("episode_number"),
                    rs.getString("episode_title"),
                    rs.getString("watched_at")
            ));
        }
        return history;
    }

}
