package com.mogujie.gmallapi.pojo.multidata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 10:32
 * 首页渲染图
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class ShowMsg {
    private String acm;
    private Integer height;
    private Integer height923;
    private String  image;
    private String image923;
    private String link;
    private String title;
    private String width;
    private String width923;
}
