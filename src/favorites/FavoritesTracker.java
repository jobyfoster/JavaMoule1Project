package favorites;

import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FavoritesTracker {
    private static final String FAVORITES_DIR  = "favorites/";

    // Create or Update a favorite
    public static void saveFavorite(String type, String favorite) {
        Path filePath = Paths.get(FAVORITES_DIR + type + ".txt");
        try {
            Files.createDirectories(filePath.getParent());
            Files.writeString(filePath, favorite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read a favorite
    public static String readFavorite(String type) {
        Path filePath = Paths.get(FAVORITES_DIR + type + ".txt");
        try {
            if (Files.exists(filePath)) {
                return Files.readString(filePath, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No favorite saved for " + type;
    }

    // Delete a favorite
    public static void deleteFavorite(String type) {
        Path filePath = Paths.get(FAVORITES_DIR + type + ".txt");
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean doesFavoriteExit(String type) {
        Path filePath = Paths.get(FAVORITES_DIR + type + ".txt");
        return Files.exists(filePath);
    }
}
