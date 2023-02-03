package www.trainingnsj;

import java.util.Scanner; 

public class Input extends Entity{
	

		public void inputData() {
			String name;
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Welcome to North Sussex Judo Training!" + "\n");{
				String regex = "^[a-zA-Z]*$";
				while(true) {			
				System.out.print("Enter your name please: ");
				name = input.nextLine();
				    if (name.matches(regex)) {
				    	setName(name);
				    	break;
				    } else {
				    	System.out.println("Invalid name format. Please enter your name in the format of A-Z a-z only not even a symbols and numbers");
				    	System.out.println("Name must have minimum of 1 word  with A-Z character only!");
				    }
				    }



Boolean yn= true;
while(yn) {
				
				String elite = "Elite";
				String beginner = "Beginner";
				String intermediate = "Intermediate";
				

				System.out.println("Please select the training plan!");
				System.out.println("Beginner -- 2 sessions Per week -- $25.00");
				System.out.println("Intermediate -- 3 sessions Per week -- $30.00");
				System.out.println("Elite -- 5 sessions Per week -- $35.00");
				System.out.println("Please note above plans above are weekly fee");
				System.out.print("Enter training plan: ");
				setTrainingPlan(input.next());
				if(getTrainingPlan().equalsIgnoreCase(elite) || getTrainingPlan().equalsIgnoreCase(intermediate)) {
					while (yn) {
						System.out.println("Do you want to enroll competition for additional $22.00? (Y/N) ");
						decision = input.next().charAt(0);
							if(getDecision() == 'Y') {
								setNumsOfCompetition(1);
							yn = false;
							break;
							}else if (getDecision() == 'N') {
								setNumsOfCompetition(0);
								yn = false;
								break;
							}else {
								System.out.println("please enter again!");
							}
					}
				}else if (getTrainingPlan().equalsIgnoreCase(beginner)){
					setNumsOfCompetition(0);
					break;
				}else {
				
				}
				
					System.out.println("Please enter the existing plan only!");
				}


while(true) {
				
				System.out.println("________");
				System.out.println("|      Weight Category      |   Upper Weight Limit (Kg)  |");
				System.out.println("|---------------------------|----------------------------|");
				System.out.println("|Heavyweight                |Unlimeted (Over 100)        |");
				System.out.println("|Light-Heavyweight          |100                         |");
				System.out.println("|Middleweight               |90                          |");
				System.out.println("|Light-Middleweight         |81                          |");
				System.out.println("|Lightweight                |73                          |");
				System.out.println("|Flyweight                  |66                          |");
				System.out.println("|---------------------------|----------------------------|");
				int Heavyweight = 101;
				int LightHeavyweight =100;
				int MiddleWeight = 90;
				int LightMiddleWeight = 81;
				int LightWeight = 73;
				int Flyweight = 66;
				System.out.println("Enter your weight(in Kg): ");
				setCurrentWeight(input.nextInt());
				if (getCurrentWeight() > 100.00) {
					setWeightCategory("Heavyweight");
					setWeightCategotyDouble(Heavyweight);
					break;
				}else if (getCurrentWeight() > 90.00 && getCurrentWeight() < 101.00) {
					setWeightCategory("Light-Heavyweight");
					setWeightCategotyDouble(LightHeavyweight);
					break;
				}else if (getCurrentWeight() > 81.00 && getCurrentWeight() < 91.00) {
					setWeightCategory("MiddleWeight");
					setWeightCategotyDouble(MiddleWeight);
					break;
				}else if (getCurrentWeight() > 73.00 && getCurrentWeight() < 82.00) {
					setWeightCategory("Light-MiddleWeight");
					setWeightCategotyDouble(LightMiddleWeight);
					break;
				}else if (getCurrentWeight() > 66.00 && getCurrentWeight() < 74.00) {
					setWeightCategory("Light-Weight");
					setWeightCategotyDouble(LightWeight);
					break;
				}else if (getCurrentWeight() > 00.00 && getCurrentWeight() < 67.00) {
					setWeightCategory("FlyWeight");
					setWeightCategotyDouble(Flyweight);
					break;
				}else {
					System.out.println("Please sync the existing menu!");
				}
}
				
				System.out.println("Private Session -- $9.00 per hour -- Maximum 5 hours a week");
				boolean yn2 = true;
				while (yn2) {
					
					System.out.println("Do you want to enroll for private coaching? (Y/N)");
					setDecision1(input.next().charAt(0));
					if(getDecision1() == 'Y') {
						while(true) {
							System.out.println("How many hours would you like to enroll for private coaching weekly for a month? (5 Hours Max Weekly)");
							setNumsOfPrivateSession(input.nextInt());
							if(getNumsOfPrivateSession() > 5) {
								System.out.println("Cannot exceed maximum hours weekly! Please Try again!");
								System.out.println("Choose N instead of input 0 hours!");
							}else {
								break;
							}
						}break;
					}else if (getDecision1() == 'N') {
						setNumsOfPrivateSession(0);
						break;
					}else if (!(getDecision1() == 'Y' || getDecision1() == 'N')) {
						System.out.println("Please Try Again!");
					}
					
				}
					}
			}
			}
	public void CalculatePrice() {
	
			
			if(getTrainingPlan().equalsIgnoreCase(getElite())) {
				setPlanCost(35.00);
			}else if (getTrainingPlan().equalsIgnoreCase(getIntermediate())) {
				setPlanCost(30.00);
			}else {
				setPlanCost(25.00);
			}
			if(getNumsOfCompetition() == 1) {
				setCompCost(22.00);
			}else {
				setCompCost(0);		
			}
			if(getDecision1() == 'Y') {
				setPriCost(9.00 * getNumsOfPrivateSession() * 4);
			}else {
				setPriCost(0);
			}
			setTotalCost(getPlanCost() + getCompCost() + getPriCost());
		}
		
		public void OutPut() {
			System.out.println("Hello " +getName()+"!");
			System.out.println("There are the itemised cost for your monthly training:");
			System.out.println("Training Plan Cost: $"+getPlanCost());
			System.out.println("Competition Cost: $"+getCompCost());
			System.out.println("Private Coaching Cost for a month: $"+getPriCost());
			System.out.println("The total cost of training for the month: $"+getTotalCost());
			if(getWeightCategotyDouble() != getCurrentWeight()) {
				double weightComparison = (getWeightCategotyDouble() -getCurrentWeight());
				System.out.println("You need to gain "+weightComparison+"Kg to be eligible for the "+getWeightCategory()+" Competition!");
			}else if (getWeightCategotyDouble() == getCurrentWeight()) {
				double weightComparasion = 0;
				System.out.println("You are eligible for the "+getWeightCategory()+"Competition because you have "+weightComparasion+"weight gap!");
			}
		}
  		}
