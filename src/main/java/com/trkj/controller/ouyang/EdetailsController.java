package com.trkj.controller.ouyang;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.entity.ouyang.Edetails;
import com.trkj.service.implOuyang.EdetailsService;
import com.trkj.service.implOuyang.StockOutService;
import com.trkj.service.implOuyang.StoreService;
import com.trkj.utils.Result;
import com.trkj.vo.queryOuyang.EdetailsQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.attribute.ResolutionSyntax;

@RestController
@RequestMapping("/api/details")
public class EdetailsController {

    @Resource
    private EdetailsService edetailsService;

    @Resource
    private StockOutService stockOutService;

    @Resource
    private StoreService storeService;


    @GetMapping("/list")
    public Result findDetails(EdetailsQueryVo edetailsQueryVo){
        IPage <Edetails>page=new Page(edetailsQueryVo.getPageNo(),edetailsQueryVo.getPageSize());
        edetailsService.findDetailsPage(page,edetailsQueryVo);
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addDetails(@RequestBody Edetails edetails){
        if (storeService.getPoidByEdetails(edetails)!=null){
            edetails.setStockinId(storeService.getPoidByEdetails(edetails));
        }else {
            return Result.error().message("请输入正确的器材名称和品牌");
        }
        if (edetailsService.CountDetailsByEdCode(edetails)!=0){
            return Result.error().message("不能输入已存在的器材标识编码！");
        }
        if (edetails.getEdCode()==""){
            return Result.error().message("请输入输入器材标识编码！");
        }
        if (edetailsService.getSumDetails(edetails)==null){
            if (edetailsService.addDetails(edetails)){
                return Result.ok().message("添加成功");
            }
            return Result.error().message("添加失败！");
        }
        if (stockOutService.getOutNum(edetails)<=edetailsService.getSumDetails(edetails)){
            return Result.error().message("记录条数不能大于出库数！");
        }else {
            if (edetailsService.addDetails(edetails)){
                return Result.ok().message("添加成功");
            }
            return Result.error().message("添加失败！");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteDetails(@PathVariable Long id){
        Edetails edetails= edetailsService.getById(id);
        if (edetails.getEdState()!=1){
            if (edetailsService.removeById(id)){
                return Result.ok().message("删除成功");
            }
            return Result.error().message("删除失败！");
        }return Result.error().message("器材使用中，不能删除记录！");

    }

    @PutMapping("/update")
    public Result updateDetails(@RequestBody Edetails edetails){
        if ("使用中".equals(edetails.getEdState())){
            edetails.setEdState(1L);
        }else if ("未使用".equals(edetails.getEdState())){
            edetails.setEdState(0L);
        }
        if (edetails.getEdCode()==""){
            return Result.error().message("请输入输入器材标识编码！");
        }
        if (edetailsService.updateById(edetails)){
            return Result.ok().message("修改成功");
        }return Result.error().message("修改失败");
    }

}
