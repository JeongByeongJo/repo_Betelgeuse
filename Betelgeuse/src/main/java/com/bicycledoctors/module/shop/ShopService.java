package com.bicycledoctors.module.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

	@Autowired
	ShopDao dao;
	
	public ShopDto selectOne4ShopLocation(ShopDto dto) {
		return dao.selectOne4ShopLocation(dto);
	}
	public ShopDto selectOne4ShopService(ShopDto dto) {
		return dao.selectOne4ShopService(dto);
	}
	
	public List<ShopAvailableServiceDto> selectShopServiceCd(ShopAvailableServiceDto dto) {
		return dao.selectShopServiceCd(dto);
	}
	public List<ShopAvailableServiceDto> selectShopService(ShopAvailableServicesDto dtos) {
		return dao.selectShopService(dtos);
	}
	
	public List<ShopBikeBrandDto> selectShopBrandCd(ShopBikeBrandDto dto) {
		return dao.selectShopBrandCd(dto);
	}
	public List<ShopBikeBrandDto> selectShopBrand(ShopBikeBrandsDto dtos) {
		return dao.selectShopBrand(dtos);
	}
	
	public int insert(ShopDto dto) {
		return dao.insert(dto);
	}

	public int insertAvailableServices(List<ShopAvailableServiceDto> listAS, ShopDto dto) {
		dao.deleteByShopSeq(dto);
		 if (listAS != null && !listAS.isEmpty()) {
			 dao.insertAvailableServices(listAS);
		 }
		return 1;
	}
	
	public int insertHandlingBicycleBrands(List<ShopBikeBrandDto> listBB, ShopDto dto) {
//		dao.deleteSBByShopSeq(dto);
		if (listBB != null && !listBB.isEmpty()) {
			dao.insertHandlingBicycleBrands(listBB);
		}
		return 1;
	}
	
	public int update(ShopDto dto) {
		return dao.update(dto);
	}
}
