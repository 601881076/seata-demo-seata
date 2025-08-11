package org.tanyi.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName AccountFeignClient
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@FeignClient(name = "account-server")
public interface AccountFeignClient {
    @PostMapping("/account")
    ResponseEntity account(@RequestParam(value = "userId") String userId, @RequestParam(value = "money") Long money);
}
