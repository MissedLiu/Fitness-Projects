package com.trkj.service.implLiucz.liucz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.dao.liucz.EmpMapper;
import com.trkj.entity.liucz.Department;
import com.trkj.dao.liucz.DepartmentMapper;
import com.trkj.entity.liucz.Emp;
import com.trkj.service.implLiucz.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.utils.DepartmentTree;
import com.trkj.vo.queryLiucz.DepartmentQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Resource
    private EmpMapper empMapper;

    /**
     * 查询部门列表
     *
     * @param departmentQueryVo
     * @return
     */
    @Override
    public List<Department> findDepartmentList(DepartmentQueryVo departmentQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
        //部门名称
        //第一个判断条件,若为ture,则表示此句有效,若为false,则此句无效
        queryWrapper.like(!ObjectUtils.isEmpty(departmentQueryVo.getDepartmentName()), "department_name", departmentQueryVo.getDepartmentName());
        //排序
        queryWrapper.orderByAsc("order_num");
        List<Department> departmentList = baseMapper.selectList(queryWrapper);
        List<Department> departmentTree = new ArrayList<>();
        if (!departmentList.isEmpty()) {  //如果list不为空,即没有条件或者条件正确
            //departmentList.stream().....getAsLong() 返回集合中最小的Pid
            departmentTree = DepartmentTree.makeDepartmentTree(departmentList, departmentList.stream().mapToLong(Department::getPid).min().getAsLong());
        }//如果list为空,即条件错误或无数据的时候,直接返回一个空集合
        return departmentTree;
    }
    /**
     * 查询上级部门列表
     *
     * @return
     */
    @Override
    public List<Department> findParentDepartment() {
        //创建条件构造器对象
        QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
        //排序
        queryWrapper.orderByAsc("order_num");
        //查询部门列表
        List<Department> departmentList = baseMapper.selectList(queryWrapper);
        //创建部门对象
        Department department = new Department();
        department.setId(0L);
        department.setDepartmentName("顶级部门");
        department.setPid(-1L);
        departmentList.add(department);
        //生成部门树列表
        List<Department> departmentTree =
                DepartmentTree.makeDepartmentTree(departmentList, -1L);
        //返回部门列表
        return departmentTree;
    }

    /**
     * 判断部门下是否有子部门
     *
     * @param id
     * @return
     */
    @Override
    public boolean hasChildrenOfDepartment(Long id) {
        //创建条件构造器对象
        QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
        queryWrapper.eq("pid", id);
        //如果数量大于0，表示存在
        if (baseMapper.selectCount(queryWrapper) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断部门下是否存在用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean hasUserOfDepartment(Long id) {

        //创建条件构造器对象
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<Emp>();
        queryWrapper.eq("department_id", id);
        //如果数量大于0，表示存在
        if (empMapper.selectCount(queryWrapper) > 0) {
            return true;
        }
        return false;
    }
}
