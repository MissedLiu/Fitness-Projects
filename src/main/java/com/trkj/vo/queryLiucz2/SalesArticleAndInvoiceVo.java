package com.trkj.vo.queryLiucz2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: Fitness-Projects
 * @BelongsPackage: com.trkj.vo.queryLiucz2
 * @Author: LiuCZ
 * @CreateTime: 2022-10-01  16:29
 * @Description: TODO
 * @Version: 5.0
 */
@Data
public class SalesArticleAndInvoiceVo {
     private String brand;//品牌
     private String  invoicedName;//购买人姓名
     private Long   saempId;//当前销售人编号
     private Long  salesPrice;//售价
     private Long stockInNum;//购买数量
     private String  stockinName;//商品名称
     private Long outId ; //出库物品商品id
     private Long salesId;//商品记录id
    private Long stockinId;//出库物品id
    private Long saId;//商品记录id



}