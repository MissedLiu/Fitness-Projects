package com.trkj.service.implLiucz.liucz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dao.liucz.UserAndEmpMapper;
import com.trkj.dao.liucz.UserRoleMapper;
import com.trkj.entity.liucz.User;
import com.trkj.dao.liucz.UserMapper;
import com.trkj.service.implLiucz.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.vo.queryLiucz.UserQueryVo;
import com.trkj.vo.queryLiucz.UserRoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper  userMapper;
    @Resource
    private UserAndEmpMapper userAndEmpMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    /*
    * 根据用户名进行查询
    * */
    @Override
    public User findUserByUserName(String username) {
        User userByUserName = userMapper.findUserByUserName(username);
        return userByUserName;
    }
    /*
    * 根据账户id进行查询
    * */
    @Override
    public User findUserByUserId(Long id) {
        User userByUserId = userMapper.findUserByUserId(id);
        //执行查询
        return userByUserId;
    }

    /*
    * 根据条件动态查询账户与员工信息并分页
    * */
    @Override
    public IPage<UserQueryVo> findUserAndEmp(UserQueryVo userQueryVo) {
        Page<UserQueryVo> pageStr=new Page<>(userQueryVo.getPageNo(),userQueryVo.getPageSize());
        IPage<UserQueryVo> iPage = userAndEmpMapper.selectXmlPage2(pageStr, userQueryVo);
        System.out.println(pageStr);
        return iPage;
    }
    /*
    *  根据账户id修改账户名和密码
    * */
    @Override
    public int UpdateUserByUserId(User user) {
        int i = userMapper.UpdateUserByUserId(user);
        return i;
    }

    /*
    * 根据条件动态查询账户与员工信息并分页,映射关联查询
    * */
    @Override
    public IPage<User> findUserAndEmp2(UserQueryVo userQueryVo) {
        Page<User> pageStr=new Page<>(userQueryVo.getPageNo(),userQueryVo.getPageSize());
        IPage<User> iPage = userMapper.selectXmlPage3(pageStr, userQueryVo);
        return iPage;
    }
    /*
    * 根据条件动态查询账户与员工信息并分页,映射关联查询
    * */
    @Override
    public int checkEmp(Long id) {
        User user = userMapper.checkEmp(id);
        System.out.println("12222222222222="+user);
        //,有员工信息时返回
        if ( user.getEmp().getEmpName() !=null){
            return 0;
        }
        //当员工姓名为空时返回1,则没有员工信息
        return 1;
    }
    /*
     * 检查该账户下是否有员工
     * */
    @Override
    public User checkUserAndEmp(Long id) {
        User user = userMapper.checkEmp(id);
        return user;
    }

    /**
     * 分配角色,添加
     */
    @Override
    public boolean saveUserRole(Long userId, List<Long> roleIds) {
        //先删除原来的用户与角色的关系
            baseMapper.deleteUserRole(userId);
        //保存用户角色关系
        return baseMapper.saveUserRole(userId, roleIds) > 0;
    }
    /*
     * 根据员工id查询账号信息
     * */
    @Override
    public  List<User>  findUserByEmpId(Long id) {
        List<User>  userByEmpId = baseMapper.findUserByEmpId(id);
        return userByEmpId;
    }
    /*
     * 查询所有账户信息
     * */
    @Override
    public List<User> findUserAll() {
        List<User> users = baseMapper.selectList(null);
        return users;
    }
    /*
     * 查看账户与角色的关系详情
     * */
    @Override
    public List<UserRoleQueryVo> findUserAndRole(Long id) {
        List<UserRoleQueryVo> userAndRoleById = userRoleMapper.findUserAndRoleById(id);
        return userAndRoleById;
    }

    /*
     * 添加员工进账户表
     * */
    @Override
    public int updateUser(Long userId, Long empId) {
        int i = userMapper.updateUser(userId, empId);
        return i;
    }
    /*
     * 根据员工id查询是否存在相关账号信息
     * */

    @Override
    public User EmpcheckUser(Long empId) {
        //根据员工id查询账号信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("emp_id", empId);
        return  baseMapper.selectOne(queryWrapper);
    }


}