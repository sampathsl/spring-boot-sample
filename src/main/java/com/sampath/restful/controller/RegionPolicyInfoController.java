package com.sampath.restful.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampath.restful.model.RegionMapData;
import com.sampath.restful.model.RegionPolicyInfo;
import com.sampath.restful.service.RegionPolicyInfoService;
import com.sampath.restful.util.HeatMapColorCode;

/**
 * 
 * @author SAMPATH
 *
 */

@RestController
@RequestMapping("/region")
public class RegionPolicyInfoController {

	final static Logger logger = Logger.getLogger(RegionPolicyInfoController.class);

	@Autowired
	RegionPolicyInfoService regionPolicyInfoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RegionPolicyInfo> addRegion(@RequestBody RegionPolicyInfo regionPolicyInfo) {
		regionPolicyInfoService.save(regionPolicyInfo);
		logger.debug("Added:: " + regionPolicyInfo);
		return new ResponseEntity<RegionPolicyInfo>(regionPolicyInfo, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateRegion(@RequestBody RegionPolicyInfo regionPolicyInfo) {
		RegionPolicyInfo existingRegionPolicyInfo = regionPolicyInfoService.getById(regionPolicyInfo.getId());
		if (existingRegionPolicyInfo == null) {
			logger.debug("ExistingRegionPolicyInfo with id " + existingRegionPolicyInfo.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			regionPolicyInfoService.save(regionPolicyInfo);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RegionPolicyInfo> getRegion(@PathVariable("id") Long id) {
		RegionPolicyInfo regionPolicyInfo = regionPolicyInfoService.getById(id);
		if (regionPolicyInfo == null) {
			logger.debug("Region with id " + id + " does not exists");
			return new ResponseEntity<RegionPolicyInfo>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found RegionPolicyInfo :: " + regionPolicyInfo);
		return new ResponseEntity<RegionPolicyInfo>(regionPolicyInfo, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RegionPolicyInfo>> getAllRegions() {
		List<RegionPolicyInfo> regionPolicyInfos = regionPolicyInfoService.getAll();
		if (regionPolicyInfos.isEmpty()) {
			logger.debug("RegionPolicyInfos does not exists");
			return new ResponseEntity<List<RegionPolicyInfo>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + regionPolicyInfos.size() + " RegionPolicyInfos");
		logger.debug(Arrays.toString(regionPolicyInfos.toArray()));
		return new ResponseEntity<List<RegionPolicyInfo>>(regionPolicyInfos, HttpStatus.OK);
	}
	
	/**
	 "PR": {
		"id": 20,
		"regionCode": "PR",
		"totalCount": 211,
		"stCount": 150,
		"amtCount": 61,
		"urv": 65,
		"ukg": 24,
		"astrenska": 42,
		"cigna": 40,
		"erv": 12,
		"minPrice": 6,
		"maxPrice": 2218
		}
	 * @return
	 */
	@RequestMapping(value = "/custom1",method = RequestMethod.GET)
	public ResponseEntity<HashMap<String,RegionPolicyInfo>> getAllRegionsCustom1() {
		List<RegionPolicyInfo> regionPolicyInfos = regionPolicyInfoService.getAll();
		if (regionPolicyInfos.isEmpty()) {
			logger.debug("RegionPolicyInfos does not exists");
			return new ResponseEntity<HashMap<String,RegionPolicyInfo>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + regionPolicyInfos.size() + " RegionPolicyInfos");
		//return new ResponseEntity<List<RegionPolicyInfo>>(regionPolicyInfos, HttpStatus.OK);
		
		HashMap<String,RegionPolicyInfo> regionInfos = new HashMap<>();
		regionPolicyInfos.forEach(e -> regionInfos.put(e.getRegionCode(), e));
		
		return new ResponseEntity<HashMap<String,RegionPolicyInfo>>(regionInfos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/info",method = RequestMethod.GET)
	public ResponseEntity<TreeMap<String,RegionMapData>> getAllRegionsCustom2() {
		List<RegionPolicyInfo> regionPolicyInfos = regionPolicyInfoService.getAll();
		
		if (regionPolicyInfos.isEmpty()) {
			logger.debug("RegionPolicyInfos does not exists");
			return new ResponseEntity<TreeMap<String,RegionMapData>>(HttpStatus.NO_CONTENT);
		}
		
		logger.debug("Found " + regionPolicyInfos.size() + " RegionPolicyInfos");
		
		TreeMap<String,RegionMapData> regionInfos = new TreeMap<>();
		
		Long policyCount = 0L;
		for (Iterator iterator = regionPolicyInfos.iterator(); iterator.hasNext();) {
			RegionPolicyInfo regionPolicyInfo = (RegionPolicyInfo) iterator.next();
			policyCount += regionPolicyInfo.getTotalCount();
		}
		
		int count = 1;
		for (Iterator iterator = regionPolicyInfos.iterator(); iterator.hasNext();) {
			RegionPolicyInfo e = (RegionPolicyInfo) iterator.next();
			RegionMapData a = new RegionMapData(e.getId(), e.getRegionCode(), e.getRegionCode(),"","Single Trip Policy Count : "+e.getStCount()+"<br>Annual Trip Policy Count :"
					+ " "+e.getAmtCount()+"<br>Total Policy Count : "+e.getTotalCount()+"<br>URV	Policy Count : "+e.getUrv()+"<br>UKG	Policy Count : "+e.getUkg()+"<br>ASTRESKA	Policy Count : "+e.getAstrenska()+"<br>"
					+ "	CIGNA	Policy Count : "+e.getCigna()+"<br>	ERV	Policy Count : "+e.getErv()+"<br>Min Policy Price: £"+e.getMinPrice()+"<br>Max Policy Price: £"+e.getMaxPrice()+"","", HeatMapColorCode.getHeatMapColorCode(policyCount,e.getTotalCount()), "#bf92b4");
			regionInfos.put("st"+count, a);
			count++;
		}
		
		return new ResponseEntity<TreeMap<String,RegionMapData>>(regionInfos, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRegion(@PathVariable("id") Long id) {
		RegionPolicyInfo regionPolicyInfo = regionPolicyInfoService.getById(id);
		if (regionPolicyInfo == null) {
			logger.debug("Region with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			regionPolicyInfoService.delete(id);
			logger.debug("Region with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
