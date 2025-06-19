package com.bicycledoctors.module.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.bicycledoctors.common.base.BaseDto;
import com.bicycledoctors.common.base.BaseService;
import com.bicycledoctors.module.member.MemberDao;

@Service
public class ShopService extends BaseService {

	@Autowired
	ShopDao dao;
	@Autowired
	MemberDao memberdao;
	
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	public List<ShopDto> select4Filter(List<ShopAvailableServiceDto> dtoList) {
		return dao.select4Filter(dtoList);
	}
	public List<ShopDto> select4ASFilter(ShopAvailableServicesDto dtos) {
		return dao.select4ASFilter(dtos);
	}
	public List<ShopDto> selectList(ShopVo vo) {
		return dao.selectList(vo);
	}
	public List<ShopDto> selectList4Favorite(ShopVo vo) {
		return dao.selectList4Favorite(vo);
	}
	public List<ShopDto> selectList(ShopDto dto) {
		return dao.selectList(dto);
	}
	public List<ShopDto> selectList4Marker(ShopVo vo) {
		return dao.selectList4Marker(vo);
	}
	public List<BaseDto> selectOneList4Pic(ShopDto dto) {
		return dao.selectOneList4Pic(dto);
	}
	
	
	public ShopDto selectOne(ShopVo vo) {
		return dao.selectOne(vo);
	}
	public ShopDto selectOne(ShopDto dto) {
		return dao.selectOne(dto);
	}
	public ShopDto selectOne4ShopLocation(ShopDto dto) {
		return dao.selectOne4ShopLocation(dto);
	}
	public ShopDto selectOne4ShopService(ShopDto dto) {
		return dao.selectOne4ShopService(dto);
	}
	public ShopDto selectOne4ShopProfile(ShopDto dto) {
		return dao.selectOne4ShopProfile(dto);
	}
	public ShopDto selectOne4Hour(ShopDto dto) {
		return dao.selectOne4Hour(dto);
	}
	public ShopDto selectOne4Pic(ShopDto dto) {
		return dao.selectOne4Pic(dto);
	}
	
	public List<ShopAvailableServiceDto> selectShopServiceCd(ShopAvailableServiceDto dto) {
		return dao.selectShopServiceCd(dto);
	}
	public List<ShopAvailableServiceDto> selectShopService(ShopVo vo) {
		return dao.selectShopService(vo);
	}
	
	public List<ShopBikeBrandDto> selectShopBrandCd(ShopBikeBrandDto dto) {
		return dao.selectShopBrandCd(dto);
	}
	public List<ShopBikeBrandDto> selectShopBrand(ShopBikeBrandsDto dtos) {
		return dao.selectShopBrand(dtos);
	}
	
	public List<ShopBikeBrandDto> selectShopWBrandCd(ShopWheelBrandDto dto) {
		return dao.selectShopWBrandCd(dto);
	}
	public List<ShopBikeBrandDto> selectShopWBrand(ShopWheelBrandsDto dtos) {
		return dao.selectShopWBrand(dtos);
	}
	
	public int selectOneCount(ShopVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public int insert(ShopDto dto) {
		dao.insert(dto);
		memberdao.updateShopSeq(dto);
		return 1;
	}

	public int insertAvailableServices(List<ShopAvailableServiceDto> listAS, ShopDto dto) {
		dao.deleteByShopSeq(dto);
		 if (listAS != null && !listAS.isEmpty()) {
			 dao.insertAvailableServices(listAS);
		 }
		return 1;
	}
	
	public int insertHandlingBicycleBrands(List<ShopBikeBrandDto> listBB, ShopDto dto) {
		dao.deleteSBByShopSeq(dto);
		if (listBB != null && !listBB.isEmpty()) {
			dao.insertHandlingBicycleBrands(listBB);
		}
		return 1;
	}
	public int insertHandlingWheelBrands(List<ShopWheelBrandDto> listWB, ShopDto dto) {
		dao.deleteWBByShopSeq(dto);
		if (listWB != null && !listWB.isEmpty()) {
			dao.insertHandlingWheelBrands(listWB);
		}
		return 1;
	}
	public void deleteAS(ShopDto dto) {
		dao.deleteByShopSeq(dto);
	}
	public void deleteBB(ShopDto dto) {
		dao.deleteSBByShopSeq(dto);
	}
	public void deleteWB(ShopDto dto) {
		dao.deleteWBByShopSeq(dto);
	}
	public int update(ShopDto dto) {
		return dao.update(dto);
	}
	public int update1(ShopDto dto) {
		return dao.update1(dto);
	}
	public int update3(ShopDto dto) {
		return dao.update3(dto);
	}
	public int update4(ShopDto dto) throws Exception {
		dao.update4(dto);
		dto.setUploadImg1Type(3000);
		dto.setUploadImg1MaxNumber(3001);
		uploadFilesToS3(
    			dto.getUploadImg1()
    			, dto
    			, "filesUploaded"
    			, dto.getUploadImg1Type()
    			, dto.getUploadImg1MaxNumber()
    			, dto.getShopSeq()
    			, dao
    			, amazonS3Client);
		return 1;
	}
	
	public int update2(ShopDto dto) throws Exception {
		dao.update2(dto);
		dto.setUploadImg1Type(2000);
		dto.setUploadImg1MaxNumber(2001);
		uploadFilesToS3(
    			dto.getUploadImg1()
    			, dto
    			, "filesUploaded"
    			, dto.getUploadImg1Type()
    			, dto.getUploadImg1MaxNumber()
    			, dto.getShopSeq()
    			, dao
    			, amazonS3Client);
		return 1;
	}
	
}
