package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diaochaxuanxiang {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String biaoti;	private String xuanxiangA;	private String xuanxiangB;	private String xuanxiangC;	private String daan;	private String diaochabianhao;	private String gongsibianhao;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getXuanxiangA() {
        return xuanxiangA;
    }
    public void setXuanxiangA(String xuanxiangA) {
        this.xuanxiangA = xuanxiangA == null ? null : xuanxiangA.trim();
    }	public String getXuanxiangB() {
        return xuanxiangB;
    }
    public void setXuanxiangB(String xuanxiangB) {
        this.xuanxiangB = xuanxiangB == null ? null : xuanxiangB.trim();
    }	public String getXuanxiangC() {
        return xuanxiangC;
    }
    public void setXuanxiangC(String xuanxiangC) {
        this.xuanxiangC = xuanxiangC == null ? null : xuanxiangC.trim();
    }	public String getDaan() {
        return daan;
    }
    public void setDaan(String daan) {
        this.daan = daan == null ? null : daan.trim();
    }	public String getDiaochabianhao() {
        return diaochabianhao;
    }
    public void setDiaochabianhao(String diaochabianhao) {
        this.diaochabianhao = diaochabianhao == null ? null : diaochabianhao.trim();
    }	public String getGongsibianhao() {
        return gongsibianhao;
    }
    public void setGongsibianhao(String gongsibianhao) {
        this.gongsibianhao = gongsibianhao == null ? null : gongsibianhao.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
