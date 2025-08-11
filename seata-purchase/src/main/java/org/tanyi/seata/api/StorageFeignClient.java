package org.tanyi.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName StorageFeignClient
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@FeignClient(name = "storage-server")
public interface StorageFeignClient {

    @PostMapping("/deduction")
    ResponseEntity deduction(@RequestParam(value = "productId") String productId,
                             @RequestParam(value = "number") Long number,
                             @RequestParam(value = "userId") String userId);
}
