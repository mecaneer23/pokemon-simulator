import java.util.ArrayList;

public class PokemonTrainer {
    private static final int MAX_POKEMON = 2;

    private String name;
    private ArrayList<Pokemon> collection;

    public PokemonTrainer(String name) {
        this.name = name;
        this.collection = new ArrayList<Pokemon>();
    }

    public boolean addPokemon(Pokemon pokemon) {
        if (this.collection.size() < MAX_POKEMON) {
            this.collection.add(pokemon);
            return true;
        }
        return false;
    }

    public boolean hasLost() {
        for (Pokemon pokemon : this.collection) {
            if (!pokemon.hasFainted()) {
                return false;
            }
        }
        return true;
    }

    public Pokemon getNextPokemon() {
        for (Pokemon pokemon : this.collection) {
            if (!pokemon.hasFainted()) {
                return pokemon;
            }
        }
        return null;
    }

    public String toString() {
        return this.name;
    }
}
