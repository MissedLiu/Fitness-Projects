package com.trkj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.Changenum;
import com.trkj.entity.Po;
import com.trkj.service.ChangenumService;
import com.trkj.service.PoService;
import com.trkj.service.StockInService;
import com.trkj.service.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.query.PoQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/po")
public class PoController {

    @Resource
    private PoService poService;

    @Resource
    private StockInService stockInService;

    @Resource
    private ChangenumService changenumService;

    @Resource
    private StoreService storeService;

    @GetMapping("/list")
    public Result findPoList(PoQueryVo poQueryVo) {
        //创建分页对象
        IPage<Po> page = new Page<>(poQueryVo.getPageNo(), poQueryVo.getPageSize());
        //调用分页查询方法
        poService.findAllPo(page, poQueryVo);

        return Result.ok(page);
    }

    @PostMapping("/toStock")
    public Result toStock(@RequestBody PoQueryVo poQueryVo) {
        Long ChangeNum = 0L;
        //如果报损数存在，则将报损数复制给ChangeNum并且将取其相反数
        if (!ObjectUtils.isEmpty(poQueryVo.getChangeLose())){
            ChangeNum=poQueryVo.getChangeLose()*(-1);
            //如果报溢数存在，则将报溢数复制给ChangeNUm
        }else if (!ObjectUtils.isEmpty(poQueryVo.getChangeMore())){
            ChangeNum=poQueryVo.getChangeMore();
        }
        //插入报损报溢表
        changenumService.toChangenum(poQueryVo);
        //如果改物品报损或报溢，则修改其入库数
        poQueryVo.setPoNum(poQueryVo.getPoNum()+ChangeNum);
        //如果库存中不存在相同物品名和品牌的物品，则直接入库
        if (storeService.CountSameNameAndBrand(poQueryVo) == 0) {
            //入库记录
            stockInService.toStock(poQueryVo);
            //库存表
            storeService.toStore(poQueryVo);
            //如果库存中存在相同物品名和品牌的物品，则查询 该物品的库存数，然后修改其库存数、修改时间。
        } else {
            Long StoreNum = storeService.FindStoreNum(poQueryVo);
            Date date=new Date();
            storeService.updateStoreNum(date,storeService.FindStoreId(poQueryVo),
                    poQueryVo.getPoNum()+storeService.FindStoreNum(poQueryVo));
        }

        return Result.ok().message("操作完成");
    }

    @DeleteMapping("/delete/{id}")
    private Result daletePo(@PathVariable Long id) {
        if (poService.removeById(id)) {
            return Result.ok().message("恭喜您删除成功");
        }
        return Result.ok().message("删除失败");
    }
}
