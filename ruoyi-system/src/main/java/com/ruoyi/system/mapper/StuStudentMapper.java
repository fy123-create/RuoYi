package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.StuStudent;

import java.util.List;

/**
 * 学生Mapper接口
 *
 * @author feiying
 * @date 2022-08-01
 */
public interface StuStudentMapper
{
    /**
     * 查询学生
     *
     * @param id 学生主键
     * @return 学生
     */
    public StuStudent selectStuStudentById(Integer id);

    /**
     * 查询学生列表
     *
     * @param stuStudent 学生
     * @return 学生集合
     */
    public List<StuStudent> selectStuStudentList(StuStudent stuStudent);

    /**
     * 新增学生
     *
     * @param stuStudent 学生
     * @return 结果
     */
    public int insertStuStudent(StuStudent stuStudent);

    /**
     * 修改学生
     *
     * @param stuStudent 学生
     * @return 结果
     */
    public int updateStuStudent(StuStudent stuStudent);

    /**
     * 删除学生
     *
     * @param id 学生主键
     * @return 结果
     */
    public int deleteStuStudentById(Integer id);

    /**
     * 批量删除学生
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuStudentByIds(String[] ids);
}

