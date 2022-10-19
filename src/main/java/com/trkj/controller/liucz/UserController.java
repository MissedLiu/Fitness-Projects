package com.trkj.controller.liucz;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.dto.UserRoleDTO;
import com.trkj.entity.liucz.Role;
import com.trkj.entity.liucz.User;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.implLiucz.RoleService;
import com.trkj.service.implLiucz.UserService;
import com.trkj.utils.Result;
import com.trkj.vo.queryLiucz.RoleQueryVo;
import com.trkj.vo.queryLiucz.UserQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 账户表 前端控制器
 *
 *
 * @author liucz
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmpService empService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private RoleService roleService;

    /**
     * 查询所有账户列表
     */
    @GetMapping("/listAll")
    public Result listAll(){
        return Result.ok(userService.list());
    }
    /**
     *
     * 按照多表按条件查询并分页
     * */
    @GetMapping("/pageAll")
    public Result findUserAndEmp( UserQueryVo userQueryVo){
        IPage<UserQueryVo> userAndEmp = userService.findUserAndEmp(userQueryVo);
        return Result.ok(userAndEmp);
    }
    /**
     *
     * 按照多表按条件查询并分页
     * */
    @GetMapping("/userPageAll")
    public Result findUserAndEmp2( UserQueryVo userQueryVo){
        IPage<User> userAndEmp = userService.findUserAndEmp2(userQueryVo);
        return Result.ok(userAndEmp);
    }
    /*
     *根据账户名查询账户信息是否存在
     * */
    @GetMapping("/checkUser")
    public Result getUserByusername( User user){
        User userByUsername = userService.findUserByUserName(user.getUsername());
        //如果为true则表示不存在
        if (userByUsername==null){
            return  Result.ok(true);
        }
        return Result.exist().message("该用户已存在");
    }
    /*
    * 添加账户
    * */
    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('sys:account:add')")
    public  Result addUser(@RequestBody User user){
        //查询添加的用户名是否已经存在
        User user1 = userService.findUserByUserName(user.getUsername());
        //判断存在则抛出错误提示
        if (user1 != null) {
            return Result.error().message("该用户名已存在,请重新输入!");
        }
        //进行密码加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //调用保存用户信息的方法
        user.setIsAdmin(0);
        if (userService.save(user)){
           return Result.ok().message("账户添加成功");
       }
        return Result.exist().message("账户添加失败");
    }
    /*
    * 修改账户
    * */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('sys:account:edit')")
    public  Result update(@RequestBody User user){
        //查询修改的用户名是否已经存在
        User userName = userService.findUserByUserName(user.getUsername());
        //判断对象是否为空,不为空则表示存在
        if(userName !=null &&userName.getId() !=user.getId() ){
            return Result.error().message("该用户名已被使用,请重新输入!");
        }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (userService.UpdateUserByUserId(user)>0){
            return Result.ok().message("账户修改成功");
        }
        return Result.error().message("账户修改失败");
    }
    /*
    * 检查该账户下是否有员工,验证删除时
    * */
    @GetMapping("/checkEmp/{id}")
    public Result checkEmp(@PathVariable Long id){
        if (userService.checkEmp(id)==1){
            //不存在员工
            return Result.ok(false);
        }
        return Result.exist().message("该账户下存在员工,无法删除");
    }
    /*
    * 删除该账户
    * */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:account:delete')")
    public Result delete(@PathVariable Long id){
        System.out.println("=="+id);
        if (userService.delete(id)>0){
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
        /*
        *  获取分配角色列表
        *
        * */
    @GetMapping("/getRoleListForAssign")
    public Result getRoleListForAssign(RoleQueryVo roleQueryVo){
        //创建分页对象
        IPage<Role> page = new Page<Role>(roleQueryVo.getPageNo(),roleQueryVo.getPageSize());
        //调用查询方法
        roleService.findRoleListById(page,roleQueryVo);
        //返回数据
        return Result.ok(page);

    }
    /**
     * 根据用户ID查询该用户拥有的角色列表
     *
     */
    @GetMapping("/getRoleByUserId/{userId}")
    public Result getRoleByUserId(@PathVariable Long userId) {
        //调用根据账户ID查询该账户拥有的角色ID的方法
        List<Long> roleIds = roleService.findRoleIdByUserId(userId);
        return Result.ok(roleIds);
    }
    /*
     * 分配角色
     * */
    @PostMapping("/saveUserRole")
    @PreAuthorize("hasAuthority('sys:account:role')")
    public Result saveUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        //保存用户角色的关系
        if (userService.saveUserRole(userRoleDTO.getUserId(), userRoleDTO.getRoleIds())) {
            return Result.ok().message("角色分配成功");
        }
        return Result.error().message("角色分配失败");
    }
    /*
    * 检查该账户下是否有员工,验证删除时
    * */
    @GetMapping("/checkEmpName/{id}")
    public Result checkEmpName(@PathVariable Long id){
        if (userService.checkEmp(id)==1){
            //不存在员工
            return Result.exist().message("该账户未分配给员工,无法分配权限");
        }
        //存在员工
        return Result.ok(false);
    }
    /**
     * @description:
     * 根据账号id查询所有员工信息
     * @author: Liucz
     * @date: 2022/10/6 23:20
     * @param:
     * @return:
     **/
    @GetMapping("/empByUserId/{id}")
    public Result  empByUserId(@PathVariable Long id){
        User userByUserId = userService.findUserEmpByUserId(id);
        return Result.ok(userByUserId);
    }
}

