package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Store;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.StoreQueryVo;
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

    @DeleteMapping("/delete/{id}")
    public Result deleteStore(@PathVariable Long id) {
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
   *
   * @author: Liucz
   * @date: 2022/9/30 15:03
   * @param: [storeQueryVo]
   * @return: com.trkj.utils.Result
   **/
    @PostMapping("/toOutStock")
    public Result toOutStock(@RequestBody StoreQueryVo storeQueryVo) {

        if (storeService.getStoreNumByStoreId(storeQueryVo) >= storeQueryVo.getOutStockNum()) {
            if (storeService.toOutStock(storeQueryVo)) {
                if (storeService.updateStroeNumChu(storeQueryVo)) {
                    return Result.ok().message("出库成功");
                }
                return Result.error().message("修改库存失败！");
            }
            return Result.error().message("出库失败！");
        }
        return Result.error().message("出库数不可多于库存数！");
        }

}
