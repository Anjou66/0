package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Yonghuxinxi {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String yonghucheng;	private String mima;	private String touxiang;	private String shouji;	private String youxiang;	private String chushengriqi;	private String xingbie;	
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
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getTouxiang() {
        return touxiang;
    }
    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang == null ? null : touxiang.trim();
    }	public String getShouji() {
        return shouji;
    }
    public void setShouji(String shouji) {
        this.shouji = shouji == null ? null : shouji.trim();
    }	public String getYouxiang() {
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang == null ? null : youxiang.trim();
    }	public String getChushengriqi() {
        return chushengriqi;
    }
    public void setChushengriqi(String chushengriqi) {
        this.chushengriqi = chushengriqi == null ? null : chushengriqi.trim();
    }	public String getXingbie() {
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
