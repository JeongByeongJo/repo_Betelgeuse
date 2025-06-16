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
	public List<BicycleDto> selectOneList(BicycleVo vo) {
		return bicycleDao.selectOneList(vo);
	}
	public List<BicycleDto> selectList4Appoint(BicycleVo vo) {
		return bicycleDao.selectList4Appoint(vo);
	}
	public List<BicycleDto> selectOneList(BicycleDto dto) {
		return bicycleDao.selectOneList(dto);
	}
	public List<BicycleDto> selectOnePicList(BicycleDto dto) {
		return bicycleDao.selectOnePicList(dto);
	}
	public List<BicycleDto> selectList4Reservation(BicycleDto dto) {
		return bicycleDao.selectList4Reservation(dto);
	}
	public BicycleDto selectOne(BicycleDto dto) {
		return bicycleDao.selectOne(dto);
	}
	public BicycleDto selectOne(BicycleVo vo) {
		return bicycleDao.selectOne(vo);
	}
	
	public int selectOneCount(BicycleVo vo) {
		return bicycleDao.selectOneCount(vo);
	}
	public int insert(BicycleDto dto) throws Exception {
		bicycleDao.insert(dto);
		dto.setUploadImg1MaxNumber(1001);
		dto.setUploadImg1Type(1000);
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
	public int update(BicycleDto dto) throws Exception {
		bicycleDao.update(dto);
		bicycleDao.updatePic(dto);
		dto.setUploadImg1MaxNumber(1001);
		dto.setUploadImg1Type(1000);
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
	public int uelete(BicycleDto dto) {
		return bicycleDao.uelete(dto);
	}
	
	public Integer bicycleCount(String userCustomer_seq) {
		BicycleVo vo = new BicycleVo();
		vo.setUserCustomer_seq(userCustomer_seq);
		
		return bicycleDao.selectOneCount(vo);
	}
	public Integer bicycleRCount(String userCustomer_seq) {
		BicycleVo vo = new BicycleVo();
		vo.setUserCustomer_seq(userCustomer_seq);
		vo.setBikeStatus("121");
		Integer bikeStatus121 = bicycleDao.selectOneCount(vo);
		vo.setBikeStatus("122");
		Integer bikeStatus122 = bicycleDao.selectOneCount(vo);
		return bikeStatus121+bikeStatus122;
	}
	public Integer bicycleINRCount(String userCustomer_seq) {
		BicycleVo vo = new BicycleVo();
		vo.setUserCustomer_seq(userCustomer_seq);
		vo.setBikeStatus("122");
		Integer bikeStatus122 = bicycleDao.selectOneCount(vo);
		vo.setBikeStatus("123");
		Integer bikeStatus123 = bicycleDao.selectOneCount(vo);
		return bikeStatus122+bikeStatus123;
	}
}
