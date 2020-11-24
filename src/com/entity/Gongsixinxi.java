package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gongsixinxi {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String gongsibianhao;	private String mima;	private String youxiang;	private String gongsimingcheng;	private String leixing;	private String xingye;	private String guimo;	private String jianjie;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGongsibianhao() {
        return gongsibianhao;
    }
    public void setGongsibianhao(String gongsibianhao) {
        this.gongsibianhao = gongsibianhao == null ? null : gongsibianhao.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getYouxiang() {
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang == null ? null : youxiang.trim();
    }	public String getGongsimingcheng() {
        return gongsimingcheng;
    }
    public void setGongsimingcheng(String gongsimingcheng) {
        this.gongsimingcheng = gongsimingcheng == null ? null : gongsimingcheng.trim();
    }	public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }	public String getXingye() {
        return xingye;
    }
    public void setXingye(String xingye) {
        this.xingye = xingye == null ? null : xingye.trim();
    }	public String getGuimo() {
        return guimo;
    }
    public void setGuimo(String guimo) {
        this.guimo = guimo == null ? null : guimo.trim();
    }	public String getJianjie() {
        return jianjie;
    }
    public void setJianjie(String jianjie) {
        this.jianjie = jianjie == null ? null : jianjie.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
