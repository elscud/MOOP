
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Army> army = new Vector<>();
	
	
	
//	void registrasi() {
//		String name;
//		do {
//			System.out.print("Input nama anda: ");
//			name = scan.nextLine();
//		}while(name.length()< 3 || name.length()>20 );
//	}
	
	void start() {
		showArmy();
		int choose = -1;
		do {
			try {
				System.out.print("Choose Army [1 -"+army.size()+"]: ");
				choose = scan.nextInt();
			} catch (Exception e) {
			}
			scan.nextLine();
		}while(choose < 1 || choose > army.size());
		choose--;
		
		int enemyHeroesInfantry, enemyHeroesArcher, enemyTroopsInfantry, enemyTroopsArcher;
		double enemyTroopsRemain = 0, playerTroopsRemain = 0;
		double TroopsCavalry, TroopsArcher;
		double enemyArcherPower, enemyInfantryPower;
		double CavalryPower, ArcherPower;
		if(army.get(choose).getHeroCavalry() == 5) {
			enemyHeroesArcher = 5;
			enemyTroopsArcher = 100000;
			enemyArcherPower = (enemyHeroesArcher*0.4*enemyTroopsArcher) + enemyTroopsArcher;
			CavalryPower = (army.get(choose).getHeroCavalry()*0.4*army.get(choose).getTroopsCavalry());
			TroopsCavalry = army.get(choose).getTroopsCavalry() - (enemyArcherPower *0.4);
			enemyTroopsRemain = (enemyTroopsArcher - (CavalryPower * 0.1));
			System.out.println("Pasukan Cavalry tersisa: "+TroopsCavalry + " Orang");
			System.out.println("Pasukan Archer lawan tersisa: "+ enemyTroopsRemain + " Orang");
			
		}
		else {
			enemyHeroesInfantry = 5;
			enemyTroopsInfantry = 100000;
			enemyInfantryPower = (enemyHeroesInfantry*0.4*enemyTroopsInfantry)+ enemyTroopsInfantry;
			CavalryPower = (army.get(choose).getHeroCavalry()*0.4*army.get(choose).getTroopsCavalry()+ army.get(choose).getTroopsCavalry());
			ArcherPower = (army.get(choose).getHeroArcher()*0.4*army.get(choose).getTroopsArcher() + army.get(choose).getTroopsArcher());
			TroopsCavalry = army.get(choose).getTroopsCavalry() - (enemyInfantryPower *0.1);
			TroopsArcher = army.get(choose).getTroopsArcher() - (enemyInfantryPower *0.4);
			enemyTroopsRemain = (enemyTroopsInfantry - (CavalryPower*0.4) - (ArcherPower*0.1));
			
			
			//System.out.println("Pasukan Infantry lawan tersisa: "+enemyTroopsRemain + " Orang");
			
			if(TroopsArcher < 0) {
				TroopsArcher = 0;
				System.out.println("Pasukan Archer tersisa: "+TroopsArcher + " Orang");
				System.out.println("Pasukan Cavalry tersisa: "+TroopsCavalry + " Orang");
				System.out.println("Pasukan Infantry lawan tersisa: "+enemyTroopsRemain + " Orang");
				playerTroopsRemain = TroopsCavalry;
			}
			
			else if(TroopsCavalry < 0) {
				TroopsCavalry = 0;
				System.out.println("Pasukan Archer tersisa: "+TroopsArcher + " Orang");
				System.out.println("Pasukan Cavalry tersisa: "+TroopsCavalry + " Orang");
				System.out.println("Pasukan Infantry lawan tersisa: "+enemyTroopsRemain + " Orang");
				playerTroopsRemain = TroopsArcher;
			}
			else if(TroopsCavalry < 0 && TroopsArcher < 0) {
				TroopsCavalry = 0;
				TroopsArcher = 0;
				System.out.println("Pasukan Archer tersisa: "+TroopsArcher + " Orang");
				System.out.println("Pasukan Cavalry tersisa: "+TroopsCavalry + " Orang");
				System.out.println("Pasukan Infantry lawan tersisa: "+enemyTroopsRemain + " Orang");
				playerTroopsRemain = TroopsArcher + TroopsCavalry;
			}
		}
		
		if(playerTroopsRemain > enemyTroopsRemain){
			System.out.println("Selamat Anda Menang!");
		}
		else{
			System.out.println("Maaf Anda Kalah!");
		}
	}
	
	
	void showArmy() {
		System.out.println("No. | Hero Infantry | Hero Cavalry | Hero Archer| Troops Infantry | Troops Cavalry | Troops Archer|");
		//int i = 1;
		for (int i = 0; i < army.size(); i++) {
			System.out.printf("%d   |       %d       |       %d      |     %d      |        %d        |     %d     |     %d     |\n",i+1,
					army.get(i).getHeroInfantry(),army.get(i).getHeroCavalry(),
					army.get(i).getHeroArcher(), army.get(i).getTroopsInfantry(), army.get(i).getTroopsCavalry(), army.get(i).getTroopsArcher());
		}
	}
	
	public Main() {
		army.add(new Army(0,5,0,0,100000,0)); //5 Heroes Cavalry, 100k troops
		army.add(new Army(0,3,2,0,60000,40000));//3 heroes cavalry, 60k troops and 2 heroes Archer 40k troops
		army.add(new Army(0,2,3,0,40000,60000)); // 2 heroes cavalry, 40k troops and 3 heroes archer 60k troops
		army.add(new Army(0,1,4,0,20000,80000)); // 1 heroes cavalry, 20k troops and 4 heroes Archer 80k troops
		army.add(new Army(0,4,1,0,80000,20000)); // 4 heroes cavalry, 80k troops power 208000 and 1 heroes archer 20k troops 
		
		int choose;
		String name;
		System.out.print("Input nama anda: ");
		name = scan.nextLine();
		do {
			do {
				System.out.println("Perang Simulator");
				System.out.println("====================");
				System.out.println("Selamat Datang di Perang Simulator "+name);
				System.out.println("1. List Army yang bisa kamu rekrut");
				System.out.println("2. Mulai Permainan"); 
				System.out.println("3. Keluar");
				System.out.print("Pilih :");
				choose = scan.nextInt(); 
				scan.nextLine();
			} while (choose < 1 || choose > 3); 
			switch (choose) {
			case 1:
				showArmy();
				break;
			case 2:
				start();
				break;
			}
		} while (choose != 3);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
