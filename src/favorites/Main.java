package favorites;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your favorites tracker!");
        mainloop:
        while (true) {
            System.out.println("Please enter an option from the choices below:");
            System.out.println("1. Save new favorite");
            System.out.println("2. Read a favorite");
            System.out.println("3. Edit a favorite");
            System.out.println("4. Delete a favorite");
            System.out.println("5. Exit program");
            System.out.println("> ");

            String option = scanner.nextLine();
            switch (option) {
                case "1": {
                    System.out.println("What favorite thing would you like to save? (Ex: animal, color, food)");
                    System.out.println("> ");
                    String favoriteThing = scanner.nextLine();

                    System.out.printf("What is your favorite %s?%n", favoriteThing);
                    String thingFavorited = scanner.nextLine();

                    FavoritesTracker.saveFavorite(favoriteThing, thingFavorited);
                    System.out.printf("You have successfully saved %s as your favorite %s!%n%n", thingFavorited, favoriteThing);

                    break;
                }
                case "2": {
                    System.out.println("What favorite thing would you like to read? (Ex: animal, color, food)");
                    System.out.println("> ");
                    String favoriteThing = scanner.nextLine();
                    if (FavoritesTracker.doesFavoriteExit(favoriteThing)) {
                        String favoriteItem = FavoritesTracker.readFavorite(favoriteThing);
                        System.out.printf("Your favorite %s is %s!%n%n%n", favoriteThing, favoriteItem);
                    } else {
                        System.out.printf("You do not have a favorite %s saved!\n", favoriteThing);
                    }

                    break;
                }
                case "3": {
                    System.out.println("What favorite thing would you like to edit? (Ex: animal, color, food)");
                    System.out.println("> ");
                    String favoriteThing = scanner.nextLine();
                    if (FavoritesTracker.doesFavoriteExit(favoriteThing)) {
                        System.out.printf("What do you want to be your new favorite %s?%n", favoriteThing);
                        String thingFavorited = scanner.nextLine();

                        FavoritesTracker.saveFavorite(favoriteThing, thingFavorited);
                        System.out.printf("You have successfully saved %s as your favorite %s!%n%n", thingFavorited, favoriteThing);
                    } else {
                        System.out.printf("You do not have a favorite %s saved!\n", favoriteThing);
                    }

                    break;
                }
                case "4": {
                    System.out.println("What favorite thing would you like to delete? (Ex: animal, color, food)");
                    System.out.println("> ");
                    String favoriteThing = scanner.nextLine();
                    if (FavoritesTracker.doesFavoriteExit(favoriteThing)) {
                        FavoritesTracker.deleteFavorite(favoriteThing);
                        System.out.printf("You have successfully deleted your favorite %s!%n", favoriteThing);
                    } else {
                        System.out.printf("You do not have a favorite %s saved!\n", favoriteThing);
                    }
                    break;
                }
                case "5":
                    break mainloop;
                default:
                    System.out.println("Invalid option!!");
                    break;
            }
        }
    }
}