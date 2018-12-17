package day20.silsub3;

import java.text.SimpleDateFormat;
import java.util.*;

public class Book implements java.io.Serializable{

	public static final long serialVersionUID = -3452151088506976381L;
	
	private String title;
	private String author;
	private int price;
	private Calendar dates;
	private double discountRate;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy'년' MM'월' dd'일'");
	
	
	public Book() {}

	public Book(String title, String author, int price,Calendar dates, double discountRate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return this.title + ", " + this.author + ", " + this.price + ", " + this.discountRate +", "+ sd.format(dates.getTime()) + "출간";
	}
}
