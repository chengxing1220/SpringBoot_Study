package com.tellhow.review.spring_xml.pojo;

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
    private String name;//世界的名称
    private List<AvenueBranchPojo> avenueBranch;//此方世界道的分支
}
