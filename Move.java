public class Move {
    private static final int MAX_DAMAGE = 25;

    private String name;
    private int damage;

    public Move(String name, int damage) {
        this.name = name;
        if (damage > MAX_DAMAGE) {
            this.damage = MAX_DAMAGE;
            return;
        }
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public String toString() {
        return this.name + " (" + this.damage + " Damage)";
    }

    public boolean equals(Move other) {
        return this.name == other.getName() && this.damage == other.getDamage();
    }
}