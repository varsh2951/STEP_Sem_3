package Week_7.Assignment;
public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0; // Floored at 0
        }
        System.out.println("c.takeDamage(" + amount + ") -> health = " + health + (health == 0 ? " (floored)" : ""));
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth; // Capped at maxHealth
        }
        System.out.println("c.heal(" + amount + ") -> health = " + health + (health == maxHealth ? " (capped)" : ""));
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}