package com.jsen17.commons.func;

/**
 * 转化接口
 *
 * @author HuSen
 * @since 2022/5/27 3:43 PM
 */
public interface Transform<DTO, PO> {

    /**
     * DTO转PO
     *
     * @param dto 传输数据模型
     * @return 持久化模型
     */
    PO dto2Po(DTO dto);

    /**
     * PO转DTO
     *
     * @param po 持久化模型
     * @return 传输数据模型
     */
    DTO po2Dto(PO po);
}
