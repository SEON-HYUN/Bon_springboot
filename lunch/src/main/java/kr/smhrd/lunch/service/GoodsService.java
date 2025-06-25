package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	GoodsRepository goodsRepo;
	
	@Autowired
	GoodsDetailRepository detailRepo
	
	// 특정 컴포넌트 찾지 못한다!
	// 1. 내가 컴포넌트 만들었나?
	// 2. AutoWired -> 작성이 되었는가?
	// 3. 어노테이션 작성 되었는가?
	
	public List<GoodsDTO> getGoodsList() {
		// 1. 데이터 처리
		// 2. repository 호출
		List<Goods> result = goodsRepo.findAll();
		// 3. Controller 돌려줄 데이터 처리
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		GoodsDTO dto = new GoodsDTO();
		for(Goods g :result) {
			dto.setId(g.getId());
			dto.setName(g.getName());
			dto.setPrice(g.getPrice());
			dto.setIsNew(g.getIsNew());
			dto.setIsBest(g.getIsBest());
			dto.setMain_thumb(g.getMain_thumb());
			list.add(dto);
		}
		
		return list;
	}
	
}
