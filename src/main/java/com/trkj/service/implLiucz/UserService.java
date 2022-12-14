package com.trkj.service.implLiucz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.vo.queryLiucz.UserQueryVo;
import com.trkj.vo.queryLiucz.UserRoleQueryVo;

import java.util.List;

/**
 * <p>
 * 账户表 服务类
 * </p>
 *
 * @author liucz
 * @since 2022-09-17
 */
public interface UserService extends IService<User> {
    /*
    * 根据用户名进行查询
    * */

    User findUserByUserName(String username);

    /*
    * 根据账户id进行查询
    * */

    User findUserByUserId(Long id);

    /*
    * 根据条件动态查询账户与员工信息并分页
    * */

    IPage<UserQueryVo> findUserAndEmp(UserQueryVo userQueryVo);

    /*
    * 根据账户id修改账户名和密码
    * */

    int UpdateUserByUserId(User user);

    /*
    * 根据条件动态查询账户与员工信息并分页,映射关联查询
    * */

    IPage<User> findUserAndEmp2(UserQueryVo userQueryVo);

    /*
    * 检查该账户下是否有员工
    * */

    int checkEmp(Long id);

    /*
    * 检查该账户下是否有员工
    * */

    User checkUserAndEmp(Long id);

    /**
     * 分配角色,添加
    */
    boolean saveUserRole(Long userId, List<Long> roleIds);

    /*
    * 根据员工id查询账号信息
    * */

    List<User> findUserByEmpId(Long id);

    /*
    * 查询所有账户信息
    * */

    List<User> findUserAll();

    /*
    * 查看账户与角色的关系详情
    * */

    List<UserRoleQueryVo> findUserAndRole(Long id);


    /*
    * 添加员工进账户表
    * */
    int updateUser(Long userId,Long empId);

    /*
     * 根据员工id查询是否存在相关账号信息
     * */

    User EmpcheckUser(Long empId);
    /**
     * @description:
     * 查询财务部门下的账号以及员工信息
     * @author: Liucz
     * @date: 2022/10/5 13:50
     * @param:
     * @return:
     **/
    List<User> findCauWu();
    /**
     * @description:
     * 查询维修部门下的账号以及员工信息
     * @author: Liucz
     * @date: 2022/10/5 13:50
     * @param:
     * @return:
     **/
    List<User> findWeiXiu();
    //根据账户id查询员工所有信息
    User findUserEmpByUserId(Long id);

    //根据id删除
    int delete(Long id);
}
