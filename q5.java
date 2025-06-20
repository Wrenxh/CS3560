package Assignment2;
import java.util.*;

public class q5{
	public static void main(String[] args) {
	}
}

// part a:
class Student{
	private String name;
	private Transcript ts;
	
	public Student(String iname, Transcript its) {
		this.name = iname;
		this.ts = its;
	}
}

class Transcript{
	private Student student;
	private String course;
	private double grade;
	
	public Transcript(String icourse, double igrade) {
		this.course = icourse;
		this.grade = igrade;
	}
}

// part b:
class course{
	private int code;
	private book book;
	public course()
	{
		this.code = 0;
	}
}

class book{
	private String name;
	private String author;
	private List<course> listCourses;
	public book() {
		this.name = "";
		this.author = "";
	}
}

//part c:

class team{
	int code;
	public team(int input) {
		this.code = input;
	}
	private List<player> roster;
	public void addPlayer(player tm) {
		roster.add(tm);
	}
}

class player{
	private String name;
	private boolean expert;
	
	public player(String n, boolean exp) {
		this.name = n;
		this.expert = exp;
	}
}

// part d:
class Dog{
	private String breed;
	private String name;
	private List<paw> paws;
	
	public Dog(String b, String n) {
		this.breed = b;
		this.name = n;
		this.paws = new ArrayList<paw>();
	}
}

class paw{
	private Dog doge;
	private int position;
	
	public paw(int pos, Dog doggy) {
		this.doge = doggy;
		this.position = pos;
	}
}

// part e:
class employee{
	private String name;
	private int hours;
	
	public employee(String n, int h) {
		this.name = n;
		this.hours = h;
	}
	
	public double calculateHhours() {
		return hours * 20.0;
	}
}

class professor extends employee{

	private String field;
	
	public professor(String n, int h, String f) {
		super(n, h);
		this.field = f;	
	}
	
	public double calculateSalary() {
		return hours * 30.0;
	}
	
}

class staff extends employee{

	private int role;
	
	public staff(String n, int h, int r) {
		super(n, h);
		this.role = r;	
	}
	
}

// part f:
interface salableItem{
	public abstract void getCopy();
}

class magazine implements salableItem{

	public magazine() {
		
	}
	public void getCopy() {
		System.out.println("Selling a Magazine!");
	}
	
}

class ticket implements salableItem{
	
	public ticket() {
		
	}
	public void getCopy() {
		System.out.println("Selling a Ticket!");
	}
	
}

// part g:
class person{
	private String name;
	private List<watch> listWatch;
	
	public person() {
		this.name = "";
	}
}

class movie{
	private String name;
	private String genre;
	private List<watch> listWatch;
	
	public movie() {
		this.name = "";
		this.genre = "";
	}
	
	public void addWatch(watch w) {
		if(listWatch == null) {
			listWatch = new ArrayList<watch>();
		}
		else {
			listWatch.add(w);
		}
	}
	
}

class watch{
	private movie mov;
	private person pers;
	private int rating;
	
	public watch(movie m, person p, int r) {
		this.mov = m;
		this.pers = p;
		this.rating = r;
	}
}

//for part h:
class worker{
	private String name;
	private double hourlyRate;
	
	public worker(String n, double ph) {
		this.name = n;
		this.hourlyRate = ph;
	}
	
	public String getName() {
		return name;
	}
}

class payroll{
	public payroll() {
		//nun here just get the method
	}
	
	public void processPayment(worker w) {
		System.out.println("Payment for " + w.getName() + " processed.");
	}
}
