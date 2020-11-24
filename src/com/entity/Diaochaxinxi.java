package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diaochaxinxi {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String diaochabianhao;	private String huatimingcheng;	private String diaochamingcheng;	private String canyurenshu;	private String diaochazhi;	private String zongzhi;	private String gongsibianhao;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getDiaochabianhao() {
        return diaochabianhao;
    }
    public void setDiaochabianhao(String diaochabianhao) {
        this.diaochabianhao = diaochabianhao == null ? null : diaochabianhao.trim();
    }	public String getHuatimingcheng() {
        return huatimingcheng;
    }
    public void setHuatimingcheng(String huatimingcheng) {
        this.huatimingcheng = huatimingcheng == null ? null : huatimingcheng.trim();
    }	public String getDiaochamingcheng() {
        return diaochamingcheng;
    }
    public void setDiaochamingcheng(String diaochamingcheng) {
        this.diaochamingcheng = diaochamingcheng == null ? null : diaochamingcheng.trim();
    }	public String getCanyurenshu() {
        return canyurenshu;
    }
    public void setCanyurenshu(String canyurenshu) {
        this.canyurenshu = canyurenshu == null ? null : canyurenshu.trim();
    }	public String getDiaochazhi() {
        return diaochazhi;
    }
    public void setDiaochazhi(String diaochazhi) {
        this.diaochazhi = diaochazhi == null ? null : diaochazhi.trim();
    }	public String getZongzhi() {
        return zongzhi;
    }
    public void setZongzhi(String zongzhi) {
        this.zongzhi = zongzhi == null ? null : zongzhi.trim();
    }	public String getGongsibianhao() {
        return gongsibianhao;
    }
    public void setGongsibianhao(String gongsibianhao) {
        this.gongsibianhao = gongsibianhao == null ? null : gongsibianhao.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
