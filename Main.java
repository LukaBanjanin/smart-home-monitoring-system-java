//SHMS main driver class
import java.io.IOException;  
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

public static void main(String[] args) throws IOException
{
	int selection = 0;//for user to interact with menu
	Appliance [] applianceArray = new Appliance[13];//array that stores all of the appliance objects
	
	do{
		System.out.println("Welcome to the Smart Home Monitoring System\n"//initial menu
				+ "Please Select from the following menu of appliances to add: (press 0 followed by ENTER to exit the program, press 13 followed by ENTER to continue once you've finished adding all of your appliances\n\n"
				+ "1) Lightbulb\n"
				+ "2) Washing Machine\n"
				+ "3) Dryer\n"
				+ "4) Microwave\n"
				+ "5) Oven/Stove\n"
				+ "6) Furnace\n"
				+ "7) AC unit\n"
				+ "8) Dish Washer\n"
				+ "9) Fan\n"
				+ "10) Coffee Machine\n"
				+ "11) TV\n"
				+ "12) Laptop\n");
		
		Scanner in = new Scanner(System.in);
		selection = in.nextInt();//scan in user selection
		
		switch (selection)//depending on user selection, case switch proceeds accordingly
		{
		case 1 :
			System.out.println("\n We have added a Lightbulb to your list of appliances\n");
			Appliance lightBulb = new Appliance(1);
			applianceArray[1] = lightBulb;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2 :
			System.out.println("\n We have added a Washing Machine to your list of appliances\n");
			Appliance washingMachine = new Appliance(2);
			applianceArray[2] = washingMachine;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 3 :
			System.out.println("\n We have added a Dryer to your list of appliances\n");
			Appliance dryer = new Appliance(3);
			applianceArray[3] = dryer;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 4 :
			System.out.println("\n We have added a Microwave to your list of appliances\n");
			Appliance microwave = new Appliance(4);
			applianceArray[4] = microwave;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 5 :
			System.out.println("\n We have added a Oven/Stove to your list of appliances\n");
			Appliance oven = new Appliance(5);
			applianceArray[5] = oven;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 6 :
			System.out.println("\n We have added a Furnace to your list of appliances\n");
			Appliance furnace = new Appliance(6);
			applianceArray[6] = furnace;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 7 :
			System.out.println("\n We have added a AC unit to your list of appliances\n");
			Appliance ac = new Appliance(7);
			applianceArray[7] = ac;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 8 :
			System.out.println("\n We have added a Dish Washer to your list of appliances\n");
			Appliance dishWasher = new Appliance(8);
			applianceArray[8] = dishWasher;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 9 :
			System.out.println("\n We have added a Fan to your list of appliances\n");
			Appliance fan = new Appliance(9);
			applianceArray[9] = fan;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 10 :
			System.out.println("\n We have added a Coffee Machine to your list of appliances\n");
			Appliance coffeeMachine = new Appliance(10);
			applianceArray[10] = coffeeMachine;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 11 :
			System.out.println("\n We have added a TV to your list of appliances\n");
			Appliance tv = new Appliance(11);
			applianceArray[11] = tv;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 12 :
			System.out.println("\n We have added a Laptop to your list of appliances\n");
			Appliance laptop = new Appliance(12);
			applianceArray[12] = laptop;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		
		}
		
		
	}while (selection != 0 && selection != 13);//exit the loop if user selects 0 to close program or 13 to continue
	
	if (selection == 0) {
		System.out.println("Exiting the program now...\n");
		return;//exit program is user selects 0
	}
	
	System.out.println("\n These are our ideal daily use times for your appliances...\n");
		
		for (int i = 0; i < 13; i++) {//loop through appliances user added and display the default settings
	
		if (applianceArray[i] == null) continue;
		Appliance tmp = applianceArray[i];
		System.out.println("Applaince: " + tmp.getName() + "\n" + "Start Time: " + tmp.startUse + "\n" + "End Time: " + tmp.endUse + "\n");
	}
	
		int cost = 0;
		
	for (int i = 0; i < 13; i++) {//loop through appliances user selected and calculate a total cost projection for the month assuming this use schedule is followed
		if (applianceArray[i] == null) continue;
		Appliance tmp1 = applianceArray[i];
		cost += tmp1.calculateCost();
	}
	
	System.out.println("If these times are followed, your monthly cost to run these appliances would be: $" + cost/100 + "\n\n" + "To edit these times press 1 followed by ENTER, if you are happy with these times press 0 followed by ENTER to exit the program \n");
	Scanner in = new Scanner(System.in);
	selection = in.nextInt();

if (selection == 0) return;//exit if user selects 0

do {
	for (int i = 0; i < 13; i++) {//loop through all appliances in the array and print for user to select which they wish to change
		
		if (applianceArray[i] == null) continue;
		Appliance tmp2 = applianceArray[i];
		System.out.println("\n Press " + tmp2.getType() + " to edit the usetimes of your " + tmp2.getName() + "\n");
	}
	System.out.println("Press 0 to exit\n");
	selection = in.nextInt();
	if (selection == 0) break;//if user selects 0, break the loop
	Appliance tmp3 = applianceArray[selection];
	System.out.println("\n Enter your new start use hour (24 hour time) for your " + tmp3.getName() + "\n");
	double hr = 0;
	hr = in.nextInt();//read in starting hour from user
	System.out.println("\n Enter your new start use minutes for your " + tmp3.getName() + "\n");
	double minute = 0;
	minute = in.nextInt();//read in starting minute from user
	hr = hr + (minute/60);//combine minute and hour times 
	tmp3.setStartUse(hr);//set start time of the appliance they selected to whatever they specified
	System.out.println("\n Enter your new end use hour (24 hour time) for your " + tmp3.getName() + "\n");
	hr = in.nextInt();//read in ending hour from user
	System.out.println("\n Enter your new end use minutes for your " + tmp3.getName() + "\n");
	minute = in.nextInt();//read in ending minute from user
	hr = hr + (minute/60);//combine minute and hour times
	tmp3.setEndUse(hr);//set appliance end time to whatever they specified
	
}while (selection != 0);

cost = 0;
for (int i = 0; i < 13; i++) {//recalculate monthly cost projection once the user has made all of their desired changes
	if (applianceArray[i] == null) continue;
	Appliance tmp4 = applianceArray[i];
	cost += tmp4.calculateCost();
}

System.out.println("\n If these times are followed, your monthly cost to run these appliances would be: $" + cost/100 + "\n" + "Exiting the program now...\n");

return;

}
}

