package com.ruoyi.web.controller.system;


import java.util.List;

import com.ruoyi.system.domain.StuStudent;
import com.ruoyi.system.service.IStuStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生Controller
 *
 * @author feiying
 * @date 2022-08-01
 */
@Controller
@RequestMapping("/system/student")
public class StuStudentController extends BaseController
// Shiro认证权限处理顺序：RequiresRoles、RequiresPermissions、RequiresAuthentication、RequiresUser、RequiresGuest
{
    private String prefix = "system/student";

    @Autowired
    private IStuStudentService stuStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StuStudent stuStudent)
    {
        startPage(); // 此方法配合前端完成自动分页，且只对第一个查询（Select）语句得到的数据进行分页。
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        return getDataTable(list); // 响应请求分页数据
    }

    /**
     * 导出学生列表
     * 导出默认流程是先创建一个临时文件，等待前端请求下载结束后马上删除这个临时文件
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StuStudent stuStudent)
    {
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        ExcelUtil<StuStudent> util = new ExcelUtil<StuStudent>(StuStudent.class);
        return util.exportExcel(list, "学生数据");// 对list数据源将其里面的数据导入到excel表单
    }

    /**
     * 新增学生
     */
    @GetMapping("/add")
    public String add()
    {
        // 返回的html页面（会被视图解析器thymeleaf处理）
        return prefix + "/add";
    }

    /**
     * 新增保存学生
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生", businessType = BusinessType.INSERT)// 模块:学生 业务操作类型:新增
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StuStudent stuStudent)
    {
        return toAjax(stuStudentService.insertStuStudent(stuStudent));// 响应返回结果: return rows > 0 ? success() : error();
    }

    /**
     * 修改学生
     */
    @RequiresPermissions("system:student:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        StuStudent stuStudent = stuStudentService.selectStuStudentById(id);
        mmap.put("stuStudent", stuStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuStudent stuStudent)
    {
        return toAjax(stuStudentService.updateStuStudent(stuStudent));
    }

    /**
     * 删除学生
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stuStudentService.deleteStuStudentByIds(ids));
    }
}

