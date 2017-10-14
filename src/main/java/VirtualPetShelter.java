import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

public class VirtualPetShelter {
	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	VirtualPet pet = new VirtualPet();

	public Collection<VirtualPet> getPets() {
		return pets.values();
	}

	public void addHomelessPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public VirtualPet getAspecificPet(String name) {
		return pets.get(name);

	}

	public void adoptAPet(String name) {
		pets.remove(name);
	}

	public void feedAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.feedMe();
		}
	}

	public void waterAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.waterPet();
		}
	}

	public void playWithASpecificPet(String name) {
		for (VirtualPet pet : pets.values()) {
			if (pets.containsKey(name)) {
				pet.playWithMe();
			}
		}
	}

	public void putAllPetsToSleep() {
		for (VirtualPet pet : pets.values()) {
			pet.putPetToSleep();
		}
	}

	public void displayPetTitle() {
		System.out.println("This is the status of your pets:");
		System.out.println("Name\t|Hunger\t|Bored\t|Thirst\t|Tiredness");
		System.out.println("-------\t-------\t-------\t-------\t-----------");
		for (VirtualPet pet : pets.values()) {
			System.out.println(pet);
		}
		System.out.println();
	}

	public void displayPetNameAndDescriptions() {
		System.out.println("Name\t|Description");
		for (VirtualPet pet : pets.values()) {
			pet.playWithPetDisplay();
		}
	}

	public void tick() {
		pet.getSelfCare();
		for (VirtualPet pet : pets.values()) {
			pet.tick();
		}
	}
}
