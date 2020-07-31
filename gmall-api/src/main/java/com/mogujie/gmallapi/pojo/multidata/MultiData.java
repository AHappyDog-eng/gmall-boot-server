package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 10:25
 * 首页数据集合
 */
@lombok.Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class MultiData {
    private Data data;
}
