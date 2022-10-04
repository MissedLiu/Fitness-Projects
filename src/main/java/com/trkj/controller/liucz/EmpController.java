package com.trkj.controller.liucz;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.entity.liucz.Emp;
import com.trkj.entity.liucz.EmpAndUser;
import com.trkj.entity.liucz.User;
import com.trkj.service.implLiucz.EmpService;
import com.trkj.service.implLiucz.UserService;
import com.trkj.vo.queryLiucz.EmpAndUserQueryVo;
import com.trkj.vo.queryLiucz.EmpQueryVo;
import com.trkj.vo.queryLiucz.UserQueryVo;
import com.trkj.vo.queryLiucz.UserRoleQueryVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.trkj.utils.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 员工 前端控制器
 * </p>
 *
 * @author liucz
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/api/emp")
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private UserService userService;

    /*
     * 分页查询员工信息2
     * */
    @GetMapping("/list2")
    public Result empList2(EmpQueryVo empQueryVo) {
        IPage<Emp> empListByPage2 = empService.findEmpListByPage2(empQueryVo);
        return Result.ok(empListByPage2);
    }

    /*
     * 分页查询员工信息3
     * */
    @GetMapping("/list3")
    public Result empList3(EmpAndUserQueryVo empAndUserQueryVo) {
        IPage<EmpAndUser> empListByPage3 = empService.findEmpListByPage3(empAndUserQueryVo);
        return Result.ok(empListByPage3);
    }


    /*
     * 添加用户
     * */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:emp:add')")
    public Result add(@Validated @RequestBody Emp emp) {
        System.out.println("emp===" + emp);
        if (empService.save(emp)) {
            return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }

    /*
     * 修改用户
     * */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('sys:emp:edit')")
    public Result update(@RequestBody Emp emp) {
        System.out.println("emp===" + emp);
        if (empService.updateById(emp)) {
            return Result.ok().message("修改成功");
        }
        return Result.error().message("修改失败");
    }

    /*
     *删除员工
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:emp:delete')")
    public Result delete(@PathVariable Long id) {
        //根据传入的员工id查询是否存在相关账号信息
        List<User> userByEmpId = userService.findUserByEmpId(id);
        System.out.println("userByEmpId=============" + userByEmpId);
        if (userByEmpId.size() != 0) {
            return Result.error().message("该员工存在账户信息,请先收回账号!");
        } else {
            //根据员工id删除文件

            boolean b = empService.removeById(id);
            if (b) {
                return Result.ok().message("删除成功");
            }
            return Result.error().message("删除失败");
        }

    }

    /*
     * 查询所有的账户信息
     * */
    @GetMapping("/UserAll")
    public Result getUserAll() {
        return Result.ok(userService.findUserAll());
    }

    /*
     * 查看账户与角色的关系详情
     * */
    @GetMapping("/UserAndRole/{id}")
    public Result getUserAndRole(@PathVariable Long id) {
        List<UserRoleQueryVo> userAndRole = userService.findUserAndRole(id);
        if (userAndRole.size() == 0) {
            return Result.error().message("账户异常");
        }
        //有则返回数据
        return Result.ok(userAndRole);
    }

    /*
     * 分配账号
     * */
    @GetMapping("/updateUser/{userId}/{empId}")
    public Result updateUser(@PathVariable Long userId, @PathVariable Long empId) {
        System.out.println("userId==" + userId + "empId== " + empId);
        //根据员工id查询是否存在相关账号信息
//        User user = userService.EmpcheckUser(empId);
//        System.out.println("user========="+user);
        User user = userService.EmpcheckUser(empId);
        System.out.println("qqqqqqqqqqqqqqq=" + user);
        if (user != null) {
            return Result.error().message("该员工已分配账号");
        }
        //根据账号id查询是否存在员工信息,如果有则提示先解绑
        //检查该账户表里有没有员工
        int i = userService.checkEmp(userId);
        System.out.println("user=========检查该账户表里有没有员工" + i);
        //如果有就提示已分配
        if (i == 0) {
            return Result.error().message("该账号已分配,请先解绑");
        } else {
            //修改账户,分配员工
            int i1 = userService.updateUser(userId, empId);
            if (i1 <= 0) {
                return Result.error().message("员工分配失败,请联系管理员");
            }
            return Result.ok().message("分配成功");
        }


    }

    /*
     * 解绑账号和员工的关系
     * */
    @GetMapping("/updateUserAndemp/{id}")
    public Result deleteEmp(@PathVariable Long id) {

        //检查该账户表里有没有员工id
        User user = userService.checkUserAndEmp(id);
        if (user.getEmpId() != null) {
            //如果有就删除该员工
            if (user.getEmp().getEmpName() != null) {
                //删除该员工
                empService.removeById(user.getEmp().getEmpId());
                //修改账户表中empid为空
                if (userService.updateUser(id, null) == 1) {
                    return Result.ok().message("解绑成功");
                }
                return Result.ok().message("解绑失败,请联系管理员");

            } else {
                //修改账户表中empid为空
                if (userService.updateUser(id, null) == 1) {
                    return Result.ok().message("解绑成功");
                }
                return Result.ok().message("解绑失败,请联系管理员");
            }
        }
    return Result.ok().message("该账户没有绑定员工");
        }
    /**
     *
     * 按照多表按条件查询并分页
     * */
    @GetMapping("/userPageAll")
    @PreAuthorize("hasAuthority('sys:emp:user')")
    public Result findUserAndEmp2( UserQueryVo userQueryVo){
        System.out.println("userQueryVo=="+userQueryVo);
        IPage<User> userAndEmp = userService.findUserAndEmp2(userQueryVo);
        return Result.ok(userAndEmp);
    }

}