//		public void Calc() {
//			if(getTrainingPlan().equalsIgnoreCase(getElite())) {
//				setPlanCost(35.00);
//			}else if (getTrainingPlan().equalsIgnoreCase(getIntermediate())) {
//				setPlanCost(30.00);
//			}else {
//				setPlanCost(25.00);
//			}
//			if(getNumsOfCompetition() == 1) {
//				setCompCost(22.00);
//			}else {
//				setCompCost(0);		
//			}
//			if(getDecision1() == 'Y') {
//				setPriCost(9.00 * getNumsOfPrivateSession() * 4);
//			}else {
//				setPriCost(0);
//			}
//			setTotalCost(getPlanCost() + getCompCost() + getPriCost());
//		
//		}
//		public void OutPut() {
//			System.out.println("Hello " +getName()+"!");
//			System.out.println("There are the itemised cost for your monthly training:");
//			System.out.println("Training Plan Cost: $"+getPlanCost());
//			System.out.println("Competition Cost: $"+getCompCost());
//			System.out.println("Private Coaching Cost for a month: $"+getPriCost());
//			System.out.println("The total cost of training for the month: $"+getTotalCost());
//			if(getWeightCategotyDouble() != getCurrentWeight()) {
//				double weightComparison = (getWeightCategotyDouble() -getCurrentWeight());
//				System.out.println("You need to gain "+weightComparison+"Kg to be eligible for the "+getWeightCategory()+" Competition!");
//			}else if (getWeightCategotyDouble() == getCurrentWeight()) {
//				double weightComparasion = 0;
//				System.out.println("You are eligible for the "+getWeightCategory()+"Competition because you have "+weightComparasion+"weight gap!");
//			}
//		}
//		


		
//	public void CalculatePrice() {
//	
//			
//			if(getTrainingPlan().equalsIgnoreCase(getElite())) {
//				setPlanCost(35.00);
//			}else if (getTrainingPlan().equalsIgnoreCase(getIntermediate())) {
//				setPlanCost(30.00);
//			}else {
//				setPlanCost(25.00);
//			}
//			if(getNumsOfCompetition() == 1) {
//				setCompCost(22.00);
//			}else {
//				setCompCost(0);		
//			}
//			if(getDecision1() == 'Y') {
//				setPriCost(9.00 * getNumsOfPrivateSession() * 4);
//			}else {
//				setPriCost(0);
//			}
//			setTotalCost(getPlanCost() + getCompCost() + getPriCost());
//		}
//		
//		public void OutPut() {
//			System.out.println("Hello " +getName()+"!");
//			System.out.println("There are the itemised cost for your monthly training:");
//			System.out.println("Training Plan Cost: $"+getPlanCost());
//			System.out.println("Competition Cost: $"+getCompCost());
//			System.out.println("Private Coaching Cost for a month: $"+getPriCost());
//			System.out.println("The total cost of training for the month: $"+getTotalCost());
//			if(getWeightCategotyDouble() != getCurrentWeight()) {
//				double weightComparison = (getWeightCategotyDouble() -getCurrentWeight());
//				System.out.println("You need to gain "+weightComparison+"Kg to be eligible for the "+getWeightCategory()+" Competition!");
//			}else if (getWeightCategotyDouble() == getCurrentWeight()) {
//				double weightComparasion = 0;
//				System.out.println("You are eligible for the "+getWeightCategory()+"Competition because you have "+weightComparasion+"weight gap!");
//			}
//		}
//}
//import java.util.Scanner;
//
//class InputUser extends Entity {
//	public static void main(String[] args) {
//		InputUser userInput = new InputUser();
//        userInput.inputData();
//	}
//		 public void inputData() {
//			 String name;
//			 //String trainingPlan;
//			 //Entity athlete = new Entity();
//		     Scanner sc = new Scanner(System.in);
//
//		      
//		     String regex = "^[a-zA-Z]*$";
//		        System.out.println("Welcome to North Sussex Judo Training"
//						+ "\n");{
//				while(true) {			
//				System.out.print("Enter athlete name: ");
//		        name = sc.nextLine();
//				    if (name.matches(regex)) {
//				    	setName(name);
//				    	break;
//				    } else {
//				    	System.out.println("Invalid name format. Please enter your name in the format of FirstName LastName' with first latter of the name uppercase");
//				    	
//				    }
//				    }
//
//		        System.out.print("Enter training plan: ");
//		        setTrainingPlan(sc.nextLine());
//	//		    char decision;
//			    
//			    while (true) {
//			    	String beginner = "Beginner";
//			    	String intermediate = "Intermediate";
//			    	String elite = "Elite";
//			    	System.out.println("Please select the training plan!");
//			    	System.out.println("Beginner - 2 sessions Per week - $25.00");
//			    	System.out.println("Intermediate - 3 sessions Per week - $30.00");
//			    	System.out.println("Elite - 5 sessions Per week - $35.00");
//			    	System.out.println("Please note above plans above are weekly fee");
//			    	setTrainingPlan(sc.next());
//			    	if(getTrainingPlan().equalsIgnoreCase(elite) || getTrainingPlan().equalsIgnoreCase(intermediate)) {
//			    		
//			    	}else if (getTrainingPlan().equalsIgnoreCase(beginner)){
//			    		break;
//			    	}else {
//			    		System.out.println("Please enter the existing plan only!");
//			    	}
//
//		        System.out.print("Enter current weight in kg: ");
//	//	        setCurrentWeight(validateWeight(sc.nextLine()));
//		        System.out.println("Weight category:");
//		    	System.out.println("Heavyweight -- over 100Kg");
//		    	System.out.println("Light-Heavyweight -- 100Kg");
//		    	System.out.println("MiddleWeight -- 90Kg");
//		    	System.out.println("Ight-Middleweight -- 81Kg");
//		    	System.out.println("Light-Weight -- 73Kg");
//		    	System.out.println("Flyweight -- 66Kg");
//		    	System.out.println("Enter your weight(in Kg): ");
////		    	Scanner input1;
////		    	setCurrentWeight(sc.nextInt());
////		    	if (getCurrentWeight() > 100.00) {
////		    		setWeightCategory("Heavyweight");
////		    		break;
////		    	}else if (getCurrentWeight() > 90.00 && getCurrentWeight() < 100.00) {
////		    		setWeightCategory("Light-Heavyweight");
////		    		break;
////		    	}else if (getCurrentWeight() > 81.00 && getCurrentWeight() < 90.00) {
////		    		setWeightCategory("MiddleWeight");
////		    		break;
////		    	}else if (getCurrentWeight() > 73.00 && getCurrentWeight() < 81.00) {
////		    		setWeightCategory("Light-Weight");
////		    		break;
////		    	}else if (getCurrentWeight() > 66.00 && getCurrentWeight() < 73.00) {
////		    		setWeightCategory("Flyweight");
////		    		break;
////		    	}else {
////		    		setWeightCategory("Underweight");
////		    		break;
////		    	}
//
//		        System.out.print("Enter competition weight category: ");
//		        setCompetitionWeightCategory(sc.nextLine());
//
//		        System.out.print("Enter number of competitions entered this month: ");
//		        setCompetitionsEntered(validateNumber(sc.nextLine()));
//
//		        System.out.print("Enter number of hours private coaching: ");
//		        setPrivateCoachingCost(validateNumber(sc.nextLine()));
//			    }
//						}
//						}
//		 
//		    private double validateWeight(String weight) {
//		        double weightVal = 0;
//		        try {
//		            weightVal = Double.parseDouble(weight);
//		        } catch (NumberFormatException e) {
//		            System.out.println("Invalid weight, please enter a valid number");
//		            Scanner scanner = new Scanner(System.in);
//		            weightVal = validateWeight(scanner.nextLine());
//		        }
//		        return weightVal;
//		    }
//
//		    private int validateNumber(String number) {
//		        int numberVal = 0;
//		        try {
//		            numberVal = Integer.parseInt(number);
//		        } catch (NumberFormatException e) {
//		            System.out.println("Invalid number, please enter a valid number");
//		            Scanner scanner = new Scanner(System.in);
//		            numberVal = validateNumber(scanner.nextLine());
//		        }
//		        return numberVal;
//		    }
//}
//
//	
//   
	

