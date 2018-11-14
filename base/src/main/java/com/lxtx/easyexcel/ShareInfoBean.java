package com.lxtx.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareInfoBean extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String name;

}
