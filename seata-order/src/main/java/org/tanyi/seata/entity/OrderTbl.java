package org.tanyi.seata.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
@TableName("order_tbl")
public class OrderTbl implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private String userId;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Long count;

    @TableField("money")
    private Long money;




}