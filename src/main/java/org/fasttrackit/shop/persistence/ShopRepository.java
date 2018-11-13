package org.fasttrackit.shop.persistence;

import org.fasttrackit.shop.domain.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {

}
