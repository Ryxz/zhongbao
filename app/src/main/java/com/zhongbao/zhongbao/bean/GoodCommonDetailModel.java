package com.zhongbao.zhongbao.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class GoodCommonDetailModel implements Parcelable {
    private String gid;//"1",
    private String goods_commonid;//"1",
    private String goods_name;//"南疆名酒",
    private String goods_jingle;//"脑in动脑你完蛋了烂掉",
    private String vid;//"241",
    private String store_name;//"立度烟酒",
    private String gc_id;//"4",
    private String gc_id_1;//"0",
    private String gc_id_2;//"国产白酒",
    private String gc_id_3;//null,
    private String brand_id;//null,
    private double goods_price;//"100.00",
    private double goods_costprice;//"100.00",
    private String goods_promotion_type;//"0",
    private String goods_marketprice;//"0.00",
    private String goods_serial;//"",
    private String goods_storage_alarm;//"0",
    private String goods_click;//"0",
    private String goods_salenum;//"19",
    private String goods_collect;//"0",
    private String goods_spec;//"0",
    private String goods_storage;//"960",
    private String goods_image;//"\/Uploads\/2018-06-14\/5b2203c477453.jpg",
    private String goods_state;//"1",
    private String goods_verify;//"0",
    private String goods_addtime;//"0",
    private String goods_edittime;//"0",
    private String areaid_1;//"0",
    private String areaid_2;//"0",
    private String color_id;//"0",
    private String transport_id;//"0",
    private double goods_freight;//"100.00",
    private String goods_vat;//"0",
    private String goods_commend;//"1",
    private String goods_stcids;//"",
    private String evaluation_good_star;//"5.0",
    private String evaluation_count;//"0",
    private String old_vid;//null,
    private String old_gid;//"0",
    private String is_virtual;//"0",
    private String virtual_indate;//"0",
    private String virtual_limit;//"0",
    private String virtual_invalid_refund;//"1",
    private String is_fcode;//"0",
    private String is_appoint;//"0",
    private String is_presell;//"0",
    private String have_gift;//"0",
    private String is_own_shop;//"0",
    private String goods_rebate;//"100",
    private String goods_barcode;//"",
    private String fenxiao_yongjin;//"100.00",
    private String integral;//"0",
    private String integral_zs;//"100",
    private String quality;//null,
    private String sort;//"1",
    private List<String> goods_content;//["\/Uploads\/2018-06-14\/5b2203da5fd8c.jpg", "\/Uploads\/2018-06-14\/5b22042413ce1.jpg"],
    private String virtual_price;//"100",
    private String type_name;//"浓香",
    private String du_num;//"39",
    private String pin_name;//"五粮液",
    private String liang_num;//"其他",
    private String goods_ifpoint;//"0",
    private String goods_level;//"特级",
    private String goods_shen;//"陕西",
    private String goods_guige;//"礼盒装",
    private String goods_shouhou;//"1212",
    private String shop_type;//"1",
    private String goods_zxjg;//"100.000",
    private String goods_zxsl;//"100",
    private String goods_xuni_state;//"1",
    private String goods_cha_zhuan;//"0.30",
    private String xianshi_price;//null,
    private String praise_rate;//"0",
    private String evaluation;//1,
    private boolean is_favorate;//false,
    private List<CartDataModel> cart_list_data;//null,
    private List<GoodsCommend> goods_commend_list;//[],
    private List<GevalModel> geval_list;//[{
    private String store_avatar;//"\/Uploads\/2018-04-20\/5ad9986784ca3.png",
    private String store_credit;//"5"
    private double peisong;
    private ArrayList<QuanModel> quan_data;
    /**
     * goods_price : 258.00
     * goods_costprice : 258.00
     * goods_freight : 9.00
     * juli : 7068745
     */

    public GoodCommonDetailModel(){

    }

    private String juli;

    protected GoodCommonDetailModel(Parcel in) {
        gid = in.readString();
        goods_commonid = in.readString();
        goods_name = in.readString();
        goods_jingle = in.readString();
        vid = in.readString();
        store_name = in.readString();
        gc_id = in.readString();
        gc_id_1 = in.readString();
        gc_id_2 = in.readString();
        gc_id_3 = in.readString();
        brand_id = in.readString();
        goods_price = in.readDouble();
        goods_costprice = in.readDouble();
        goods_promotion_type = in.readString();
        goods_marketprice = in.readString();
        goods_serial = in.readString();
        goods_storage_alarm = in.readString();
        goods_click = in.readString();
        goods_salenum = in.readString();
        goods_collect = in.readString();
        goods_spec = in.readString();
        goods_storage = in.readString();
        goods_image = in.readString();
        goods_state = in.readString();
        goods_verify = in.readString();
        goods_addtime = in.readString();
        goods_edittime = in.readString();
        areaid_1 = in.readString();
        areaid_2 = in.readString();
        color_id = in.readString();
        transport_id = in.readString();
        goods_freight = in.readDouble();
        goods_vat = in.readString();
        goods_commend = in.readString();
        goods_stcids = in.readString();
        evaluation_good_star = in.readString();
        evaluation_count = in.readString();
        old_vid = in.readString();
        old_gid = in.readString();
        is_virtual = in.readString();
        virtual_indate = in.readString();
        virtual_limit = in.readString();
        virtual_invalid_refund = in.readString();
        is_fcode = in.readString();
        is_appoint = in.readString();
        is_presell = in.readString();
        have_gift = in.readString();
        is_own_shop = in.readString();
        goods_rebate = in.readString();
        goods_barcode = in.readString();
        fenxiao_yongjin = in.readString();
        integral = in.readString();
        integral_zs = in.readString();
        quality = in.readString();
        sort = in.readString();
        goods_content = in.createStringArrayList();
        virtual_price = in.readString();
        type_name = in.readString();
        du_num = in.readString();
        pin_name = in.readString();
        liang_num = in.readString();
        goods_ifpoint = in.readString();
        goods_level = in.readString();
        goods_shen = in.readString();
        goods_guige = in.readString();
        goods_shouhou = in.readString();
        shop_type = in.readString();
        goods_zxjg = in.readString();
        goods_zxsl = in.readString();
        goods_xuni_state = in.readString();
        goods_cha_zhuan = in.readString();
        xianshi_price = in.readString();
        praise_rate = in.readString();
        evaluation = in.readString();
        is_favorate = in.readByte() != 0;
        store_avatar = in.readString();
        store_credit = in.readString();
        peisong = in.readDouble();
        quan_data = in.createTypedArrayList(QuanModel.CREATOR);
        juli = in.readString();
    }

    public static final Creator<GoodCommonDetailModel> CREATOR = new Creator<GoodCommonDetailModel>() {
        @Override
        public GoodCommonDetailModel createFromParcel(Parcel in) {
            return new GoodCommonDetailModel(in);
        }

        @Override
        public GoodCommonDetailModel[] newArray(int size) {
            return new GoodCommonDetailModel[size];
        }
    };

    public ArrayList<QuanModel> getQuan_data() {
        return quan_data;
    }

    public void setQuan_data(ArrayList<QuanModel> quan_data) {
        this.quan_data = quan_data;
    }

    public double getPeisong() {
        return peisong;
    }

    public void setPeisong(double peisong) {
        this.peisong = peisong;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGoods_commonid() {
        return goods_commonid;
    }

    public void setGoods_commonid(String goods_commonid) {
        this.goods_commonid = goods_commonid;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_jingle() {
        return goods_jingle;
    }

    public void setGoods_jingle(String goods_jingle) {
        this.goods_jingle = goods_jingle;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getGc_id() {
        return gc_id;
    }

    public void setGc_id(String gc_id) {
        this.gc_id = gc_id;
    }

    public String getGc_id_1() {
        return gc_id_1;
    }

    public void setGc_id_1(String gc_id_1) {
        this.gc_id_1 = gc_id_1;
    }

    public String getGc_id_2() {
        return gc_id_2;
    }

    public void setGc_id_2(String gc_id_2) {
        this.gc_id_2 = gc_id_2;
    }

    public String getGc_id_3() {
        return gc_id_3;
    }

    public void setGc_id_3(String gc_id_3) {
        this.gc_id_3 = gc_id_3;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public double getGoods_costprice() {
        return goods_costprice;
    }

    public void setGoods_costprice(double goods_costprice) {
        this.goods_costprice = goods_costprice;
    }

    public String getGoods_promotion_type() {
        return goods_promotion_type;
    }

    public void setGoods_promotion_type(String goods_promotion_type) {
        this.goods_promotion_type = goods_promotion_type;
    }

    public String getGoods_marketprice() {
        return goods_marketprice;
    }

    public void setGoods_marketprice(String goods_marketprice) {
        this.goods_marketprice = goods_marketprice;
    }

    public String getGoods_serial() {
        return goods_serial;
    }

    public void setGoods_serial(String goods_serial) {
        this.goods_serial = goods_serial;
    }

    public String getGoods_storage_alarm() {
        return goods_storage_alarm;
    }

    public void setGoods_storage_alarm(String goods_storage_alarm) {
        this.goods_storage_alarm = goods_storage_alarm;
    }

    public String getGoods_click() {
        return goods_click;
    }

    public void setGoods_click(String goods_click) {
        this.goods_click = goods_click;
    }

    public String getGoods_salenum() {
        return goods_salenum;
    }

    public void setGoods_salenum(String goods_salenum) {
        this.goods_salenum = goods_salenum;
    }

    public String getGoods_collect() {
        return goods_collect;
    }

    public void setGoods_collect(String goods_collect) {
        this.goods_collect = goods_collect;
    }

    public String getGoods_spec() {
        return goods_spec;
    }

    public void setGoods_spec(String goods_spec) {
        this.goods_spec = goods_spec;
    }

    public String getGoods_storage() {
        return goods_storage;
    }

    public void setGoods_storage(String goods_storage) {
        this.goods_storage = goods_storage;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public String getGoods_state() {
        return goods_state;
    }

    public void setGoods_state(String goods_state) {
        this.goods_state = goods_state;
    }

    public String getGoods_verify() {
        return goods_verify;
    }

    public void setGoods_verify(String goods_verify) {
        this.goods_verify = goods_verify;
    }

    public String getGoods_addtime() {
        return goods_addtime;
    }

    public void setGoods_addtime(String goods_addtime) {
        this.goods_addtime = goods_addtime;
    }

    public String getGoods_edittime() {
        return goods_edittime;
    }

    public void setGoods_edittime(String goods_edittime) {
        this.goods_edittime = goods_edittime;
    }

    public String getAreaid_1() {
        return areaid_1;
    }

    public void setAreaid_1(String areaid_1) {
        this.areaid_1 = areaid_1;
    }

    public String getAreaid_2() {
        return areaid_2;
    }

    public void setAreaid_2(String areaid_2) {
        this.areaid_2 = areaid_2;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(String transport_id) {
        this.transport_id = transport_id;
    }

    public double getGoods_freight() {
        return goods_freight;
    }

    public void setGoods_freight(double goods_freight) {
        this.goods_freight = goods_freight;
    }

    public String getGoods_vat() {
        return goods_vat;
    }

    public void setGoods_vat(String goods_vat) {
        this.goods_vat = goods_vat;
    }

    public String getGoods_commend() {
        return goods_commend;
    }

    public void setGoods_commend(String goods_commend) {
        this.goods_commend = goods_commend;
    }

    public String getGoods_stcids() {
        return goods_stcids;
    }

    public void setGoods_stcids(String goods_stcids) {
        this.goods_stcids = goods_stcids;
    }

    public String getEvaluation_good_star() {
        return evaluation_good_star;
    }

    public void setEvaluation_good_star(String evaluation_good_star) {
        this.evaluation_good_star = evaluation_good_star;
    }

    public String getEvaluation_count() {
        return evaluation_count;
    }

    public void setEvaluation_count(String evaluation_count) {
        this.evaluation_count = evaluation_count;
    }

    public String getOld_vid() {
        return old_vid;
    }

    public void setOld_vid(String old_vid) {
        this.old_vid = old_vid;
    }

    public String getOld_gid() {
        return old_gid;
    }

    public void setOld_gid(String old_gid) {
        this.old_gid = old_gid;
    }

    public String getIs_virtual() {
        return is_virtual;
    }

    public void setIs_virtual(String is_virtual) {
        this.is_virtual = is_virtual;
    }

    public String getVirtual_indate() {
        return virtual_indate;
    }

    public void setVirtual_indate(String virtual_indate) {
        this.virtual_indate = virtual_indate;
    }

    public String getVirtual_limit() {
        return virtual_limit;
    }

    public void setVirtual_limit(String virtual_limit) {
        this.virtual_limit = virtual_limit;
    }

    public String getVirtual_invalid_refund() {
        return virtual_invalid_refund;
    }

    public void setVirtual_invalid_refund(String virtual_invalid_refund) {
        this.virtual_invalid_refund = virtual_invalid_refund;
    }

    public String getIs_fcode() {
        return is_fcode;
    }

    public void setIs_fcode(String is_fcode) {
        this.is_fcode = is_fcode;
    }

    public String getIs_appoint() {
        return is_appoint;
    }

    public void setIs_appoint(String is_appoint) {
        this.is_appoint = is_appoint;
    }

    public String getIs_presell() {
        return is_presell;
    }

    public void setIs_presell(String is_presell) {
        this.is_presell = is_presell;
    }

    public String getHave_gift() {
        return have_gift;
    }

    public void setHave_gift(String have_gift) {
        this.have_gift = have_gift;
    }

    public String getIs_own_shop() {
        return is_own_shop;
    }

    public void setIs_own_shop(String is_own_shop) {
        this.is_own_shop = is_own_shop;
    }

    public String getGoods_rebate() {
        return goods_rebate;
    }

    public void setGoods_rebate(String goods_rebate) {
        this.goods_rebate = goods_rebate;
    }

    public String getGoods_barcode() {
        return goods_barcode;
    }

    public void setGoods_barcode(String goods_barcode) {
        this.goods_barcode = goods_barcode;
    }

    public String getFenxiao_yongjin() {
        return fenxiao_yongjin;
    }

    public void setFenxiao_yongjin(String fenxiao_yongjin) {
        this.fenxiao_yongjin = fenxiao_yongjin;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getIntegral_zs() {
        return integral_zs;
    }

    public void setIntegral_zs(String integral_zs) {
        this.integral_zs = integral_zs;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getGoods_content() {
        return goods_content;
    }

    public void setGoods_content(List<String> goods_content) {
        this.goods_content = goods_content;
    }

    public String getVirtual_price() {
        return virtual_price;
    }

    public void setVirtual_price(String virtual_price) {
        this.virtual_price = virtual_price;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDu_num() {
        return du_num;
    }

    public void setDu_num(String du_num) {
        this.du_num = du_num;
    }

    public String getPin_name() {
        return pin_name;
    }

    public void setPin_name(String pin_name) {
        this.pin_name = pin_name;
    }

    public String getLiang_num() {
        return liang_num;
    }

    public void setLiang_num(String liang_num) {
        this.liang_num = liang_num;
    }

    public String getGoods_ifpoint() {
        return goods_ifpoint;
    }

    public void setGoods_ifpoint(String goods_ifpoint) {
        this.goods_ifpoint = goods_ifpoint;
    }

    public String getGoods_level() {
        return goods_level;
    }

    public void setGoods_level(String goods_level) {
        this.goods_level = goods_level;
    }

    public String getGoods_shen() {
        return goods_shen;
    }

    public void setGoods_shen(String goods_shen) {
        this.goods_shen = goods_shen;
    }

    public String getGoods_guige() {
        return goods_guige;
    }

    public void setGoods_guige(String goods_guige) {
        this.goods_guige = goods_guige;
    }

    public String getGoods_shouhou() {
        return goods_shouhou;
    }

    public void setGoods_shouhou(String goods_shouhou) {
        this.goods_shouhou = goods_shouhou;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getGoods_zxjg() {
        return goods_zxjg;
    }

    public void setGoods_zxjg(String goods_zxjg) {
        this.goods_zxjg = goods_zxjg;
    }

    public String getGoods_zxsl() {
        return goods_zxsl;
    }

    public void setGoods_zxsl(String goods_zxsl) {
        this.goods_zxsl = goods_zxsl;
    }

    public String getGoods_xuni_state() {
        return goods_xuni_state;
    }

    public void setGoods_xuni_state(String goods_xuni_state) {
        this.goods_xuni_state = goods_xuni_state;
    }

    public String getGoods_cha_zhuan() {
        return goods_cha_zhuan;
    }

    public void setGoods_cha_zhuan(String goods_cha_zhuan) {
        this.goods_cha_zhuan = goods_cha_zhuan;
    }

    public String getXianshi_price() {
        return xianshi_price;
    }

    public void setXianshi_price(String xianshi_price) {
        this.xianshi_price = xianshi_price;
    }

    public String getPraise_rate() {
        return praise_rate;
    }

    public void setPraise_rate(String praise_rate) {
        this.praise_rate = praise_rate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public boolean isIs_favorate() {
        return is_favorate;
    }

    public void setIs_favorate(boolean is_favorate) {
        this.is_favorate = is_favorate;
    }

    public List<CartDataModel> getCart_list_data() {
        return cart_list_data;
    }

    public List<GoodsCommend> getGoods_commend_list() {
        return goods_commend_list;
    }

    public void setGoods_commend_list(List<GoodsCommend> goods_commend_list) {
        this.goods_commend_list = goods_commend_list;
    }

    public List<GevalModel> getGeval_list() {
        return geval_list;
    }

    public void setGeval_list(List<GevalModel> geval_list) {
        this.geval_list = geval_list;
    }

    public String getStore_avatar() {
        return store_avatar;
    }

    public void setStore_avatar(String store_avatar) {
        this.store_avatar = store_avatar;
    }

    public String getStore_credit() {
        return store_credit;
    }

    public void setStore_credit(String store_credit) {
        this.store_credit = store_credit;
    }

    public String getJuli() {
        return juli;
    }

    public void setJuli(String juli) {
        this.juli = juli;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gid);
        parcel.writeString(goods_commonid);
        parcel.writeString(goods_name);
        parcel.writeString(goods_jingle);
        parcel.writeString(vid);
        parcel.writeString(store_name);
        parcel.writeString(gc_id);
        parcel.writeString(gc_id_1);
        parcel.writeString(gc_id_2);
        parcel.writeString(gc_id_3);
        parcel.writeString(brand_id);
        parcel.writeDouble(goods_price);
        parcel.writeDouble(goods_costprice);
        parcel.writeString(goods_promotion_type);
        parcel.writeString(goods_marketprice);
        parcel.writeString(goods_serial);
        parcel.writeString(goods_storage_alarm);
        parcel.writeString(goods_click);
        parcel.writeString(goods_salenum);
        parcel.writeString(goods_collect);
        parcel.writeString(goods_spec);
        parcel.writeString(goods_storage);
        parcel.writeString(goods_image);
        parcel.writeString(goods_state);
        parcel.writeString(goods_verify);
        parcel.writeString(goods_addtime);
        parcel.writeString(goods_edittime);
        parcel.writeString(areaid_1);
        parcel.writeString(areaid_2);
        parcel.writeString(color_id);
        parcel.writeString(transport_id);
        parcel.writeDouble(goods_freight);
        parcel.writeString(goods_vat);
        parcel.writeString(goods_commend);
        parcel.writeString(goods_stcids);
        parcel.writeString(evaluation_good_star);
        parcel.writeString(evaluation_count);
        parcel.writeString(old_vid);
        parcel.writeString(old_gid);
        parcel.writeString(is_virtual);
        parcel.writeString(virtual_indate);
        parcel.writeString(virtual_limit);
        parcel.writeString(virtual_invalid_refund);
        parcel.writeString(is_fcode);
        parcel.writeString(is_appoint);
        parcel.writeString(is_presell);
        parcel.writeString(have_gift);
        parcel.writeString(is_own_shop);
        parcel.writeString(goods_rebate);
        parcel.writeString(goods_barcode);
        parcel.writeString(fenxiao_yongjin);
        parcel.writeString(integral);
        parcel.writeString(integral_zs);
        parcel.writeString(quality);
        parcel.writeString(sort);
        parcel.writeStringList(goods_content);
        parcel.writeString(virtual_price);
        parcel.writeString(type_name);
        parcel.writeString(du_num);
        parcel.writeString(pin_name);
        parcel.writeString(liang_num);
        parcel.writeString(goods_ifpoint);
        parcel.writeString(goods_level);
        parcel.writeString(goods_shen);
        parcel.writeString(goods_guige);
        parcel.writeString(goods_shouhou);
        parcel.writeString(shop_type);
        parcel.writeString(goods_zxjg);
        parcel.writeString(goods_zxsl);
        parcel.writeString(goods_xuni_state);
        parcel.writeString(goods_cha_zhuan);
        parcel.writeString(xianshi_price);
        parcel.writeString(praise_rate);
        parcel.writeString(evaluation);
        parcel.writeByte((byte) (is_favorate ? 1 : 0));
        parcel.writeString(store_avatar);
        parcel.writeString(store_credit);
        parcel.writeDouble(peisong);
        parcel.writeTypedList(quan_data);
        parcel.writeString(juli);
    }

    public static class GevalModel {
        private String member_name;//"",
        private long geval_addtime;//"1529034042",
        private float geval_scores;//"4",
        private String member_avatar;//"4",
        private String geval_content;//"真好喝"

        public String getMember_avatar() {
            return member_avatar;
        }

        public void setMember_avatar(String member_avatar) {
            this.member_avatar = member_avatar;
        }

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public long getGeval_addtime() {
            return geval_addtime;
        }

        public void setGeval_addtime(long geval_addtime) {
            this.geval_addtime = geval_addtime;
        }

        public float getGeval_scores() {
            return geval_scores;
        }


        public String getGeval_content() {
            return geval_content;
        }

        public void setGeval_content(String geval_content) {
            this.geval_content = geval_content;
        }
    }

    public static class GoodsCommend {
        private String gid;// "105",
        private String vid;// "266",
        private String goods_name;// "江小白",
        private String goods_price;// "200.00",
        private String goods_costprice;// "200.00",
        private String goods_image;// "\/Uploads\/useruplod__23531539239750.jpg"

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_costprice() {
            return goods_costprice;
        }

        public void setGoods_costprice(String goods_costprice) {
            this.goods_costprice = goods_costprice;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }
    }

    public static class QuanModel implements Parcelable {
        private double voucher_t_price;//"50",
        private double voucher_t_limit;//"100.00",
        private double voucher_t_id;//"44"

        protected QuanModel(Parcel in) {
            voucher_t_price = in.readDouble();
            voucher_t_limit = in.readDouble();
            voucher_t_id = in.readDouble();
        }

        public static final Creator<QuanModel> CREATOR = new Creator<QuanModel>() {
            @Override
            public QuanModel createFromParcel(Parcel in) {
                return new QuanModel(in);
            }

            @Override
            public QuanModel[] newArray(int size) {
                return new QuanModel[size];
            }
        };

        public double getVoucher_t_price() {
            return voucher_t_price;
        }

        public void setVoucher_t_price(double voucher_t_price) {
            this.voucher_t_price = voucher_t_price;
        }

        public double getVoucher_t_limit() {
            return voucher_t_limit;
        }

        public void setVoucher_t_limit(double voucher_t_limit) {
            this.voucher_t_limit = voucher_t_limit;
        }

        public double getVoucher_t_id() {
            return voucher_t_id;
        }

        public void setVoucher_t_id(double voucher_t_id) {
            this.voucher_t_id = voucher_t_id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(voucher_t_price);
            dest.writeDouble(voucher_t_limit);
            dest.writeDouble(voucher_t_id);
        }
    }

    private Bijia bijia;

    public Bijia getBijia() {
        return bijia;
    }

    public void setBijia(Bijia bijia) {
        this.bijia = bijia;
    }

    public static class Bijia {
        private String brand_id;// "4",
        private String brand_num;// "0",
        private String brand_name;// "洋河老窖",
        private String brand_pm;// "海之蓝",
        private String brand_du;// "52",
        private String brand_gg;// "480",
        private String brand_jd;// "163",
        private String brand_tm;// "163",
        private String brand_jxw;// "163",
        private String brand_yhd;// "166",
        private String brand_jbz;// null,
        private String brand_wem;// "188",
        private String show_type;// "0"

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }

        public String getBrand_num() {
            return brand_num;
        }

        public void setBrand_num(String brand_num) {
            this.brand_num = brand_num;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getBrand_pm() {
            return brand_pm;
        }

        public void setBrand_pm(String brand_pm) {
            this.brand_pm = brand_pm;
        }

        public String getBrand_du() {
            return brand_du;
        }

        public void setBrand_du(String brand_du) {
            this.brand_du = brand_du;
        }

        public String getBrand_gg() {
            return brand_gg;
        }

        public void setBrand_gg(String brand_gg) {
            this.brand_gg = brand_gg;
        }

        public String getBrand_jd() {
            return brand_jd;
        }

        public void setBrand_jd(String brand_jd) {
            this.brand_jd = brand_jd;
        }

        public String getBrand_tm() {
            return brand_tm;
        }

        public void setBrand_tm(String brand_tm) {
            this.brand_tm = brand_tm;
        }

        public String getBrand_jxw() {
            return brand_jxw;
        }

        public void setBrand_jxw(String brand_jxw) {
            this.brand_jxw = brand_jxw;
        }

        public String getBrand_yhd() {
            return brand_yhd;
        }

        public void setBrand_yhd(String brand_yhd) {
            this.brand_yhd = brand_yhd;
        }

        public String getBrand_jbz() {
            return brand_jbz;
        }

        public void setBrand_jbz(String brand_jbz) {
            this.brand_jbz = brand_jbz;
        }

        public String getBrand_wem() {
            return brand_wem;
        }

        public void setBrand_wem(String brand_wem) {
            this.brand_wem = brand_wem;
        }

        public String getShow_type() {
            return show_type;
        }

        public void setShow_type(String show_type) {
            this.show_type = show_type;
        }
    }

    public static class CartDataModel {
        private String goods_name;//"南疆名酒",
        private String goods_ppp;//"0.01",
        private int goods_num;//"2",
        private String gid;//"57",
        private String integral_zs;//"100",
        private String integral;//"0",
        private String goods_freight;//"80.00",
        private String goods_rebate;//"80"

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_ppp() {
            return goods_ppp;
        }

        public void setGoods_ppp(String goods_ppp) {
            this.goods_ppp = goods_ppp;
        }

        public int getGoods_num() {
            return goods_num;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getIntegral_zs() {
            return integral_zs;
        }

        public void setIntegral_zs(String integral_zs) {
            this.integral_zs = integral_zs;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getGoods_freight() {
            return goods_freight;
        }

        public void setGoods_freight(String goods_freight) {
            this.goods_freight = goods_freight;
        }

        public String getGoods_rebate() {
            return goods_rebate;
        }

        public void setGoods_rebate(String goods_rebate) {
            this.goods_rebate = goods_rebate;
        }
    }
}
