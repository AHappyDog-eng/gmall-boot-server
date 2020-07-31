package com.mogujie.gmallapi.pojo.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author WN
 * @date 2020/7/10 11:26
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class TestB {
    private Integer testBId;
    private String testBName;
    private TestD testD;
}
