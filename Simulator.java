import java.util.Scanner;

public class Simulator {
    private static Scanner scan = new Scanner(System.in);
    private static PokemonImages images = new PokemonImages();

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("Welcome to the Pokemon Simulator!");
        System.out.println("=================================");

        System.out.print("What is your first trainer's name? ");
        PokemonTrainer trainer = setUpTrainer();

        System.out.print("Press enter for the computer to set up their Pokemon...");
        scan.nextLine();
        ComputerTrainer computer = new ComputerTrainer("Computer");

        playerTurn(trainer, computer);
        computerTurn(trainer, computer);
        // add game loop
        // check for pokemon fainting and print when they have
        // add win condition

        scan.close();
    }

    private static void computerTurn(PokemonTrainer player, ComputerTrainer computer) {
        System.out.println(computer.getName() + "'s Turn!");
        System.out.println(computer.getName() + " chooses:");
        Pokemon current = computer.getNextPokemon();
        if (current == null) {
            return;
        }
        System.out.println(current);
        Move move = computer.chooseRandomMove();
        current.attack(player.getNextPokemon(), move);
        System.out.println(computer.getName() + "'s " + current.getName() + " used " + move + " on "
                + player.getName() + "'s " + player.getNextPokemon());
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    private static void playerTurn(PokemonTrainer player, PokemonTrainer computer) {
        System.out.println(player.getName() + " chooses:");
        Pokemon current = player.getNextPokemon();
        System.out.println(current);
        if (current == null) {
            return;
        }
        System.out.println(current);
        System.out.println("Possible moves:");
        for (Move move : current.getMoves()) {
            System.out.println(move);
        }
        System.out.print(player.getName() + ", choose your move: ");
        String moveName = scan.nextLine();
        current.attack(computer.getNextPokemon(), moveName);
        System.out.println(player.getName() + "'s " + current.getName() + " used " + moveName + " on "
                + computer.getName() + "'s " + computer.getNextPokemon());
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    private static PokemonTrainer setUpTrainer() {
        PokemonTrainer trainer = new PokemonTrainer(scan.nextLine());

        System.out.println("Hello " + trainer + "!\n");

        System.out.print("What is your first pokemon's name? ");
        createPokemon(scan.nextLine(), trainer);
        System.out.print("What is your second pokemon's name? ");
        createPokemon(scan.nextLine(), trainer);
        return trainer;
    }

    private static void createPokemon(String name, PokemonTrainer trainer) {
        Pokemon pokemon = new Pokemon(name, images.getPokemonImage(name));
        trainer.addPokemon(pokemon);
        System.out.println("You chose: ");
        System.out.println(pokemon);

        String moveName;
        int damage;
        Move move;

        while (true) {
            System.out.print("\nWould you like to teach " + pokemon.getName() + " a new move? (y/n): ");
            if (!scan.nextLine().equals("y")) {
                break;
            }
            System.out.print("Enter the name of the move: ");
            moveName = scan.nextLine();
            System.out.print("How much damage does this move do? ");
            damage = scan.nextInt();
            scan.nextLine();
            move = new Move(moveName, damage);
            if (!pokemon.learnMove(move)) {
                System.out.println("Sorry, you can't learn any more moves.");
                return;
            }
            System.out.println(pokemon.getName() + " learned " + move + "!");
            continue;
        }
    }
}

// A PokemonTrainer can only have one active Pokemon at a time.
// When the active Pokemon faints, the PokemonTrainer will use their next
// Pokemon.
// When all of a PokemonTrainer’s Pokemon have fainted, the game is over.
// Allow each PokemonTrainer to take turns choosing a Move for their current
// Pokemon to use on the opponent Pokemon until one PokemonTrainer loses.
