package com.mogujie.gmallapi.pojo.ossoperator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/31 9:16
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class OssOperator {
    private Integer id;
    private String imgUrl;
}