//class InputUser  extends Entity {
//
//	
//	
//public void main(String[] args) {
////	String name;
//
//	Scanner scanner = new Scanner(System.in); 
//  {
//	//	String r = "([A-Z][a-z]+)(\\s[A-Z)[a-z]+)";
//  	System.out.println("Welcome to North Sussex Judo Training"
//				+ "\n");{
//		// Ask the user to enter the details for each athlete 
//		Entity athlete = new Entity();
//
//		  //  while(true) {
////		    System.out.print("Enter the name of the athlete: ");
//	//	Scanner s;
//			//    setAthleteName(input.nextLine());
//		    name = scanner.nextLine();
//		    if (name.matches(r)) {
//		    	setName(name);
//		    	break;
//		    } else {
//		    	System.out.println("Invalid name format. Please enter your name in the format of FirstName LastName' with first latter of the name uppercase");
//		    	
//		    }
		 //   }
//		    if(getAthleteName().matches(regex)) {
//		    	break;
//		    }else {
//		    	System.out.println("Please enter the correct name!");
//		    	System.out.println("Name must have of 1 word with A-Z or a-z character only!");
//		    }
	   
//	    System.out.print("Enter the training plan: ");
//		    athlete.setTrainingPlan(input.nextLine());
//		    char decision;
		    
