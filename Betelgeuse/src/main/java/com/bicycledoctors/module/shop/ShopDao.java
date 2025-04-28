package com.bicycledoctors.module.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {

	public ShopDto selectOne4ShopLocation(ShopDto dto);
	public ShopDto selectOne4ShopService(ShopDto dto);
	
	public List<ShopAvailableServiceDto> selectShopServiceCd(ShopAvailableServiceDto dto);
	public List<ShopAvailableServiceDto> selectShopService(ShopAvailableServicesDto dtos);
	
	public List<ShopBikeBrandDto> selectShopBrandCd(ShopBikeBrandDto dto);
	public List<ShopBikeBrandDto> selectShopBrand(ShopBikeBrandsDto dtos);
	
	public int insert(ShopDto dto);
	public int insertAvailableServices(@Param("listAS") List<ShopAvailableServiceDto> listAS);
	public int insertHandlingBicycleBrands(@Param("listBB") List<ShopBikeBrandDto> listBB);
	public int deleteByShopSeq(ShopDto dto);
	public int deleteSBByShopSeq(ShopDto dto);
	public int update(ShopDto dto);
}
