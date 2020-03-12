package cn.dsx.webscaffold.web;

import cn.dsx.webscaffold.core.Result;
import cn.dsx.webscaffold.core.ResultGenerator;
import cn.dsx.webscaffold.model.EmpLeave;
import cn.dsx.webscaffold.service.EmpLeaveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/03/12.
*/
@RestController
@RequestMapping("/emp/leave")
public class EmpLeaveController {
    @Resource
    private EmpLeaveService empLeaveService;

    @PostMapping("/add")
    public Result add(EmpLeave empLeave) {
        empLeaveService.save(empLeave);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        empLeaveService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(EmpLeave empLeave) {
        empLeaveService.update(empLeave);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        EmpLeave empLeave = empLeaveService.findById(id);
        return ResultGenerator.genSuccessResult(empLeave);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<EmpLeave> list = empLeaveService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
