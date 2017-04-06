package com.sampath.restful.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampath.restful.model.RegionPolicyInfo;
import com.sampath.restful.service.RegionPolicyInfoService;

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
	public ResponseEntity<RegionPolicyInfo> addEmployee(@RequestBody RegionPolicyInfo regionPolicyInfo) {
		regionPolicyInfoService.save(regionPolicyInfo);
		logger.debug("Added:: " + regionPolicyInfo);
		return new ResponseEntity<RegionPolicyInfo>(regionPolicyInfo, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody RegionPolicyInfo regionPolicyInfo) {
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
	public ResponseEntity<RegionPolicyInfo> getEmployee(@PathVariable("id") Long id) {
		RegionPolicyInfo regionPolicyInfo = regionPolicyInfoService.getById(id);
		if (regionPolicyInfo == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<RegionPolicyInfo>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found RegionPolicyInfo :: " + regionPolicyInfo);
		return new ResponseEntity<RegionPolicyInfo>(regionPolicyInfo, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RegionPolicyInfo>> getAllEmployees() {
		List<RegionPolicyInfo> regionPolicyInfos = regionPolicyInfoService.getAll();
		if (regionPolicyInfos.isEmpty()) {
			logger.debug("RegionPolicyInfos does not exists");
			return new ResponseEntity<List<RegionPolicyInfo>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + regionPolicyInfos.size() + " RegionPolicyInfos");
		logger.debug(Arrays.toString(regionPolicyInfos.toArray()));
		return new ResponseEntity<List<RegionPolicyInfo>>(regionPolicyInfos, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		RegionPolicyInfo regionPolicyInfo = regionPolicyInfoService.getById(id);
		if (regionPolicyInfo == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			regionPolicyInfoService.delete(id);
			logger.debug("Employee with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
