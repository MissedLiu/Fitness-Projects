package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Po;
import com.trkj.service.implOuyang.ChangenumService;
import com.trkj.service.implOuyang.PoService;
import com.trkj.service.implOuyang.StockInService;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.PoQueryVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
        System.out.println("poQueryVo="+poQueryVo);
        if (ObjectUtils.isEmpty(poQueryVo.getChangeLose()) && ObjectUtils.isEmpty(poQueryVo.getChangeMore())){
            return Result.error().message("请输入报损数溢数！");
        }else if (ObjectUtils.isEmpty(poQueryVo.getChangeLose())){
            return Result.error().message("请输入报损数！");
        }else  if(ObjectUtils.isEmpty(poQueryVo.getChangeMore())){
            return Result.error().message("请输入报溢数！");
        }
        if (poQueryVo.getChangeLose()>0 && poQueryVo.getChangeMore()>0){
            return Result.error().message("不能同时报溢和报损！");
        }
        if (poQueryVo.getChangeLose()>poQueryVo.getPoNum()){
            return Result.error().message("报损数不能大于物品数！");
        }
        Long ChangeNum = 0L;
        //如果报损数存在，则将报损数复制给ChangeNum并且将取其相反数
        if (poQueryVo.getChangeLose()>0){
            ChangeNum=poQueryVo.getChangeLose()*(-1);
            System.out.println("changeLose:"+ChangeNum);
            //如果报溢数存在，则将报溢数复制给ChangeNUm
        }else if (poQueryVo.getChangeMore()>0){
            ChangeNum=poQueryVo.getChangeMore();
            System.out.println("changeMore:"+ChangeNum);
        }
        //如果改物品报损或报溢，则修改其入库数
        poQueryVo.setPoNum(poQueryVo.getPoNum()+ChangeNum);
        //如果库存中不存在相同物品名和品牌的物品，则直接入库
        if ("未入库".equals(poQueryVo.getPoState())){

            if (storeService.CountSameNameAndBrand(poQueryVo) == 0) {
                //库存表
                storeService.toStore(poQueryVo);
                //如果库存中存在相同物品名和品牌的物品，则查询该物品的库存数，然后修改其库存数、修改时间。
            } else {
                Long StoreNum = storeService.FindStoreNum(poQueryVo);
                storeService.updateStoreNum(poQueryVo.getPoNum(),storeService.FindStoreId(poQueryVo),
                        poQueryVo.getPoNum() + StoreNum);
                poService.updatePoState(poQueryVo);
            }
            //插入报损报溢表
            changenumService.toChangenum(poQueryVo);
            poService.updatePoState(poQueryVo);
            stockInService.toStock(poQueryVo);
            return Result.ok().message("成功入库！");
        }return Result.error().message("该物品也已经入库了！");

    }

    @DeleteMapping("/delete/{id}")
    private Result daletePo(@PathVariable Long id) {
        if (poService.removeById(id)) {
            return Result.ok().message("恭喜您删除成功");
        }
        return Result.ok().message("删除失败");
    }

    @GetMapping("/getNotExecuted")
    public Result getNotExecuted(PoQueryVo poQueryVo){
        IPage<Po> page =new Page<>(poQueryVo.getPageNo(),poQueryVo.getPageSize());
        poService.getNotExecuted(page,poQueryVo);
        return Result.ok(page);
    }
}
