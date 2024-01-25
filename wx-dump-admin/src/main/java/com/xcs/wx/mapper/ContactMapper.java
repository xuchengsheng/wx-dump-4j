package com.xcs.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcs.wx.domain.Contact;
import com.xcs.wx.domain.dto.ContactDTO;
import com.xcs.wx.domain.vo.ContactVO;
import com.xcs.wx.domain.vo.ExportContactVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 联系人 Mapper
 *
 * @author xcs
 * @date 2023年12月22日 13时51分
 **/
public interface ContactMapper extends BaseMapper<Contact> {

    /**
     * 查询联系人
     *
     * @param page       分页信息
     * @param contactDTO 联系人
     * @return Contact
     */
    Page<ContactVO> queryContact(Page<ContactVO> page, @Param("contactDTO") ContactDTO contactDTO);

    /**
     * 统计联系人数量
     *
     * @return
     */
    int countContact();

    /**
     * 导出联系人
     *
     * @return ExportContactVO
     */
    List<ExportContactVO> exportContact();
}
