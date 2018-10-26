package hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticketed_revenue")
public class TicketedRevenue {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name = "CARRIERCODE", nullable = true)
	private String carrierCode;

	@Column(name = "CARRIERNAME", nullable = true)
	private String carrierName;

	@Column(name = "TABNAME", nullable = true)
	private String tabName;

	@Column(name = "AGENTGROUP", nullable = true)
	private String agentGroup;

	@Column(name = "AGENT", nullable = true)
	private String agent;

	@Column(name = "PLATEDCARRIER", nullable = true)
	private String platedCarrier;

	@Column(name = "TRANSACTIONCODE", nullable = true)
	private String transactionCode;
	
	@Column(name = "COMPONENT", nullable = true)
	private String component;
	
	@Column(name = "CATEGORY", nullable = true)
	private String category;
	
	@Column(name = "STATES", nullable = true)
	private String states;
	
	@Column(name = "MONTHRANGE", nullable = true)
	private String monthRange;
	
	
	@Column(name = "DOMINT", nullable = true)
	private String domInt;
	
	@Column(name = "PBNR", nullable = true)
	private String pBNR;
	
	@Column(name = "TAX", nullable = true)
	private String tax;
	
	@Column(name = "CABINNAME", nullable = true)
	private String cabinName;
	
	@Column(name = "FAREBASIS", nullable = true)
	private String fareBasis;
	
	@Column(name = "YEAR", nullable = true)
	private int year;
	
	@Column(name = "JANUARY", nullable = true)
	private BigDecimal january;
	
	@Column(name = "FEBRUARY", nullable = true)
	private BigDecimal february;
	
	@Column(name = "MARCH", nullable = true)
	private BigDecimal march;
	
	@Column(name = "APRIL", nullable = true)
	private BigDecimal april;
	
	@Column(name = "MAY", nullable = true)
	private BigDecimal may;
	
	@Column(name = "JUNE", nullable = true)
	private BigDecimal june;
	
	@Column(name = "JULY", nullable = true)
	private BigDecimal july;
	
	@Column(name = "AUGUST", nullable = true)
	private BigDecimal august;

	@Column(name = "SEPTEMBER", nullable = true)
	private BigDecimal september;

	@Column(name = "OCTOBER", nullable = true)
	private BigDecimal october;
	
	@Column(name = "NOVEMBER", nullable = true)
	private BigDecimal november;
	
	@Column(name = "DECEMBER", nullable = true)
	private BigDecimal december;
	
	@Column(name = "TOTAL", nullable = true)
	private BigDecimal total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getAgentGroup() {
		return agentGroup;
	}

	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getMonthRange() {
		return monthRange;
	}

	public void setMonthRange(String monthRange) {
		this.monthRange = monthRange;
	}

	public String getDomInt() {
		return domInt;
	}

	public void setDomInt(String domInt) {
		this.domInt = domInt;
	}

	public String getpBNR() {
		return pBNR;
	}

	public void setpBNR(String pBNR) {
		this.pBNR = pBNR;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getCabinName() {
		return cabinName;
	}

	public void setCabinName(String cabinName) {
		this.cabinName = cabinName;
	}

	public String getFareBasis() {
		return fareBasis;
	}

	public void setFareBasis(String fareBasis) {
		this.fareBasis = fareBasis;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getJanuary() {
		return january;
	}

	public void setJanuary(BigDecimal january) {
		this.january = january;
	}

	public BigDecimal getFebruary() {
		return february;
	}

	public void setFebruary(BigDecimal february) {
		this.february = february;
	}

	public BigDecimal getMarch() {
		return march;
	}

	public void setMarch(BigDecimal march) {
		this.march = march;
	}

	public BigDecimal getApril() {
		return april;
	}

	public void setApril(BigDecimal april) {
		this.april = april;
	}

	public BigDecimal getMay() {
		return may;
	}

	public void setMay(BigDecimal may) {
		this.may = may;
	}

	public BigDecimal getJune() {
		return june;
	}

	public void setJune(BigDecimal june) {
		this.june = june;
	}

	public BigDecimal getJuly() {
		return july;
	}

	public void setJuly(BigDecimal july) {
		this.july = july;
	}

	public BigDecimal getAugust() {
		return august;
	}

	public void setAugust(BigDecimal august) {
		this.august = august;
	}

	public BigDecimal getSeptember() {
		return september;
	}

	public void setSeptember(BigDecimal september) {
		this.september = september;
	}

	public BigDecimal getOctober() {
		return october;
	}

	public void setOctober(BigDecimal october) {
		this.october = october;
	}

	public BigDecimal getNovember() {
		return november;
	}

	public void setNovember(BigDecimal november) {
		this.november = november;
	}

	public BigDecimal getDecember() {
		return december;
	}

	public void setDecember(BigDecimal december) {
		this.december = december;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getPlatedCarrier() {
		return platedCarrier;
	}

	public void setPlatedCarrier(String platedCarrier) {
		this.platedCarrier = platedCarrier;
	}


}
