public class ComputerTrainer extends PokemonTrainer {
    private static final String[] POKEMON_NAMES = { "Pikachu", "Bulbasaur", "Charmander", "Squirtle" };

    private PokemonImages images;

    public ComputerTrainer(String name, PokemonImages images) {
        super(name);
        this.images = images;
        while (addRandomPokemon())
            ;
    }

    public boolean addRandomPokemon() {
        String name = POKEMON_NAMES[(int) (Math.random() * POKEMON_NAMES.length)];
        return addPokemon(new Pokemon(name, images.getPokemonImage(name)));
    }

    public Move chooseRandomMove() {
        Pokemon currentBattlingPokemon = getNextPokemon();
        if (getNextPokemon() == null) {
            return null;
        }
        return currentBattlingPokemon.getMoves().get((int) (Math.random() * currentBattlingPokemon.getMoves().size()));
    }
}
