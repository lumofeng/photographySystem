package com.ruoyi.shoot.service;

import java.util.List;
import com.ruoyi.shoot.domain.ShootMsg;

/**
 * 拍摄信息Service接口
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public interface IShootMsgService 
{
    /**
     * 查询拍摄信息
     * 
     * @param photoId 拍摄信息主键
     * @return 拍摄信息
     */
    public ShootMsg selectShootMsgByPhotoId(Long photoId);

    /**
     * 查询拍摄信息列表
     * 
     * @param shootMsg 拍摄信息
     * @return 拍摄信息集合
     */
    public List<ShootMsg> selectShootMsgList(ShootMsg shootMsg);

    /**
     * 新增拍摄信息
     * 
     * @param shootMsg 拍摄信息
     * @return 结果
     */
    public int insertShootMsg(ShootMsg shootMsg);

    /**
     * 修改拍摄信息
     * 
     * @param shootMsg 拍摄信息
     * @return 结果
     */
    public int updateShootMsg(ShootMsg shootMsg);

    /**
     * 批量删除拍摄信息
     * 
     * @param photoIds 需要删除的拍摄信息主键集合
     * @return 结果
     */
    public int deleteShootMsgByPhotoIds(Long[] photoIds);

    /**
     * 删除拍摄信息信息
     * 
     * @param photoId 拍摄信息主键
     * @return 结果
     */
    public int deleteShootMsgByPhotoId(Long photoId);
}
