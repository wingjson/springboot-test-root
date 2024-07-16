package com.zja.postgis.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.MultiPolygon;

import java.io.Serializable;

/**
 * 多边形集合 请求参数
 * @author: zhengja
 * @since: 2024/07/15 15:19
 */
@Data
@ApiModel("MultiPolygonRequest 新增 或 更新 多边形集合信息")
public class MultiPolygonRequest implements Serializable {

    @ApiModelProperty("多边形集合名称")
    private String name;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("点集合")
    private MultiPolygon multiPolygon;
}