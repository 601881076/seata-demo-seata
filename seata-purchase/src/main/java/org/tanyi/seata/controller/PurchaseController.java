package org.tanyi.seata.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanyi.seata.services.PurchaseServiceImpl;

/**
 * @ClassName PurchaseController
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseServiceImpl purchaseService;

    @GetMapping("/purchase")
    public ResponseEntity purchase(String userId, String productId, Long number) {
        purchaseService.purchase(userId, productId, number);
        return ResponseEntity.ok().build();
    }
}
