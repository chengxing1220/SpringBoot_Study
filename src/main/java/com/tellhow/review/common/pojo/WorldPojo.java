package com.tellhow.review.common.pojo;

import com.tellhow.review.common.pojo.AvenueBranchPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author wujianghao
 * @date 2022年10月27日 15:19
 * WorldPojo:传武世界
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorldPojo {
    private String wId;//此方世界的编号
    private String name;//此方世界的名称
    private List<AvenueBranchPojo> avenueBranch;//此方世界所孕育道的分支
}
