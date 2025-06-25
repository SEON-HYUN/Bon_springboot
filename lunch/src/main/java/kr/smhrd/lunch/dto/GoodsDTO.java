package kr.smhrd.lunch.dto;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {

	private Integer id;
	private String name;
	private String price;
	private Boolean isNew;
	private Boolean isBest;
	private String main_thumb;

	// Goods
	
}
