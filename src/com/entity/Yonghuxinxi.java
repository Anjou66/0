﻿package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Yonghuxinxi {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String yonghucheng;
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYonghucheng() {
        return yonghucheng;
    }
    public void setYonghucheng(String yonghucheng) {
        this.yonghucheng = yonghucheng == null ? null : yonghucheng.trim();
    }
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }
        return touxiang;
    }
    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang == null ? null : touxiang.trim();
    }
        return shouji;
    }
    public void setShouji(String shouji) {
        this.shouji = shouji == null ? null : shouji.trim();
    }
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang == null ? null : youxiang.trim();
    }
        return chushengriqi;
    }
    public void setChushengriqi(String chushengriqi) {
        this.chushengriqi = chushengriqi == null ? null : chushengriqi.trim();
    }
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息