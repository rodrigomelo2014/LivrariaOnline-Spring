package br.com.caelum.fj27.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String title;
	
	@Lob
	@NotBlank
	private String description;
	
	@Min(1)
	private int numberOfPages;
	
//	@DateTimeFormat
//	private Calendar releaseDate;
//	
//	private String summaryPath;
	
	@Valid
	@ElementCollection(fetch=FetchType.EAGER)
	private List<Price> prices = new ArrayList<>();
	
	public BigDecimal priceFor(BookType bookType){
		return prices.stream()
				.filter(price -> price.getBookType().equals(bookType))
				.map(Price::getValue)
				.findFirst()
				.orElse(BigDecimal.ZERO);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public Calendar getReleaseDate() {
//		return releaseDate;
//	}
//	public void setReleaseDate(Calendar releaseDate) {
//		this.releaseDate = releaseDate;
//	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
//	public String getSummaryPath() {
//		return summaryPath;
//	}
//	public void setSummaryPath(String summaryPath) {
//		this.summaryPath = summaryPath;
//	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", description=" + description + ", numberOfPages=" + numberOfPages + "]";
	}
}
