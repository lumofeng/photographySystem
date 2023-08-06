package com.ruoyi.shoot.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shoot.mapper.ShootMsgMapper;
import com.ruoyi.shoot.domain.ShootMsg;
import com.ruoyi.shoot.service.IShootMsgService;

/**
 * 拍摄信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
@Service
public class ShootMsgServiceImpl implements IShootMsgService 
{
    @Autowired
    private ShootMsgMapper shootMsgMapper;

    /**
     * 查询拍摄信息
     * 
     * @param photoId 拍摄信息主键
     * @return 拍摄信息
     */
    @Override
    public ShootMsg selectShootMsgByPhotoId(Long photoId)
    {
        return shootMsgMapper.selectShootMsgByPhotoId(photoId);
    }

    /**
     * 查询拍摄信息列表
     * 
     * @param shootMsg 拍摄信息
     * @return 拍摄信息
     */
    @Override
    public List<ShootMsg> selectShootMsgList(ShootMsg shootMsg)
    {
        return shootMsgMapper.selectShootMsgList(shootMsg);
    }

    /**
     * 新增拍摄信息
     * 
     * @param shootMsg 拍摄信息
     * @return 结果
     */
    @Override
    public int insertShootMsg(ShootMsg shootMsg)
    {
        shootMsg.setCreateTime(DateUtils.getNowDate());
        return shootMsgMapper.insertShootMsg(shootMsg);
    }

    /**
     * 修改拍摄信息
     * 
     * @param shootMsg 拍摄信息
     * @return 结果
     */
    @Override
    public int updateShootMsg(ShootMsg shootMsg)
    {
        shootMsg.setUpdateTime(DateUtils.getNowDate());
        return shootMsgMapper.updateShootMsg(shootMsg);
    }

    /**
     * 批量删除拍摄信息
     * 
     * @param photoIds 需要删除的拍摄信息主键
     * @return 结果
     */
    @Override
    public int deleteShootMsgByPhotoIds(Long[] photoIds)
    {
        return shootMsgMapper.deleteShootMsgByPhotoIds(photoIds);
    }

    /**
     * 删除拍摄信息信息
     * 
     * @param photoId 拍摄信息主键
     * @return 结果
     */
    @Override
    public int deleteShootMsgByPhotoId(Long photoId)
    {
        return shootMsgMapper.deleteShootMsgByPhotoId(photoId);
    }
}
