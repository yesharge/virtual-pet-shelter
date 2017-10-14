
import java.util.Random;

public class VirtualPet {
	// Instance Variables
	private int hunger;
	private int boredom;
	private int thirst;
	private int tiredness;
	private int selfCare;
	private String name;
	private String description;
	Random random = new Random();

	// Constructor

	public VirtualPet(String name, String description, int hunger, int boredom, int thirst, int tiredness) {
		this.description = description;
		this.hunger = hunger;
		this.boredom = boredom;
		this.thirst = thirst;
		this.tiredness = tiredness;
		this.name = name;

	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		hunger = random.nextInt(100) + 1;
		boredom = random.nextInt(100) + 1;
		thirst = random.nextInt(100) + 1;
		tiredness = random.nextInt(100) + 1;
	}

	public String getName() {
		return name;
	}

	public void feedMe() {
		if (hunger <= 50) {
			hunger += 50;
		}
	}

	public void playWithMe() {
		if (boredom <= 55) {
			boredom += 45;
		}
		if (thirst >= 10) {
			thirst -= 10;
		}
		if (tiredness >= 35) {
			tiredness -= 35;
		}
	}

	public void sleep() {
		if (tiredness <= 55) {
			tiredness += 45;
		}
		if (hunger >= 30) {
			hunger -= 30;
		}
	}

	public void waterPet() {
		if (thirst <= 45) {
			thirst += 45;
		}
	}

	public void putPetToSleep() {
		if (tiredness <= 45) {
			tiredness += 45;
		}
	}

	public void tick() {
		selfCare = random.nextInt(15) + 1;

		if (selfCare == 5) {
			System.out.println("Good news! Someone adopted all of the pets in the shelter!");
			System.exit(0);
		}
		if (hunger >= 10) {
			hunger -= 10;
		}
		if (boredom >= 10) {
			boredom -= 10;
		}
		if (tiredness >= 10) {
			tiredness -= 10;
		}
		if (thirst >= 10) {
			thirst -= 10;
		}
	}

	public int getHunger() {
		return hunger;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getThirst() {

		return thirst;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void playWithPetDisplay() {
		System.out.println(name + "\t|" + description);
	}

	@Override
	public String toString() {
		return "" + this.name + "\t|" + this.hunger + "\t|" + this.boredom + "\t|" + this.thirst + "\t|"
				+ this.tiredness;
	}

}
