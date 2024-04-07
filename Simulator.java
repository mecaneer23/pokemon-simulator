import java.util.Scanner;

public class Simulator {
    private static Scanner scan = new Scanner(System.in);
    private static PokemonImages images = new PokemonImages();

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("Welcome to the Pokemon Simulator!");
        System.out.println("=================================");

        System.out.print("What is your first trainer's name? ");
        setUpTrainer();
        System.out.print("What is your second trainer's name? ");
        setUpTrainer();
        scan.close();
    }

    private static void setUpTrainer() {
        PokemonTrainer trainer = new PokemonTrainer(scan.nextLine());

        System.out.println("Hello " + trainer + "!\n");

        System.out.print("What is your first pokemon's name? ");
        createPokemon(scan.nextLine(), trainer);
        System.out.print("What is your second pokemon's name? ");
        createPokemon(scan.nextLine(), trainer);
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