//		    while (true) {
//		    	String beginner = "Beginner";
//		    	String intermediate = "Intermediate";
//		    	String elite = "Elite";
//		    	System.out.println("Please select the training plan!");
//		    	System.out.println("Beginner - 2 sessions Per week - $25.00");
//		    	System.out.println("Intermediate - 3 sessions Per week - $30.00");
//		    	System.out.println("Elite - 5 sessions Per week - $35.00");
//		    	System.out.println("Please note above plans above are weekly fee");
//		    	setPlan(in.next());
//		    	if(getPlan().equalsIgnoreCase(elite) || getPlan().equalsIgnoreCase(intermediate)) {
//		    		
//		    	}else if (getPlan().equalsIgnoreCase(beginner)){
//		    		break;
//		    	}else {
//		    		System.out.println("Please enter the existing plan only!");
//		    	}
//		   
//		    System.out.print("Enter the current weight in kilograms: ");
//		    setCurrentWeight(s.nextDouble());
//		    
//		    System.out.print("Enter the competition weight category: ");
//		    s.nextLine();
//		    setCompetitionWeightCategory(s.nextLine());
//		    
//		    System.out.print("Enter the number of competitions entered this month: ");
//		    setCompetitionsEntered(s.nextInt());
//		    
//		    System.out.print("Enter the number of hours of private coaching: ");
//		    setPrivateCoachingCost(s.nextDouble()*100); //
//		    
//		}
//	}
//}
//}
//
//private static void setPlan(String next) {
//	 TODO Auto-generated method stub
//	
//}
//
//private static String getPlan() {
//	// TODO Auto-generated method stub
//	return null;

				


