package com.tellhow.review.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wujianghao
 * @date 2022年10月27日 15:24
 * AvenueBranchPojo:道的分支
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvenueBranchPojo {
    private String worldId;//道所属世界的编号
    private String avenueName;//道的名称
    private String avenueId;//道的编号
    private List<UnitedPojo> unitedPojoList;//修习此道的门派
}
