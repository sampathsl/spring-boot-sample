package com.sampath.restful.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampath.restful.model.RegionPolicyInfo;
import com.sampath.restful.repository.RegionPolicyInfoRepository;

/**
 * 
 * @author SAMPATH
 *
 */
@Service
public class DefaultRegionPolicyInfoService implements RegionPolicyInfoService {

	@Autowired
	private RegionPolicyInfoRepository regionPolicyInfoRepository;

	@Override
	public RegionPolicyInfo save(RegionPolicyInfo entity) {
		return regionPolicyInfoRepository.save(entity);
	}

	@Override
	public RegionPolicyInfo getById(Serializable id) {
		return regionPolicyInfoRepository.findOne((Long) id);
	}

	@Override
	public List<RegionPolicyInfo> getAll() {
		return regionPolicyInfoRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		regionPolicyInfoRepository.delete((Long) id);
	}

}
