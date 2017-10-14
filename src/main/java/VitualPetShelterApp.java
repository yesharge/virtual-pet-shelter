import java.util.Random;
import java.util.Scanner;

public class VitualPetShelterApp {

	public static void main(String[] args) {

		VirtualPetShelter homelessPets = new VirtualPetShelter();
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		String menuInput = null;
		String continueAdmit = null;
		String removePet = null;

		VirtualPet pet1 = new VirtualPet("Cindy", "Always loses her collar", random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet2 = new VirtualPet("Ariel", "", random.nextInt(100) + 1, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet3 = new VirtualPet("Jasmine", "", random.nextInt(100) + 1, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet4 = new VirtualPet("Tiana", "", random.nextInt(100) + 1, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1);

		homelessPets.addHomelessPet(pet1);
		homelessPets.addHomelessPet(pet2);
		homelessPets.addHomelessPet(pet3);
		homelessPets.addHomelessPet(pet4);

		System.out.println("Thank you for volunteering at Yesharge's Virtual Pet Shelter");
		homelessPets.displayPetTitle();
		for (VirtualPet pet : homelessPets.getPets()) {
			System.out.println(pet);
		}

		do {
			System.out.println("What would you like to do?:");
			System.out.println(
					"1.\tFeed the pets\n2.\tPlay with a pet\n3.\tWater the pets\n4.\tPut the pets to sleep\n5.\tAdmit a pet\n6.\tAdopt a pet\n7.\tQuit");
			menuInput = input.nextLine();
			if (menuInput.equals("1")) {
				homelessPets.feedAllPets();
				homelessPets.displayPetTitle();
				for (VirtualPet pet : homelessPets.getPets()) {
					System.out.println(pet);
				}

			} else if (menuInput.equals("2")) {

				System.out.println("Enter the name of the pet you would like to play with.");
				System.out.println("Name\t|Description");
				for (VirtualPet pet : homelessPets.getPets()) {
					pet.playWithPetDisplay();
				}
				String playWithPet = input.nextLine();
				homelessPets.playWithASpecificPet(playWithPet);
			}
			else if (menuInput.equals("3")) {
				homelessPets.waterAllPets();
				homelessPets.displayPetTitle();
				for (VirtualPet pet : homelessPets.getPets()) {
					System.out.println(pet);
				}
			}
			else if (menuInput.equals("4")) {
				homelessPets.putAllPetsToSleep();
			}
			else if (menuInput.equals("5")) {
	do {System.out.println("Enter the name of the pet you would like to admit:(7 Characters or less");
	String newPetName = input.nextLine();
	System.out.println("Enter a description for the pet.");
		String petDescription = input.nextLine();
		homelessPets.addHomelessPet(new VirtualPet(newPetName, petDescription, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1));
		System.out.println("Would you like to admit another animal? (y/n)");
		continueAdmit = input.nextLine();
			} while (continueAdmit.equals("y"));
	homelessPets.displayPetTitle();
	for (VirtualPet pet : homelessPets.getPets()) {
		System.out.println(pet);
	}
			}
			else if (menuInput.equals("6")) {
				System.out.println("Name\t|Description");
			for (VirtualPet pet : homelessPets.getPets()) {
				pet.playWithPetDisplay();
			}
				do {System.out.println("Enter the name of the pet you would like to adopt?");
				removePet = input.nextLine();
				homelessPets.adoptAPet(removePet);
				System.out.println("Would you like to adopt another pet? (y/n)");
				removePet = input.nextLine();
			} while(removePet.equals("y"));
				System.out.println("Thank you for adopting a pet.");
			}
		} while (!menuInput.equals("7"));
		input.close();
		System.exit(0);

	}
}
