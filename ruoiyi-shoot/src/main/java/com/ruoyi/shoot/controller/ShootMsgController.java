package com.ruoyi.shoot.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shoot.domain.ShootMsg;
import com.ruoyi.shoot.service.IShootMsgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拍摄信息Controller
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
@RestController
@RequestMapping("/shoot_msg/shoot")
public class ShootMsgController extends BaseController
{
    @Autowired
    private IShootMsgService shootMsgService;

    /**
     * 查询拍摄信息列表
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShootMsg shootMsg)
    {
        startPage();
        List<ShootMsg> list = shootMsgService.selectShootMsgList(shootMsg);
        return getDataTable(list);
    }

    /**
     * 导出拍摄信息列表
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:export')")
    @Log(title = "拍摄信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShootMsg shootMsg)
    {
        List<ShootMsg> list = shootMsgService.selectShootMsgList(shootMsg);
        ExcelUtil<ShootMsg> util = new ExcelUtil<ShootMsg>(ShootMsg.class);
        util.exportExcel(response, list, "拍摄信息数据");
    }

    /**
     * 获取拍摄信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:query')")
    @GetMapping(value = "/{photoId}")
    public AjaxResult getInfo(@PathVariable("photoId") Long photoId)
    {
        return success(shootMsgService.selectShootMsgByPhotoId(photoId));
    }

    /**
     * 新增拍摄信息
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:add')")
    @Log(title = "拍摄信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShootMsg shootMsg)
    {
        return toAjax(shootMsgService.insertShootMsg(shootMsg));
    }

    /**
     * 修改拍摄信息
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:edit')")
    @Log(title = "拍摄信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShootMsg shootMsg)
    {
        return toAjax(shootMsgService.updateShootMsg(shootMsg));
    }

    /**
     * 删除拍摄信息
     */
    @PreAuthorize("@ss.hasPermi('shoot_msg:shoot:remove')")
    @Log(title = "拍摄信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{photoIds}")
    public AjaxResult remove(@PathVariable Long[] photoIds)
    {
        return toAjax(shootMsgService.deleteShootMsgByPhotoIds(photoIds));
    }
}
