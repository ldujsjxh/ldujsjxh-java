package com.ldujsjxh.mapper.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.vo.interview.IntervieweeInfoVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 15:20
 * @Version 1.0
 * @Description
 */

public interface InterviewerMapper {

    /**
     * 获取某个部门的所有报名者信息
     * @param department
     * @return
     */
    @Select("SELECT candidate_id, candidate_name, candidate_stu_id, " +
            "candidate_academy, desirable_department, state, score, candidate_obey_adjust\n" +
            "FROM candidates c \n" +
            "where desirable_department = #{department} ")
    List<IntervieweeInfoVo> getCandidateByDepartment(String department);

    /**
     * 获取某个报名者的详细信息
     * @param candidateId
     * @return
     */
    @Select("SELECT * \n" +
            "FROM candidates c \n" +
            "where candidate_id = #{candidateId}")
    CandidateBean getandidateDetailById(String candidateId);

    /**
     * 将原先的面试和等候的人的state+1
     */
    @Update("UPDATE candidates set state = state + 1 \n" +
            "WHERE  state = 1 \n" +
            "\tor state = 2")
    void setOldCandidateState();

    /**
     * 设置新的等候人
     * @param candidateId
     */
    @Update("UPDATE candidates set state = 1\n" +
            "WHERE candidate_id = #{candidateId}")
    void setNewCondidateState(String candidateId);

    /**
     * 根据id获取学生的分数
     * @param candidateId
     * @return
     */
    @Select("select score from candidates where candidate_id = #{candidateId}")
    String getScoreById(String candidateId);


    /**
     * 更新面试评分
     * @param candidateId
     */
    @Update("UPDATE candidates set score = #{scoreStr}\n" +
            "WHERE candidate_id = #{candidateId}")
    void updateScoreById(String candidateId, String scoreStr);

    /**
     * 根据id删除报名者个人信息
     * @param candidateId
     */
    @Delete("delete FROM candidates \n" +
            "where candidate_id = #{candidateId}")
    void deleteCandidateById(int candidateId);
}
