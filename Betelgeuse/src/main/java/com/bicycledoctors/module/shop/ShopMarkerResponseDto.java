package com.bicycledoctors.module.shop;

public class ShopMarkerResponseDto {

	private String id;
	private String shopSeq;
    private String image;
    private String shopName;
    private String shopAddress;
    private String shopTel;
    private String path;
    private Coordinates coordinates;

    // 생성자: ShopDto → JSON 응답용 DTO로 변환
    public ShopMarkerResponseDto(ShopDto dto) {
        this.id = dto.getUserCustomer_seq();
        this.id = dto.getShopSeq();
        this.image = dto.getPath();
        this.shopName = dto.getShopName();
        this.shopAddress = dto.getShopAddress1();
        this.shopTel = dto.getShopTel();
        this.coordinates = new Coordinates(
            dto.getShopLatitude() != null ? dto.getShopLatitude() : 37.0,
            dto.getShopLongitude() != null ? dto.getShopLongitude() : 127.0
        );
    }

    public ShopMarkerResponseDto(String id, String shopSeq, String path, String shopName2, String shopTel2, String shopAddress1,
			Double shopLatitude, Double shopLongitude) {
    	this.id = id;
    	this.shopSeq = shopSeq;
        this.image = path;
        this.shopName = shopName2;
        this.shopAddress = shopAddress1;
        this.shopTel = shopTel2;
        this.coordinates = new Coordinates(
    		shopLatitude != null ? shopLatitude : 37.0,
			shopLongitude != null ? shopLongitude : 127.0
        );
		// TODO Auto-generated constructor stub
	}

	public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getShopTel() {
        return shopTel;
    }

    public String getShopSeq() {
		return shopSeq;
	}

	public Coordinates getCoordinates() {
        return coordinates;
    }

    // 내부 클래스 - 위경도 정보를 포함
    public static class Coordinates {
        private double lat;
        private double lng;

        public Coordinates(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public double getLng() {
            return lng;
        }
    }
	
}
