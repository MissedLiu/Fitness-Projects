package com.trkj.service.implLiucz2.liucz2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.dao.liucz2.FlyerMapper;
import com.trkj.entity.liucz2.Flyer;
import com.trkj.service.implLiucz2.FlyerService;
import com.trkj.vo.queryLiucz2.FlyerVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 张鑫
* @description 针对表【flyer(宣传活动记录表)】的数据库操作Service实现
* @createDate 2022-09-27 09:37:08
*/
@Service
public class FlyerServiceImpl extends ServiceImpl<FlyerMapper, Flyer>
    implements FlyerService {
  @Resource
  private  FlyerMapper flyerMapper;
  /**
   * @description:按条件查询并且分页
   * @author: Liucz
   * @date: 2022/9/29 19:41
   * @param: [flyer]
   * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.trkj.entity.liucz2.Flyer>
   **/
    @Override
    public IPage<Flyer> selectAllFlyer(FlyerVo flyerVo) {
      Page<Flyer> page=new Page<>(flyerVo.getPageNo(),flyerVo.getPageSize());
      IPage<Flyer> allByFlyerAddressFlyerIPage = flyerMapper.findAllByFlyerAddressFlyerIPage(page, flyerVo);
      System.out.println("allByFlyerAddressFlyerIPage="+allByFlyerAddressFlyerIPage.getRecords());
      return allByFlyerAddressFlyerIPage;
    }


    /*添加*/
    @Override
    public Boolean addFlyer(Flyer flyer) {
        return flyerMapper.addFlyer(flyer) ;
    }

}




