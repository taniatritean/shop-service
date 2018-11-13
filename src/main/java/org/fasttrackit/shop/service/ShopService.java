package org.fasttrackit.shop.service;

import org.fasttrackit.shop.domain.Shop;
import org.fasttrackit.shop.exception.NotFoundException;
import org.fasttrackit.shop.persistence.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private static final int DEFAULT_PAGE = 0;

    @Value("${params.page.size.default}")
    private int defaultPageSize;

    @Autowired
    private ShopRepository shopRepository;

    public Shop findOne(Long shopId) {
        Shop shop = shopRepository.findOne(shopId);
        if (shop == null) {
            throw new NotFoundException(shopId);
        }
        return shop;
    }
}
