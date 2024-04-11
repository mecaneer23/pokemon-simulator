public class ComputerTrainer extends PokemonTrainer {
    private static final String[] POKEMON_NAMES = { "Pikachu", "Bulbasaur", "Charmander", "Squirtle" };

    private PokemonImages images;

    public ComputerTrainer(String name) {
        super(name);
        while (addRandomPokemon())
            ;
        printCollectionLength();
    }

    public boolean addRandomPokemon() {
        String name = POKEMON_NAMES[(int) (Math.random() * POKEMON_NAMES.length)];
        return super.addPokemon(new Pokemon(name, images.getPokemonImage(name)));
    }

    public Move chooseRandomMove() {
        Pokemon currentBattlingPokemon = getNextPokemon();
        if (getNextPokemon() == null) {
            return null;
        }
        return currentBattlingPokemon.getMoves().get((int) (Math.random() * currentBattlingPokemon.getMoves().size()));
    }
}
