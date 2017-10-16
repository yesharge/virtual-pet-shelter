import java.util.Random;
import java.util.Scanner;

public class VitualPetShelterApp {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		VirtualPetShelter homelessPets = new VirtualPetShelter();
		Random random = new Random();
		String menuInput = null;
		String continueAdmit = null;
		String removePet = null;

		VirtualPet pet1 = new VirtualPet("Cindy", "Always loses her collar", random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet2 = new VirtualPet("Aurora", "Loves to sleep", random.nextInt(100) + 1, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet3 = new VirtualPet("Jasmine", "Collar has diamond, but no information. Found in an ally",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet4 = new VirtualPet("Tiana", "Notorious for rummaging through restaurant kitchens",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);

		homelessPets.addHomelessPet(pet1);
		homelessPets.addHomelessPet(pet2);
		homelessPets.addHomelessPet(pet3);
		homelessPets.addHomelessPet(pet4);

		System.out.println("Thank you for volunteering at Yesharge's Virtual Pet Shelter");
		homelessPets.displayPetTitle();

		do {
			System.out.println();
			System.out.println("What would you like to do?:");
			System.out.println(
					"1.\tFeed the pets\n2.\tPlay with a pet\n3.\tWater the pets\n4.\tPut the pets to sleep\n5.\tAdmit a pet\n6.\tAdopt a pet\n7.\tDisplay the Pet Status\n8.\tQuit");
			menuInput = input.nextLine();

			if (menuInput.equals("1")) {
				homelessPets.feedAllPets();
				homelessPets.displayPetTitle();
				homelessPets.tick();
			} else if (menuInput.equals("2")) {
				homelessPets.displayPetNameAndDescriptions();
				System.out.println("Enter the name of the pet you would like to play with.");
				String playWithPet = input.nextLine();
				while (!homelessPets.checkIfAPetexists(playWithPet)) {
					System.out.println("I'm sorry that pet does not exist. Re enter the pet name: ");
					playWithPet = input.nextLine();
				}
				homelessPets.playWithASpecificPet(playWithPet);
				homelessPets.tick();
				System.out.println("You are playing with " + playWithPet);
			} else if (menuInput.equals("3")) {
				homelessPets.waterAllPets();
				homelessPets.tick();
			} else if (menuInput.equals("4")) {
				homelessPets.putAllPetsToSleep();
				System.out.println("Zzzzzzzzzzz");
				System.out.println();
				homelessPets.tick();
			} else if (menuInput.equals("5")) {
				do {
					System.out.println("Enter the name of the pet you would like to admit:(7 Characters or less)");
					String newPetName = input.nextLine();
					while (newPetName.length() > 7) {
						System.out.println("Name is too long. Please enter a shorter name.");
						newPetName = input.nextLine();
					}
					System.out.println("Enter a description for the pet.");
					String petDescription = input.nextLine();
					homelessPets.addHomelessPet(new VirtualPet(newPetName, petDescription));
					System.out.println("Would you like to admit another animal? (y/n)");
					continueAdmit = input.nextLine();
				} while (continueAdmit.equals("y"));
				homelessPets.displayPetTitle();
				homelessPets.tick();
			} else if (menuInput.equals("6")) {
				homelessPets.displayPetNameAndDescriptions();
				do {
					System.out.println("Enter the name of the pet you would like to adopt?");
					removePet = input.nextLine();
					while (!homelessPets.checkIfAPetexists(removePet)) {
						System.out.println("I'm sorry that pet does not exist. Re enter the pet name: ");
						removePet = input.nextLine();
					}
					homelessPets.adoptAPet(removePet);
					System.out.println("Would you like to adopt another pet? (y/n)");
					removePet = input.nextLine();
				} while (removePet.equals("y"));
				System.out.println("Thank you for adopting a pet.");
				homelessPets.tick();
			} else if (menuInput.equals("7")) {
				homelessPets.displayPetTitle();
				homelessPets.tick();
			}
		} while (!menuInput.equals("8"));
		input.close();
		System.exit(0);

	}

}
