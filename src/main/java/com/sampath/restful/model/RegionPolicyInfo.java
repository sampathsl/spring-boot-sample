package com.sampath.restful.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.mockito.internal.progress.IOngoingStubbing;

@Entity
@Table(name = "regionpolicyinfo")
public class RegionPolicyInfo implements Serializable {

	private static final long serialVersionUID = 4910225445550731446L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "regioncode", length = 50)
	private String regionCode;

	@Column(name = "totalcount", length = 50)
	private Long totalCount;

	@Column(name = "stcount", length = 50)
	private Long stCount;

	@Column(name = "amtcount", length = 50)
	private Long amtCount;

	@Column(name = "urv", length = 50)
	private Long urv;

	@Column(name = "ukg", length = 50)
	private Long ukg;

	@Column(name = "astrenska", length = 50)
	private Long astrenska;

	@Column(name = "cigna", length = 50)
	private Long cigna;

	@Column(name = "erv", length = 50)
	private Long erv;

	@Column(name = "minprice")
	private BigDecimal minPrice;

	@Column(name = "maxprice")
	private BigDecimal maxPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getStCount() {
		return stCount;
	}

	public void setStCount(Long stCount) {
		this.stCount = stCount;
	}

	public Long getAmtCount() {
		return amtCount;
	}

	public void setAmtCount(Long amtCount) {
		this.amtCount = amtCount;
	}

	public Long getUrv() {
		return urv;
	}

	public void setUrv(Long urv) {
		this.urv = urv;
	}

	public Long getUkg() {
		return ukg;
	}

	public void setUkg(Long ukg) {
		this.ukg = ukg;
	}

	public Long getAstrenska() {
		return astrenska;
	}

	public void setAstrenska(Long astrenska) {
		this.astrenska = astrenska;
	}

	public Long getCigna() {
		return cigna;
	}

	public void setCigna(Long cigna) {
		this.cigna = cigna;
	}

	public Long getErv() {
		return erv;
	}

	public void setErv(Long erv) {
		this.erv = erv;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "RegionPolicyCount [regionCode=" + regionCode + ", totalCount=" + totalCount + ", stCount=" + stCount
				+ ", amtCount=" + amtCount + ", urv=" + urv + ", ukg=" + ukg + ", astrenska=" + astrenska + ", cigna="
				+ cigna + ", erv=" + erv + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

}