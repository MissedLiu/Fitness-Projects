package com.trkj.service.implLiucz.liucz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.liucz.EmpAndUserMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.entity.liucz.EmpAndUser;
import com.trkj.service.implLiucz.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.service.implLiucz.FileService;
import com.trkj.service.implLiucz.UserService;
import com.trkj.utils.SystemConstants;
import com.trkj.vo.queryLiucz.EmpAndUserQueryVo;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 员工 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private UserService userService;
   @Resource
   private EmpMapper empMapper;
    @Resource
    private FileService fileService;
    @Resource
    private EmpAndUserMapper empAndUserMapper;
    //获取员工信息根据账户id获取员工信息
    @Override
    public Emp findEmpByEmpId(Long id) {
        Emp emp=baseMapper.selectById(id);
        return emp;
    }

    /*
     * 分页查询员工信息2
     * */
    @Override
    public IPage<Emp> findEmpListByPage2( EmpQueryVo empQueryVo) {
        Page<Emp> pageStr=new Page<Emp>(empQueryVo.getPageNo(),empQueryVo.getPageSize());
        IPage<Emp> iPage = empMapper.selectEmpUserNamePage(pageStr, empQueryVo);
        System.out.println("211111111111111 "+iPage.getRecords());
        return iPage;
    }
    /*
     * 分页查询员工信息3
     * */
    @Override
    public IPage<EmpAndUser> findEmpListByPage3(EmpAndUserQueryVo empAndUserQueryVo) {
        Page<EmpAndUser> pageStr=new Page<EmpAndUser>(empAndUserQueryVo.getPageNo(),empAndUserQueryVo.getPageSize());
        IPage<EmpAndUser> iPage =empAndUserMapper.selectEmpUserNamePage3(pageStr, empAndUserQueryVo);
        System.out.println("211111111111111 "+iPage.getRecords());
        return iPage;
    }
    /*
     * 根据员工id删除员工文件
     * */
    @Override
    public boolean deleteById(Long id) {
        //查询
        Emp emp = baseMapper.selectById(id);
        //删除用户
        if (baseMapper.deleteById(id) > 0) {
            //判断用户是否存在
            if (emp != null && !ObjectUtils.isEmpty(emp.getAvatar())
                    && !emp.getAvatar().equals(SystemConstants.DEFAULT_AVATAR)) {
                //删除文件
                fileService.deleteFile(emp.getAvatar());
            }
            return true;

        }
        return false;
    }

    /*
     * 分页查询员工信息（根据员工岗位）
     * */
    @Override
    public IPage<Emp> findEmpListByStation(EmpQueryVo empQueryVo){
        Page<Emp> pageStr=new Page<Emp>(empQueryVo.getPageNo(),empQueryVo.getPageSize());
        IPage<Emp> iPage =baseMapper.selectEmpListByStation(pageStr,empQueryVo);
        return iPage;
    }

}