//	//public static void main(String[] args) {
//    public InputUser() {
//	Scanner sc  = new Scanner(System.in);
//	 while (true) {
//		Scanner input = null;
//		String name;
//	    String r = "([A-Z][a-z]+)(\\s[A-Z)[a-z]+)";
//		System.out.println("Enter your Name: ");
//		
//		setName(input.nextLine());
//		
//		if(getName().matches(r)) {
//			break;
//		}else {
//			System.out.println("Please enter the correct name!");
//			
//   		System.out.println("Name must have minimum of 1 word with A-Z character only!"); {
//	
//			}
//			
//	
//	}
//		char decision;
//		boolean yn = true; {
//		
//		while (yn) {
//			String beginner ="Beginner";
//			String intermediate = "Intermediate";
//			String elite = "Elite";
//			System.out.println("Please select the desired training plan!");
//			System.out.println("Beginner -- 2 sessions per week -- $25.00");
//			System.out.println("Intermediate -- 3 sessions per week -- $30.00");
//			System.out.println("Elite -- 5 sessions per week -- $35.00");
//			System.out.println("Please note plans above are weekly fee!");
//			setTrainigPlan(input.next());
//			if(getTrainingPlan().equalsIgnoreCase(elite) ||getTrainingPlan().equalsIgnoreCase(intermediate)) {
//				while(true) {
//				System.out.println("Do you want to enroll competition for additional $22.00? (Y/N) ");
//				decision = input.next().charAt(0);
//					if(decision == 'Y') {
//					yn = false;
//					break;
//					}else if (decision == 'N') {
//						yn = false;
//						break;
//					}else {
//						System.out.println("Please enter again!");
//					}
//					
//				}
//		}else if (getTrainingPlan().equalsIgnoreCase(beginner)) {
//			break;
//		}else {
//			System.out.println("Please enter the existing plan only!");
//		}
//	}
//		
//	while(true) {
//			
//	System.out.println("Weight category:");
//	System.out.println("Heavyweight -- over 100Kg");
//	System.out.println("Light-Heavyweight -- 100Kg");
//	System.out.println("MiddleWeight -- 90Kg");
//	System.out.println("Ight-Middleweight -- 81Kg");
//	System.out.println("Light-Weight -- 73Kg");
//	System.out.println("Flyweight -- 66Kg");
//	System.out.println("Enter your weight(in Kg): ");
//	Scanner input1;
//	setCurrentweight(input.nextInt());
//	if (getCurrentweight() > 100.00) {
//		setWeightCategory("Heavyweight");
//		break;
//	}else if (getCurrentweight() > 90.00 && getCurrentweight() < 100.00) {
//		setWeightCategory("Light-Heavyweight");
//		break;
//	}else if (getCurrentweight() > 81.00 && getCurrentweight() < 90.00) {
//		setWeightCategory("MiddleWeight");
//		break;
//	}else if (getCurrentweight() > 73.00 && getCurrentweight() < 81.00) {
//		setWeightCategory("Light-Weight");
//		break;
//	}else if (getCurrentweight() > 66.00 && getCurrentweight() < 73.00) {
//		setWeightCategory("Flyweight");
//		break;
//	}else {
//		setWeightCategory("Underweight");
//		break;
//	}
//}
//	
//	System.out.println("Do you want to ");
//	input.close();
//	
//
//		}
//	 }
//
//	}
//}

