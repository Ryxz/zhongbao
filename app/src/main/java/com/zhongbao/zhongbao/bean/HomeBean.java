package com.zhongbao.zhongbao.bean;

import java.util.List;

public class HomeBean {
    private List<GoodsDetailBean> list;

    private List<LunboBean> lunbo;

    private List<PriseBean> prise;


    public List<GoodsDetailBean> getList() {
        return list;
    }

    public void setList(List<GoodsDetailBean> list) {
        this.list = list;
    }

    public List<LunboBean> getLunbo() {
        return lunbo;
    }

    public void setLunbo(List<LunboBean> lunbo) {
        this.lunbo = lunbo;
    }

    public List<PriseBean> getPrise() {
        return prise;
    }

    public void setPrise(List<PriseBean> prise) {
        this.prise = prise;
    }
}
