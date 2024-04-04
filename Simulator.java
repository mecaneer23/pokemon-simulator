public class Simulator {
    public static void main(String[] args) {
        PokemonImages images = new PokemonImages();

        String pikachuImage = images.getPokemonImage("Pikachu");
        System.out.println("Pikachu:\n" + pikachuImage);

        Pokemon charmander = new Pokemon("Charmander");
        String charmanderImage = images.getPokemonImage(charmander);
        System.out.println("Charmander:\n" + charmanderImage);

        String nothingImage = images.getPokemonImage("nothing");
        System.out.println("Nothing:\n" + nothingImage);
    }
}
