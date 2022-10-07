package com.trkj.service.implLiucz2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz2.CaigouShenhe;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.query.PageVo;

import java.util.List;

/**
 *
 */
public interface CaigouShenheService extends IService<CaigouShenhe> {
    /**
     * @description:
     * 根据采购编号查询结果
     * @author: Liucz
     * @date: 2022/10/5 15:07
     * @param:
     * @return:
     **/
    List<CaigouShenhe> checkShenqing(Long id);
    //同意事件,修改状态=1
    int updateAgress(CaigouShenhe caigouShenhe);
    //拒绝事件,修改状态=2
    int updateRefuse(CaigouShenhe caigouShenhe);
    /**
     * @description:
     * 根据采购编号查询审核状态
     * @author: Liucz
     * @date: 2022/10/5 19:07
     * @param:
     * @return:
     **/
    List<CaigouShenhe> findAllState(Long id);
    /**
     * @description:
     * 删除事件,修改状态=5
     * @author: Liucz
     * @date: 2022/10/5 19:49
     * @param:
     * @return:
     **/
    int delete5(CaigouShenhe caigouShenhe);
    /**
     * @description:
     * 删除审核记录事件
     * @author: Liucz
     * @date: 2022/10/5 19:49
     * @param:
     * @return:
     **/
    int delete6(Long id);
}
