package com.sampath.restful.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HeatMapColorCode {

	public static String getHeatMapColorCode(Long totalPolicyCount, Long policyRegionCount) {
		StringBuffer colorCode = new StringBuffer();
		BigDecimal policyPercentage = totalPolicyCount != null
				? totalPolicyCount != 0 ? new BigDecimal(policyRegionCount).divide(new BigDecimal(totalPolicyCount),2, RoundingMode.HALF_UP)  : BigDecimal.ZERO : BigDecimal.ZERO;
		if (policyPercentage.compareTo(new BigDecimal(0.001)) <= 0) {
			colorCode.append("#CCCCFF");
		} else if (policyPercentage.compareTo(new BigDecimal(0.002)) <= 0) {
			colorCode.append("#C4C3D0");
		} else if (policyPercentage.compareTo(new BigDecimal(0.003)) <= 0) {
			colorCode.append("#92A1CF");
		} else if (policyPercentage.compareTo(new BigDecimal(0.004)) <= 0) {
			colorCode.append("#8C92AC");
		} else if (policyPercentage.compareTo(new BigDecimal(0.005)) <= 0) {
			colorCode.append("#0000FF");
		} else if (policyPercentage.compareTo(new BigDecimal(0.01)) <= 0) {
			colorCode.append("#2A52BE");
		} else if (policyPercentage.compareTo(new BigDecimal(0.015)) <= 0) {
			colorCode.append("#002FA7");
		} else if (policyPercentage.compareTo(new BigDecimal(0.01)) <= 0) {
			colorCode.append("#003399");
		} else if (policyPercentage.compareTo(new BigDecimal(0.1)) <= 0) {
			colorCode.append("#00009C");
		} else if (policyPercentage.compareTo(new BigDecimal(0.15)) <= 0) {
			colorCode.append("#120A8F");
		} else if (policyPercentage.compareTo(new BigDecimal(0.2)) <= 0) {
			colorCode.append("#00008B");
		} else if (policyPercentage.compareTo(new BigDecimal(0.5)) <= 0) {
			colorCode.append("#000080");
		} else if (policyPercentage.compareTo(new BigDecimal(1)) <= 0) {
			colorCode.append("#191970");
		} else if (policyPercentage.compareTo(new BigDecimal(2)) <= 0) {
			colorCode.append("#082567");
		} else if (policyPercentage.compareTo(new BigDecimal(3)) <= 0) {
			colorCode.append("#002366");
		} else if (policyPercentage.compareTo(new BigDecimal(5)) <= 0) {
			colorCode.append("#002366");
		} else if (policyPercentage.compareTo(new BigDecimal(10)) <= 0) {
			colorCode.append("#002366");
		} else if (policyPercentage.compareTo(new BigDecimal(20)) <= 0) {
			colorCode.append("#002366");
		} else if (policyPercentage.compareTo(new BigDecimal(50)) <= 0) {
			colorCode.append("#002366");
		} else if (policyPercentage.compareTo(new BigDecimal(100)) <= 0) {
			colorCode.append("#002366");
		}
		return colorCode.toString();
	}

}
