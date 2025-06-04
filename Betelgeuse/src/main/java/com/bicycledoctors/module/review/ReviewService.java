package com.bicycledoctors.module.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicycledoctors.common.base.BaseService;

@Service
public class ReviewService extends BaseService {
	
	@Autowired
	ReviewDao dao;
	
	public int insert(ReviewDto dto) {
		return dao.insert(dto);
	}

	public int selectOneCount(ReviewVo vo) {
		return dao.selectOneCount(vo);
	}
	public List<ReviewDto> selectList4Shop(ReviewVo vo) {
		return dao.selectList4Shop(vo);
	}

	public ReviewDto selectCount4Reviews(ReviewVo vo) {
		return dao.selectCount4Reviews(vo);
	}
	
	public int starRate(int star, ReviewVo vo) {
		ReviewDto dto = dao.selectCount4Reviews(vo);
    	int total = dto.getStarsCount();
        if (total == 0) return 0;

        switch (star) {
            case 5:
                return (int) ((dto.getStar5Count() / (double) total) * 100);
            case 4:
                return (int) ((dto.getStar4Count() / (double) total) * 100);
            case 3:
                return (int) ((dto.getStar3Count() / (double) total) * 100);
            case 2:
                return (int) ((dto.getStar2Count() / (double) total) * 100);
            case 1:
                return (int) ((dto.getStar1Count() / (double) total) * 100);
            default:
                return 0;
        }
    	
    }
	
}
