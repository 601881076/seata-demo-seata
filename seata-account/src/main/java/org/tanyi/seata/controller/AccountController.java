package org.tanyi.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanyi.seata.entity.AccountTbl;
import org.tanyi.seata.service.AccountTblService;

/**
 * @ClassName AccountController
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class AccountController {
    private final AccountTblService accountTblService;

    /**
     * 扣减账户余额
     * @param userId    账户ID
     * @param money     扣减金额
     * @return
     */
    @PostMapping("/account")
    public ResponseEntity account(String userId, Long money) {
        log.info("扣减账户余额");
        LambdaQueryWrapper<AccountTbl> wrapper = Wrappers.lambdaQuery(AccountTbl.class);
        wrapper.eq(AccountTbl::getUserId, userId);
        AccountTbl one = accountTblService.getOne(wrapper);
        log.info("账户变更前信息 -> {}", one);

        // 变更账户余额
        one.setMoney(one.getMoney() - money);
        accountTblService.updateById(one);


        return ResponseEntity.ok().build();
    }


}
