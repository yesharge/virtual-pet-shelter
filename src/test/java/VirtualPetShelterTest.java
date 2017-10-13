import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetShelterTest {
	@Test
	public void testIfOnePetIsFed() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new VirtualPet(null,null,23,0,0,0));
		underTest.feedAllPets();
		VirtualPet check = underTest.getAspecificPet(null);
		assertEquals(check.getHunger(), 73);
	}
	@Test
	public void testIfTwoPetsAreFed() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new VirtualPet(null,null,23,0,0,0));
		underTest.addHomelessPet(new VirtualPet("1",null,43,0,0,0));
		underTest.feedAllPets();
		VirtualPet check = underTest.getAspecificPet(null);
		VirtualPet check2 = underTest.getAspecificPet("1");
		assertEquals(check.getHunger(), 73);
		assertEquals(check2.getHunger(), 93);
	}
	@Test
	public void testIfThreePetsAreFed() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new VirtualPet(null,null,23,0,0,0));
		underTest.addHomelessPet(new VirtualPet("1",null,43,0,0,0));
		underTest.addHomelessPet(new VirtualPet("2",null,43,0,0,0));
		underTest.feedAllPets();
		VirtualPet check = underTest.getAspecificPet(null);
		VirtualPet check2 = underTest.getAspecificPet("1");
		VirtualPet check3 = underTest.getAspecificPet("2");
		assertEquals(check.getHunger(), 73);
		assertEquals(check2.getHunger(), 93);
		assertEquals(check3.getHunger(), 93);
	}
	@Test
	public void testIfThreePetsAreWatered() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new VirtualPet(null,null,0,0,23,0));
		underTest.addHomelessPet(new VirtualPet("1",null,0,0,43,0));
		underTest.addHomelessPet(new VirtualPet("2",null,0,0,43,0));
		underTest.waterAllPets();
		VirtualPet check = underTest.getAspecificPet(null);
		VirtualPet check2 = underTest.getAspecificPet("1");
		VirtualPet check3 = underTest.getAspecificPet("2");
		assertEquals(check.getThirst(), 68);
		assertEquals(check2.getThirst(), 88);
		assertEquals(check3.getThirst(), 88);
	}
	@Test
	public void testAS() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new VirtualPet(null,null,10,10,23,0));
		underTest.addHomelessPet(new VirtualPet("1",null,0,0,10,35));
		underTest.addHomelessPet(new VirtualPet("2",null,0,0,43,0));
		underTest.playWithASpecificPet("1");
		VirtualPet check = underTest.getAspecificPet("1");
		
		assertEquals(check.getBoredom(), 45);
		assertEquals(check.getThirst(),0 );
		assertEquals(check.getTiredness(), 0);
	}

}
