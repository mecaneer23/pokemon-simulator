import java.util.ArrayList;

public class Pokemon {
    private static final int MAX_HEALTH = 100;
    private static final int MAX_MOVES = 4;

    private String name;
    private int health;
    private ArrayList<Move> moves;
    private String image;

    public Pokemon(String name, String image) {
        this.name = name;
        this.health = MAX_HEALTH;
        this.moves = new ArrayList<Move>();
        this.image = image;
    }

    public Pokemon(String name) {
        this(name, null);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void damage(int amount) {
        this.health -= amount;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public boolean knowsMove(Move move) {
        return moves.contains(move);
    }

    public boolean knowsMove(String moveName) {
        for (Move move : moves) {
            if (move.getName().equals(moveName)) {
                return true;
            }
        }
        return false;
    }

    public boolean attack(Pokemon opponent, Move move) {
        if (!knowsMove(move)) {
            return false;
        }
        opponent.damage(move.getDamage());
        return true;
    }

    public boolean attack(Pokemon opponent, String moveName) {
        if (!knowsMove(moveName)) {
            return false;
        }
        for (Move move : moves) {
            if (move.getName().equals(moveName)) {
                opponent.damage(move.getDamage());
            }
        }
        return true;
    }

    public boolean hasFainted() {
        return this.health <= 0;
    }

    public boolean canLearnMoreMoves() {
        return this.moves.size() < MAX_MOVES;
    }

    public boolean learnMove(Move move) {
        if (!canLearnMoreMoves()) {
            this.moves.add(move);
            return true;
        }
        return false;
    }

    public void forgetMove(Move move) {
        if (this.moves.contains(move)) {
            this.moves.remove(move);
        }
    }

    public String toString() {
        return (this.image == null ? "" : this.image) +
                String.format("%s (Health: %s / 100)", this.name, this.health);
    }
}
