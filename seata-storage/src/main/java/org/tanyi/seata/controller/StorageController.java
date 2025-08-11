package org.tanyi.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanyi.seata.entity.StockTbl;
import org.tanyi.seata.service.StockTblService;

/**
 * @ClassName StorageController
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class StorageController {
    private final StockTblService stockTblService;

    /**
     * 扣减库存
     * @param productId    产品ID
     * @return
     */
    @PostMapping("/deduction")
    public ResponseEntity deduction(String productId, Long number, String userId) {
        log.info("扣减库存");
        // 查询库存
        LambdaQueryWrapper<StockTbl> wrapper = Wrappers.lambdaQuery(StockTbl.class);
        wrapper.eq(StockTbl::getCommodityCode, productId);
        StockTbl one = stockTblService.getOne(wrapper);

        // 扣减库存
        one.setCount(one.getCount() - number);
        stockTblService.updateById(one);

        return ResponseEntity.ok().build();
    }
}
