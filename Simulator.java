public class Simulator {
    public static void main(String[] args) {
        PokemonImages images = new PokemonImages();
    Pokemon pikachu = new Pokemon("Pikachu", images.getPokemonImage("Pikachu"));
    System.out.println(pikachu);

    System.out.println("===========================");

    Pokemon riachu = new Pokemon("Riachu");
    System.out.println(riachu);
    }
}
