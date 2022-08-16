package com.ruoyi.system.service;


import com.ruoyi.system.domain.StuStudent;

import java.util.List;

/**
 * 学生Service接口
 *
 * @author feiying
 * @date 2022-08-01
 */
public interface IStuStudentService
{
    /**
     * 查询学生
     *
     * @param id 学生主键
     * @return 学生
     */
    StuStudent selectStuStudentById(Integer id);

    /**
     * 查询学生列表
     *
     * @param stuStudent 学生
     * @return 学生集合
     */
    List<StuStudent> selectStuStudentList(StuStudent stuStudent);

    /**
     * 新增学生
     *
     * @param stuStudent 学生
     * @return 结果
     */
    int insertStuStudent(StuStudent stuStudent);

    /**
     * 修改学生
     *
     * @param stuStudent 学生
     * @return 结果
     */
    int updateStuStudent(StuStudent stuStudent);

    /**
     * 批量删除学生
     *
     * @param ids 需要删除的学生主键集合
     * @return 结果
     */
    int deleteStuStudentByIds(String ids);

    /**
     * 删除学生信息
     *
     * @param id 学生主键
     * @return 结果
     */
    int deleteStuStudentById(Integer id);
}

