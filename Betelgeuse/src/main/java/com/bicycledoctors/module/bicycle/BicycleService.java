package com.bicycledoctors.module.bicycle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.bicycledoctors.common.base.BaseService;

@Service
public class BicycleService extends BaseService{
	
	@Autowired
	BicycleDao bicycleDao;
	
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;

	public List<BicycleDto> selectList(BicycleVo vo) {
		return bicycleDao.selectList(vo);
	}
	public List<BicycleDto> selectOneList(BicycleDto dto) {
		return bicycleDao.selectOneList(dto);
	}
	public BicycleDto selectOne(BicycleDto dto) {
		return bicycleDao.selectOne(dto);
	}
	
	public int selectOneCount(BicycleVo vo) {
		return bicycleDao.selectOneCount(vo);
	}
	public int insert(BicycleDto dto) throws Exception {
		bicycleDao.insert(dto);
		uploadFilesToS3(
    			dto.getUploadImg1()
    			, dto
    			, "filesUploaded"
    			, dto.getUploadImg1Type()
    			, dto.getUploadImg1MaxNumber()
    			, dto.getBikeSeq()
    			, bicycleDao
    			, amazonS3Client);
		return 1;
	}
	public int update(BicycleDto dto) {
		return bicycleDao.update(dto);
	}
	
}
