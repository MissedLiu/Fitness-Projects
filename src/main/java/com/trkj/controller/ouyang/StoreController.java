package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Store;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.StoreQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @GetMapping("/list")
    public Result findStoreList(StoreQueryVo storeQueryVo) {
        //创建分页对象
        IPage<Store> page = new Page<>(storeQueryVo.getPageNo(), storeQueryVo.getPageSize());
        //调用分页查询方法
        storeService.findStoreList(page, storeQueryVo);

        return Result.ok(page);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */

    @PreAuthorize("hasAnyAuthority('stores:store:delete')")
    @DeleteMapping("/delete/{id}")
    public Result deleteStore(@PathVariable Long id) {
        //判断库存数是否为0
        if (storeService.FindStoreNumByID(id) == 0) {
            if (storeService.removeById(id)) {
                return Result.ok().message("删除成功");
            }
            return Result.error().message("删除失败！");
        }
        return Result.error().message("库存数不为0，无法删除！");
    }

    /**
     * @description:
     * @author: Liucz
     * @date: 2022/9/30 15:03
     * @param: [storeQueryVo]
     * @return: com.trkj.utils.Result
     **/
    @PreAuthorize("hasAnyAuthority('stores:store:outStock')")
    @PostMapping("/toOutStock")
    public Result toOutStock(@RequestBody StoreQueryVo storeQueryVo) {
        //判断库存数是否大于前端输入的出库数量
        if (storeService.getStoreNumByStoreId(storeQueryVo) >= storeQueryVo.getOutStockNum()) {

            if (storeService.getEmpByName(storeQueryVo)) {
                //如果大于 则调用出库方法
                if (storeService.toOutStock(storeQueryVo)) {
                    //添加出库记录
                    if (storeService.toOutStockRecord(storeQueryVo)) {
                        //出库后修改库存中的数量
                        if (storeService.updateStroeNumChu(storeQueryVo)) {
                            return Result.ok().message("出库成功");
                        }
                        return Result.error().message("修改库存失败！");
                    }
                    return Result.error().message("添加出库记录失败");
                }
                return Result.error().message("出库失败！");
            }
            return Result.error().message("领取人姓名输入有误！");
        }
        return Result.error().message("出库数不可多于库存数！");
    }

}
