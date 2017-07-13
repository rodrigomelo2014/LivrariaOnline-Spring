package br.com.caelum.fj27.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Price {

	@DecimalMin("0.5")
	@Column(scale = 2 )
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private BookType bookType;
	
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
	
}