//
//import java.util.Scanner;
//
//
//public class InputUser  extends Entity {
//    public static void main(String[] args) {
//    	String name = new String();
//    	
//
//    	
//    	
//    	
//    	//String regex = "^[A-Z][][a-zA-Z]*([A-Z][][a-zA-Z]*)*$";
//        //try (// Create a scanner object to read input from the user
//		Scanner in = new Scanner(System.in);//) 
//        {
//			String r = "([A-Z][a-z]+)(\\s[A-Z)[a-z]+)";
//        	System.out.println("Welcome to North Sussex Judo Training"
//					+ "\n");{
//			// Ask the user to enter the details for each athlete 
//			Entity athlete = new Entity();
//   
//			    while(true) {
//			    System.out.print("Enter the name of the athlete: ");
//			//    setAthleteName(input.nextLine());
//			    name = in.nextLine();
//			    if (name.matches(r)) {
//			    	setName(name);
//			    	break;
//			    } else {
//			    	System.out.println("Invalid name format. Please enter your name in the format of FirstName LastName' with first latter of the name uppercase");
//			    	
//			    }
//			    }
////			    if(getAthleteName().matches(regex)) {
////			    	break;
////			    }else {
////			    	System.out.println("Please enter the correct name!");
////			    	System.out.println("Name must have of 1 word with A-Z or a-z character only!");
////			    }
//		   
////		    System.out.print("Enter the training plan: ");
////			    athlete.setTrainingPlan(input.nextLine());
//	//		    char decision;
//			    
//			    while (true) {
//			    	String beginner = "Beginner";
//			    	String intermediate = "Intermediate";
//			    	String elite = "Elite";
//			    	System.out.println("Please select the training plan!");
//			    	System.out.println("Beginner - 2 sessions Per week - $25.00");
//			    	System.out.println("Intermediate - 3 sessions Per week - $30.00");
//			    	System.out.println("Elite - 5 sessions Per week - $35.00");
//			    	System.out.println("Please note above plans above are weekly fee");
//			    	setPlan(in.next());
//			    	if(getPlan().equalsIgnoreCase(elite) || getPlan().equalsIgnoreCase(intermediate)) {
//			    		
//			    	}else if (getPlan().equalsIgnoreCase(beginner)){
//			    		break;
//			    	}else {
//			    		System.out.println("Please enter the existing plan only!");
//			    	}
//			   
//			    System.out.print("Enter the current weight in kilograms: ");
//			    setCurrentWeight(in.nextDouble());
//			    
//			    System.out.print("Enter the competition weight category: ");
//			    nextLine();
//			    setCompetitionWeightCategory(in.nextLine());
//			    
//			    System.out.print("Enter the number of competitions entered this month: ");
//			    setCompetitionsEntered(in.nextInt());
//			    
//			    System.out.print("Enter the number of hours of private coaching: ");
//			    setPrivateCoachingCost(in.nextDouble()*100); //
//			    
//			}
//		}
//    }
//}
//
//	private static void setPlan(String next) {
		// TODO Auto-generated method stub
