package com.mogujie.gmallprovider8001.enums;

/**
 * @author WN
 * @date 2020/7/31 9:31
 */
public enum ResponseEnum {
    /**
     * 操作成功
     */
    SUCCESS(200),
    /**
     * 文件上传失败
     */
    UPLOAD_ERROR(50001),
    /**
     * 文件核查不通过，为空或者是参数输入不标注
     */
    PARAM_ERROR(50002)
    ;

    ResponseEnum(Integer val) {
        this.val = val;
    }

    private Integer val;


    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
