import java.util.Scanner;

public class Game {
    // ANSI color codes
    public static final String RESET = "\u001b[0m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String CYAN = "\u001b[36m";
    public static final String MAGENTA = "\u001b[35m";
    public static final String BOLD = "\u001b[1m";
    public static final String CLEAR_SCREEN = "\u001b[2J";
    public static final String HIDE_CURSOR = "\u001b[?25l";
    public static final String SHOW_CURSOR = "\u001b[?25h";

    public static void main(String[] args) {
        Adventurer enemy = new Mage("Cyberpony", 50);
        Adventurer player = null; 

        Scanner input = new Scanner(System.in);

        System.out.print(CLEAR_SCREEN + HIDE_CURSOR);

        System.out.println(BOLD + CYAN + "Welcome to the Adventure Game!" + RESET);
        System.out.println(GREEN + "What is your character's name?" + RESET);
        String name = input.nextLine();

        System.out.println(YELLOW + "Choose your character's class: " + RESET +
                "\n" + MAGENTA + "Archer (a), Mage (m), Pony (p), Teleporter (t)" + RESET);
        String cClass = input.nextLine().toLowerCase();

        System.out.println(GREEN + "How much HP does your character have?" + RESET);
        int HP = input.nextInt();
        input.nextLine();

        if (cClass.equals("a")) {
            player = new Archer(name, HP);
        } else if (cClass.equals("m")) {
            player = new Mage(name, HP);
        } else if (cClass.equals("p")) {
            player = new Pony(name, HP);
        } else if (cClass.equals("t")) {
            player = new Teleporter(name, HP);
        } else {
            System.out.println(RED + "Invalid class entered. Defaulting to Mage." + RESET);
            player = new Mage(name, HP);
        }

        System.out.println("\n" + BOLD + "Game Start!" + RESET);
        printStatus(player, enemy);

        while (player.getHP() > 0 && enemy.getHP() > 0) {
            System.out.println("\n" + CYAN + "Your turn! Choose an action: " + RESET +
                    GREEN + "attack / special / support / quit" + RESET);
            String action = input.nextLine().toLowerCase();

            if (action.equals("attack")) {
                System.out.println(YELLOW + player.attack(enemy) + RESET);
            } else if (action.equals("special")) {
                System.out.println(MAGENTA + player.specialAttack(enemy) + RESET);
            } else if (action.equals("support")) {
                System.out.println(GREEN + player.support() + RESET);
            } else if (action.equals("quit")) {
                System.out.println(RED + "You quit the game. Goodbye!" + RESET);
                System.out.print(SHOW_CURSOR);
                return;
            } else {
                System.out.println(RED + "Invalid action, try again." + RESET);
                continue;
            }

            if (enemy.getHP() <= 0) {
                System.out.println("\n" + GREEN + "You defeated " + enemy.getName() + "! You win!" + RESET);
                break;
            }

            System.out.println("\n" + RED + "Enemy's turn..." + RESET);
            int enemyAction = (int) (Math.random() * 3);
            if (enemyAction == 0) {
                System.out.println(YELLOW + enemy.attack(player) + RESET);
            } else if (enemyAction == 1) {
                System.out.println(MAGENTA + enemy.specialAttack(player) + RESET);
            } else {
                System.out.println(GREEN + enemy.support() + RESET);
            }

            if (player.getHP() <= 0) {
                System.out.println("\n" + RED + enemy.getName() + " defeated you. Game Over!" + RESET);
                break;
            }

            printStatus(player, enemy);
        }

        System.out.print(SHOW_CURSOR);
        input.close();
    }

    public static void printStatus(Adventurer player, Adventurer enemy) {
        System.out.println("\n" + BOLD + "--- STATUS ---" + RESET);
        System.out.println(BLUE + player.getName() + RESET +
                " - HP: " + GREEN + player.getHP() + RESET +
                " | " + CYAN + player.getSpecialName() + ": " + player.getSpecial() +
                "/" + player.getSpecialMax() + RESET);
        System.out.println(RED + enemy.getName() + RESET +
                " - HP: " + GREEN + enemy.getHP() + RESET +
                " | " + CYAN + enemy.getSpecialName() + ": " + enemy.getSpecial() +
                "/" + enemy.getSpecialMax() + RESET);
        System.out.println(BOLD + "------------------" + RESET);
    }
}