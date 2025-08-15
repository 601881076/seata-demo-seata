package org.tanyi.seata.services;

import org.apache.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tanyi.seata.api.AccountFeignClient;
import org.tanyi.seata.api.OrderFeignClient;
import org.tanyi.seata.api.StorageFeignClient;

/**
 * @ClassName PurchaseService
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl {
    private final AccountFeignClient accountFeignClient;
    private final OrderFeignClient  orderFeignClient;
    private final StorageFeignClient storageFeignClient;

    @GlobalTransactional(rollbackFor = Exception.class)
    public void purchase(String userId, String productId, Long number) {
        // 创建订单
        orderFeignClient.order(productId, number, userId);

        // 扣减余额
        accountFeignClient.account(userId, number * 5);

        // 此处报错时,余额未回滚和订单数据未回滚.
        if (number % 2 == 0) {
            throw new RuntimeException("自定义异常");
        }

        // 扣减库存
        storageFeignClient.deduction(productId, number, userId);
    }
}
