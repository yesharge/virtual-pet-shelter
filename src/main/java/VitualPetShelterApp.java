import java.util.Random;
import java.util.Scanner;

public class VitualPetShelterApp {

	public static void main(String[] args) {
	
		
		VirtualPetShelter homelessPets = new VirtualPetShelter();
		Random random = new Random();
		Scanner input= new Scanner(System.in);
		
		VirtualPet pet1 = new VirtualPet("Cindy","Always loses her collar", random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1);
		VirtualPet pet2 = new VirtualPet("Ariel","", random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1);
		VirtualPet pet3 = new VirtualPet("Jasmine","", random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1);
		VirtualPet pet4 = new VirtualPet("Tiana","", random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1,random.nextInt(100) + 1);
		
		homelessPets.addHomelessPet(pet1);
		homelessPets.addHomelessPet(pet2);
		homelessPets.addHomelessPet(pet3);
		homelessPets.addHomelessPet(pet4);
		
		System.out.println("Thank you for volunteering at Yesharge's Virtual Pet Shelter");
		homelessPets.displayPetTitle();
		for (VirtualPet pet: homelessPets.getPets()) {
			System.out.println(pet);
		}
		System.out.println("What would you like to do?:");
		System.out.println();
		
	}

}


