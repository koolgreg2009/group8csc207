package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private final Connection conn;

    public DatabaseInitializer(Connection conn) {
        this.conn = conn;
    }

    public void initializeSchema() throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    username TEXT PRIMARY KEY,
                    password TEXT NOT NULL,
                    name TEXT,
                    email TEXT,
                    phone TEXT
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS bookmarks (
                    username TEXT,
                    pet_id INTEGER,
                    timestamp TEXT,
                    PRIMARY KEY (username, pet_id),
                    FOREIGN KEY (username) REFERENCES users(username)
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS preferences (
                    username TEXT PRIMARY KEY,
                    species TEXT,
                    min_age INTEGER,
                    max_age INTEGER,
                    activity_level TEXT,
                    location TEXT,
                    gender TEXT,
                    FOREIGN KEY (username) REFERENCES users(username)
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS preferred_breeds (
                    username TEXT,
                    breed TEXT,
                    PRIMARY KEY (username, breed),
                    FOREIGN KEY (username) REFERENCES users(username)
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS pets (
                    pet_id INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    owner TEXT,
                    email TEXT,
                    phone_num TEXT,
                    species TEXT,
                    pet_age INTEGER,
                    breed TEXT,
                    bio TEXT,
                    activity_level TEXT,
                    gender TEXT,
                    location TEXT,
                    is_available INTEGER,
                    img_url TEXT
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS notifications (
                notification_id INTEGER PRIMARY KEY,
                username TEXT,
                message TEXT);""");

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS locations (
                location_id INTEGER PRIMARY KEY,
                data TEXT UNIQUE
                 );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS breeds (
                breed_id INTEGER PRIMARY KEY,
                data TEXT UNIQUE
                 );
            """);
        }

    }
}