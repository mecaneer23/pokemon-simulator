public class ComputerTrainer extends PokemonTrainer {
    private static final String[] POKEMON_NAMES = { "Pikachu", "Bulbasaur", "Charmander", "Squirtle" };
    private static final String[] MOVE_NAMES = { "Tailwhip", "Bodyslam", "Splash", "Shock" };

    private PokemonImages images;

    public ComputerTrainer(String name, PokemonImages images) {
        super(name);
        this.images = images;
        while (addRandomPokemon())
            ;
    }

    public boolean addRandomPokemon() {
        String name = POKEMON_NAMES[(int) (Math.random() * POKEMON_NAMES.length)];
        Pokemon pokemon = new Pokemon(name, images.getPokemonImage(name));
        while (pokemon.learnMove(
                new Move(MOVE_NAMES[(int) (Math.random() * MOVE_NAMES.length)], (int) (Math.random() * 20) + 5)))
            ;
        return addPokemon(pokemon);
    }

    public Move chooseRandomMove() {
        Pokemon currentBattlingPokemon = getNextPokemon();
        if (getNextPokemon() == null) {
            return null;
        }
        return currentBattlingPokemon.getMoves().get((int) (Math.random() * currentBattlingPokemon.getMoves().size()));
    }
}
