package com.mogujie.gmallapi.pojo.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author WN
 * @date 2020/7/9 17:56
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Test {
    private String userName;
    private String userAge;
    private List<Banners> showBanners;
    private List<Commonands> showCommonands;
}
