package company;





import java.util.Scanner;

public class Date{
	private int month;
	private int day;
	private int year;
	
	private final String ERR_MSG = "Fatal. Error.";

	public Date() {
		this.month = 1;
		this.day = 23;
		this.year = 2021;
		
	}
	
	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}


	
	public Date(int year) {
		setDate(1,1,year);
	}
	
	public Date(Date aDate) {
		if(aDate ==null)
			errorHandler(ERR_MSG);
		this.day = aDate.getday();
		this.year = aDate.getYear();
		this.month = aDate.getmonth();
		}
	
	public int getmonth() {
		return month;
	}

	

	
	public String toString() {
		return (month + " " + day + ", "+ year);
	}
	
	public void errorHandler(String msg) {
		if(msg != null && !msg.equalsIgnoreCase("")){
			System.err.println(msg);
			System.exit(-1);}
		}
	
	

	
	public void setDate(int monthInt, int day, int year) {
		if((dateOK(monthInt, day, year))) {
			this.month = monthInt;
			this.day =day;
			this.year =year;
		}else
			errorHandler(ERR_MSG);
	}
	

	public void setDate(int year) {
		setDate(1,1,year);
	}

	public void setYear(int year) {
		if((year < 1000) || (year > 9999))
			errorHandler(ERR_MSG);
		else
			this.year = year;
	}

	public void setMonth(int monthNumber) {
		if((monthNumber <= 0) || (monthNumber >12))
			errorHandler(ERR_MSG);
		else
			this.month = monthNumber;
	}

	public void setDay(int day) {
		if((day <= 0) || (day >31))
			errorHandler(ERR_MSG);
		else
			this.day = day;
	}

	public int getday() {
		return day;
	}

	public int getYear() {
		return year;
	}
	
	
	
	
		
		private boolean dateOK(int monthInt, int dayInt, int yearInt) {
			return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <31) && (yearInt >= 1000 && (yearInt <=9999)));
		}
		
		
		public boolean equals(Date otherDate) {
			return (month == otherDate.getmonth()
					&&day==otherDate.getday()
					&& year == otherDate.getYear());
		}
		

		public void readInput2() {
			boolean tryAgain = true;
			Scanner keyboard = new Scanner(System.in);
			while(tryAgain) {
				System.out.println("Enter month, day, and year.");
				System.out.println("Do not use a comma.");
				int monthInput = keyboard.nextInt();
				keyboard.nextLine();
				int dayInput = keyboard.nextInt();
				keyboard.nextLine();
				int yearInput = keyboard.nextInt();
				keyboard.nextLine();
				
				if((dateOK(monthInput, dayInput, yearInput))) {
					setDate(monthInput, dayInput, yearInput);
					tryAgain = false;
				}else
					System.err.println("Illegal date. reenter input.");
			}
			keyboard.close();
		}
		
		public  void readInput() {
			boolean tryAgain = true;
			Scanner keyboard = new Scanner(System.in);
			while(tryAgain) {
				System.out.println("Enter month, day, and year.");
				System.out.println("Do not use a comma.");
				int monthInput = keyboard.nextInt();
				keyboard.nextLine();
				int dayInput = keyboard.nextInt();
				keyboard.nextLine();
				int yearInput = keyboard.nextInt();
				keyboard.nextLine();
				if( dateOK(monthInput, dayInput, yearInput)) {
					setDate(monthInput, dayInput, yearInput);
					tryAgain = false;
				}else {
					System.out.println("Illegal date. reenter input.");
				}
			}
		}
		
		
		public String getDate() {
			return month+"/"+day+"/"+year;
		}


}

