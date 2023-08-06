package com.ruoyi.shoot.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 拍摄信息对象 shoot_msg
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public class ShootMsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long photoId;

    /** 主题 */
    @Excel(name = "主题")
    private String title;

    /** 拍摄名称 */
    @Excel(name = "拍摄名称")
    private String shootName;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 拍摄类型 */
    @Excel(name = "拍摄类型")
    private String shootType;

    /** 拍摄设备 */
    @Excel(name = "拍摄设备")
    private String shootEquipment;

    /** 拍摄地点 */
    @Excel(name = "拍摄地点")
    private String shootLocation;

    /** 是否删除 */
    private Integer isDelete;

    /** 拍摄日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拍摄日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shootDate;

    public void setPhotoId(Long photoId) 
    {
        this.photoId = photoId;
    }

    public Long getPhotoId() 
    {
        return photoId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setShootName(String shootName) 
    {
        this.shootName = shootName;
    }

    public String getShootName() 
    {
        return shootName;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setShootType(String shootType) 
    {
        this.shootType = shootType;
    }

    public String getShootType() 
    {
        return shootType;
    }
    public void setShootEquipment(String shootEquipment) 
    {
        this.shootEquipment = shootEquipment;
    }

    public String getShootEquipment() 
    {
        return shootEquipment;
    }
    public void setShootLocation(String shootLocation) 
    {
        this.shootLocation = shootLocation;
    }

    public String getShootLocation() 
    {
        return shootLocation;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }
    public void setShootDate(Date shootDate) 
    {
        this.shootDate = shootDate;
    }

    public Date getShootDate() 
    {
        return shootDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("photoId", getPhotoId())
            .append("title", getTitle())
            .append("shootName", getShootName())
            .append("description", getDescription())
            .append("shootType", getShootType())
            .append("shootEquipment", getShootEquipment())
            .append("shootLocation", getShootLocation())
            .append("isDelete", getIsDelete())
            .append("remark", getRemark())
            .append("shootDate", getShootDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
