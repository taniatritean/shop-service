package org.fasttrackit.shop;

import org.fasttrackit.shop.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ttritean
 * @since 11/13/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShopApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class ShopIntegrationTest {


    @Autowired
    private ShopService shopService;

    @Test
    public void testFind() {
        shopService.findOne("1");
    }

}
