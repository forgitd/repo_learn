package com.keqi.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author keqi
 * @since 2021-07-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "主键ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "姓名")
      private String name;

      @ApiModelProperty(value = "年龄")
      private Integer age;

      @ApiModelProperty(value = "邮箱")
      private String email;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;

      @TableField(fill = FieldFill.INSERT)
      private Date creatTime;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
