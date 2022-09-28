package com.trkj.dao;

import com.trkj.entity.Po;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
* @author oyzz
* @description 针对表【po(物品已购表)】的数据库操作Mapper
* @createDate 2022-09-22 11:33:17
* @Entity com.trkj.entity.Po
*/
public interface PoMapper extends BaseMapper<Po> {
@Update(value = "update po set po_state='已入库' where po_id=#{poId}")
    public boolean updatePoState(Po po);


}