//		
//	}
//
//	private static String getPlan() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//            
            


/*class InputUser extends Entity {
	
    private Scanner sc;

    public InputUser() {
        sc = new Scanner(System.in);
    }
    
    

    public void takeInput() 
    {
        System.out.print("Enter Athlete name: ");
        setAthleteName(sc.nextLine());

        System.out.print("Enter training plan: ");
        setTrainingPlan(sc.nextLine());

        boolean isValidWeight = false;
        while (!isValidWeight) {
            System.out.print("Enter current weight in kilograms: ");
            double weight = sc.nextDouble();
            if (weight > 0) {
                setCurrentWeight(weight);
                isValidWeight = true;
            } else {
                System.out.println("Invalid weight, please enter a positive number.");
            }
        }

        System.out.print("Enter competition weight category: ");
        setCompetitionWeightCategory(sc.nextLine());

        boolean isValidNumberOfCompetitions = false;
        while (!isValidNumberOfCompetitions) {
            System.out.print("Enter number of competitions entered this month: ");
            int numberOfCompetitions = sc.nextInt();
            if (numberOfCompetitions >= 0) {
            	setNumberOfCompetitionsEntered(numberOfCompetitions);
                isValidNumberOfCompetitions = true;
            } else {
                System.out.println("Invalid number of competitions, please enter a non-negative number.");
            }
        }

        boolean isValidNumberOfPrivateCoachingHours = false;
        while (!isValidNumberOfPrivateCoachingHours) {
            System.out.print("Enter number of hours of private coaching: ");
            int numberOfPrivateCoachingHours = sc.nextInt();
            if (numberOfPrivateCoachingHours >= 0) {
            	setNumberOfHoursPrivateCoaching(numberOfPrivateCoachingHours);
                isValidNumberOfPrivateCoachingHours = true;
            } else {
                System.out.println("Invalid number of private coaching hours, please enter a non-negative number.");
            }
        }
    }
/*import java.util.Scanner;

class InputUser extends Entity {
	
	public void main(String[] args) {
    
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Athlete Name:");
			String name = scanner.nextLine();
			setAthleteName(name);
			
			System.out.println("Enter Training Plan:");
			String trainingPlan = scanner.nextLine();
			setTrainingPlan(trainingPlan);
			
			System.out.println("Enter Current Weight:");
			double currentWeight = scanner.nextDouble();
			setCurrentWeight(currentWeight);
			
			scanner.nextLine();
			System.out.println("Enter Competition Weight Category:");
			String competitionWeightCategory = scanner.nextLine();
			setCompetitionWeightCategory(competitionWeightCategory);
			
			System.out.println("Enter Number of Competitions:");
			int numCompetitions = scanner.nextInt();
			setNumberOfCompetitionsEntered(numCompetitions);
			
			System.out.println("Enter Number of Private Coaching:");
			int numPrivateCoaching = scanner.nextInt();
			setNumberOfHoursPrivateCoaching(numPrivateCoaching);
		}
    
}
}*/


    
    
