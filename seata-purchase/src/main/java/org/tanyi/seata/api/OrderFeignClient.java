package org.tanyi.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName OrderFeignClient
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@FeignClient(name = "order-server")
public interface OrderFeignClient {

    @PostMapping("/order")
    public ResponseEntity order(@RequestParam(value = "productId") String productId,
                                @RequestParam(value = "number") Long number,
                                @RequestParam(value = "userId") String userId);
}
