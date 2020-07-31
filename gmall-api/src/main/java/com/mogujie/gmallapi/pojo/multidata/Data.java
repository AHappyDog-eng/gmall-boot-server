package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 10:27
 */
@lombok.Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Data {
    private Banner banner;
    private DkeyWord dkeyWord;
    private KeyWord keyWord;
    private Recommend recommend;
}
