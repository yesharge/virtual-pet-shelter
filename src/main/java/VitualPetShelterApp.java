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

		do {
			System.out.println("What would you like to do?:");
			System.out.println(
					"1.\tFeed the pets\n2.\tPlay with a pet\n3.\tWater the pets\n4.\tPut the pets to sleep\n5.\tAdmit a pet\n6.\tAdopt a pet\n7.\tDisplay Status\n8.\tQuit");
			menuInput = input.nextLine();

			if (menuInput.equals("1")) {
				homelessPets.feedAllPets();
				homelessPets.displayPetTitle();
			} else if (menuInput.equals("2")) {
				homelessPets.displayPetNameAndDescriptions();
				System.out.println("Enter the name of the pet you would like to play with.");
				String playWithPet = input.nextLine();
				homelessPets.playWithASpecificPet(playWithPet);
				System.out.println("You are playing with "+playWithPet);
			} else if (menuInput.equals("3")) {
				homelessPets.waterAllPets();
			} else if (menuInput.equals("4")) {
				homelessPets.putAllPetsToSleep();
			} else if (menuInput.equals("5")) {
				do {
					System.out.println("Enter the name of the pet you would like to admit:(7 Characters or less");
					String newPetName = input.nextLine();
					System.out.println("Enter a description for the pet.");
					String petDescription = input.nextLine();
					homelessPets.addHomelessPet(new VirtualPet(newPetName, petDescription));
					System.out.println("Would you like to admit another animal? (y/n)");
					continueAdmit = input.nextLine();
				} while (continueAdmit.equals("y"));
				homelessPets.displayPetTitle();
			} else if (menuInput.equals("6")) {
				System.out.println("Name\t|Description");
				for (VirtualPet pet : homelessPets.getPets()) {
					pet.playWithPetDisplay();
				}
				do {
					System.out.println("Enter the name of the pet you would like to adopt?");
					removePet = input.nextLine();
					homelessPets.adoptAPet(removePet);
					System.out.println("Would you like to adopt another pet? (y/n)");
					removePet = input.nextLine();
				} while (removePet.equals("y"));
				System.out.println("Thank you for adopting a pet.");
			} else if (menuInput.equals("7")) {
				homelessPets.displayPetTitle();
			}
			homelessPets.tick();
		} while (!menuInput.equals("8"));
		input.close();
		System.exit(0);

	}

	public static void displayDescription() {

	}
}
