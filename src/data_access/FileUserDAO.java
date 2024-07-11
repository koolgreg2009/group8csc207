package data_access;

import entity.User.User;
import entity.User.UserFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDAO implements UserDAOInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDAO(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("name", 2);
        headers.put("email", 3);
        headers.put("phone", 4);
        headers.put("bookmark", 5);
        headers.put("user preference", 6);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username, password, name, email, phone, bookmark, user preference");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String name = String.valueOf(col[headers.get("name")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String phone = String.valueOf(col[headers.get("phone")]);
                    String bookmark = String.valueOf(col[headers.get("bookmark")]);
                    String userPreference = String.valueOf(col[headers.get("user preference")]);
                    User user = userFactory.create(username, password, name, email, phone, bookmark, userPreference);
                    accounts.put(username, user);

                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getUserId(), user.getPassword(), user.getName(), user.getEmail(), user.getEmail(), user.getPhone(), user.getBookmark(), user.getPreference);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public String clearUsers() {

        try {
            RandomAccessFile file = new RandomAccessFile(csvFile, "rw");
            file.setLength(0);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder empty = new StringBuilder(new String(""));
        for (User user : accounts.values()) {
            empty.append(user.getName()).append("\n");
        }
        accounts.clear();
        return empty.toString();
    }

}
