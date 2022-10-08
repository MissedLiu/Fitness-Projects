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

    /**
     * 获取器材使用记录
     * @param edetailsQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result findDetails(EdetailsQueryVo edetailsQueryVo){
        IPage <Edetails>page=new Page(edetailsQueryVo.getPageNo(),edetailsQueryVo.getPageSize());
        edetailsService.findDetailsPage(page,edetailsQueryVo);
        return Result.ok(page);
    }

    /**
     * 添加
     * @param edetails
     * @return
     */
    @PostMapping("/add")
    public Result addDetails(@RequestBody Edetails edetails){
        //通过前端回传的信息 判断出库表中是否有此器材
        if (storeService.getPoidByEdetails(edetails)!=null){
            //如果有 则将出库表中的器材id赋值给该器材记录
            edetails.setStockinId(storeService.getPoidByEdetails(edetails));
        }else {
            //如果没有则提示错误信息
            return Result.error().message("请输入正确的器材名称和品牌");
        }
        //判断库中是否有相同的器材辨识编码
        if (edetailsService.CountDetailsByEdCode(edetails)!=0){
            return Result.error().message("不能输入已存在的器材标识编码！");
        }
        //如果器材标识编码为空
        if (edetails.getEdCode()==""){
            return Result.error().message("请输入输入器材标识编码！");
        }
        //如果当前要新增的器材在器材使用表中没有记录 就直接插入记录
        if (edetailsService.getSumDetails(edetails)==null){
            if (edetailsService.addDetails(edetails)){
                return Result.ok().message("添加成功");
            }
            return Result.error().message("添加失败！");
        }
        //判断使用记录表中该器材的数量是否大于出库的数量
        if (stockOutService.getOutNum(edetails)<=edetailsService.getSumDetails(edetails)){
            return Result.error().message("记录条数不能大于出库数！");
        }else {
            if (edetailsService.addDetails(edetails)){
                return Result.ok().message("添加成功");
            }
            return Result.error().message("添加失败！");
        }
    }

    /**
     * 通过id删除记录
     * @param id
     * @return
     */
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

    /**
     * 修改器材使用记录信息
     * @param edetails
     * @return
     */
    @PutMapping("/update")
    public Result updateDetails(@RequestBody Edetails edetails){
        //前端回传的数据为使用中和未使用 将其修改为1和0
        if ("使用中".equals(edetails.getEdState())){
            edetails.setEdState(1L);
        }else if ("未使用".equals(edetails.getEdState())){
            edetails.setEdState(0L);
        }
        //如果输入的标识编码为空
        if (edetails.getEdCode()==""){
            return Result.error().message("请输入输入器材标识编码！");
        }
        if (edetailsService.updateById(edetails)){
            return Result.ok().message("修改成功");
        }return Result.error().message("修改失败");
    }

}
