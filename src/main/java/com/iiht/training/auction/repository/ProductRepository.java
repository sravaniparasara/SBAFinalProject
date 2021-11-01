package com.iiht.training.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.training.auction.dto.ResponseDto;
import com.iiht.training.auction.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> getBySellerId(Long sellerId);
	List<ProductEntity> findByCategory(String category);
	
	@Query("SELECT new com.iiht.training.auction.dto.ResponseDto(p.category,p.detaileddescription,p.lastDateOfBidding,p.name,p.price,p.shortdescription,d.id) FROM ProductEntity p left outer join BidsEntity d on p.productId=d.productId where d.productId =:productId")
	 List<ResponseDto> findAllProducts(Long productId);
	
}

//SELECT category,detaileddescription,last_date_of_bidding,name,price,shortdescription FROM product
//LEFT JOIN bid ON product = bid.product;

