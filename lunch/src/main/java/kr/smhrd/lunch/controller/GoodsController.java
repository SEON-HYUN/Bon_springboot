package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://43.201.30.191:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {

	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/goods_list/{id}")
	public GoodsDTO getGoodsD(@PathVariable("id") int id) {
		
		GoodsDTO goodsDetail = goodsService.getGoodsDetail(id);
		
		return goodsDetail;
	}
	
	
	
	@GetMapping("/goods_list")
	public List<GoodsDTO> getGoodsList() {
		
		System.out.println("list 출력 컨트롤러");
		
		// 2. Step -> Service -> Repository
		// -> Service 클래스 불러오기!
		
		
		List<GoodsDTO> list = goodsService.getGoodsList(); // -> 
		
		return list;
	}
	
	public GoodsDTO getGoodsDetail(int id) {
		
		// 1. id값을 가지고 제품 정보 Goods 가지고 오기!
		Goods goods = goodsRepo.findById(id).orElse(null);
		GoodsDetail detail = detailRepo.findById(id).orElse(null);
		
		// 2. 두 변수의 값이 null인 경우에는 null을 리턴
		if(goods == null || detail == null) {
			return null;
		}
		
		GoodsDTO dto = new GoodsDTO();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsBest());
		dto.setMain_thumb(goods.detMain_thumb());
		dto.setDetail(detail);
		
		return dto;
	}
}
