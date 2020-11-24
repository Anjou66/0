package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wodehuati {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String huatimingcheng;	private String yonghucheng;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getHuatimingcheng() {
        return huatimingcheng;
    }
    public void setHuatimingcheng(String huatimingcheng) {
        this.huatimingcheng = huatimingcheng == null ? null : huatimingcheng.trim();
    }	public String getYonghucheng() {
        return yonghucheng;
    }
    public void setYonghucheng(String yonghucheng) {
        this.yonghucheng = yonghucheng == null ? null : yonghucheng.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
