package com.bicycledoctors.module.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bicycledoctors.common.base.BaseDao;
import com.bicycledoctors.common.base.BaseDto;

@Repository
public interface ShopDao extends BaseDao {
	
	public List<ShopDto> selectList(ShopDto dto);
	public List<BaseDto> selectOneList4Pic(ShopDto dto);

	public ShopDto selectOne4ShopLocation(ShopDto dto);
	public ShopDto selectOne4ShopService(ShopDto dto);
	public ShopDto selectOne4ShopProfile(ShopDto dto);
	public ShopDto selectOne4Hour(ShopDto dto);
	public ShopDto selectOne4Pic(ShopDto dto);
	
	public List<ShopAvailableServiceDto> selectShopServiceCd(ShopAvailableServiceDto dto);
	public List<ShopAvailableServiceDto> selectShopService(ShopAvailableServicesDto dtos);
	
	public List<ShopBikeBrandDto> selectShopBrandCd(ShopBikeBrandDto dto);
	public List<ShopBikeBrandDto> selectShopBrand(ShopBikeBrandsDto dtos);
	
	public List<ShopBikeBrandDto> selectShopWBrandCd(ShopWheelBrandDto dto);
	public List<ShopBikeBrandDto> selectShopWBrand(ShopWheelBrandsDto dtos);
	
	public int insert(ShopDto dto);
	public int insertAvailableServices(@Param("listAS") List<ShopAvailableServiceDto> listAS);
	public int insertHandlingBicycleBrands(@Param("listBB") List<ShopBikeBrandDto> listBB);
	public int insertHandlingWheelBrands(@Param("listWB") List<ShopWheelBrandDto> listBB);
	public int deleteByShopSeq(ShopDto dto);
	public int deleteSBByShopSeq(ShopDto dto);
	public int deleteWBByShopSeq(ShopDto dto);
	public int update(ShopDto dto);
	public int update1(ShopDto dto);
	public int update2(ShopDto dto);
	public int update3(ShopDto dto);
	public int update4(ShopDto dto);
}
