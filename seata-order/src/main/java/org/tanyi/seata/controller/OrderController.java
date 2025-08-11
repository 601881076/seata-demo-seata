package org.tanyi.seata.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanyi.seata.entity.OrderTbl;
import org.tanyi.seata.service.OrderTblService;

/**
 * @ClassName OrderController
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderTblService orderTblService;

    /**
     * 创建订单
     * @param productId    产品ID
     * @return
     */
    @PostMapping("/order")
    public ResponseEntity order(String productId, Long number, String userId) {
        log.info("创建订单");
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(productId);
        orderTbl.setCount(number);
        orderTbl.setMoney(number * 5);

        orderTblService.save(orderTbl);

        return ResponseEntity.ok().build();
    }
}
