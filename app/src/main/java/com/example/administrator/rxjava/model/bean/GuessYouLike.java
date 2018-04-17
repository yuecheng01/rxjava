package com.example.administrator.rxjava.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/23.
 */

public class GuessYouLike {
    /**
     * result : success
     * value : [{"goodsId":75622,"shopPrice":"90.90","marketPrice":"97.90","goodsName":"韩版轻熟女半高领毛衣","goodsImg":"upload/goods/2017-11/5d101f8c03cb7de553e95e69e1918248.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75622.html"},{"goodsId":75626,"shopPrice":"90.90","marketPrice":"97.90","goodsName":"韩版时髦超长款下白边加绒卫衣裙","goodsImg":"upload/goods/2017-11/e74ff536fb12daaac00c3b2456939598.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75626.html"},{"goodsId":75627,"shopPrice":"81.90","marketPrice":"88.90","goodsName":"韩版宽松大袖子开衫毛衣","goodsImg":"upload/goods/2017-11/2965aa1b2401b0a44048218fc5b4836d.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75627.html"},{"goodsId":75641,"shopPrice":"60.90","marketPrice":"65.90","goodsName":"风挂脖针织衫","goodsImg":"upload/goods/2017-11/b88a025f7254a1303cddce942fa6953f.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75641.html"},{"goodsId":75637,"shopPrice":"78.90","marketPrice":"84.90","goodsName":"欧美风绣花连帽卫衣","goodsImg":"upload/goods/2017-11/f8de70a08992921a567271112fa2a45a.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75637.html"},{"goodsId":75629,"shopPrice":"96.90","marketPrice":"104.90","goodsName":"韩版 加厚拼色麻花套头毛衣","goodsImg":"upload/goods/2017-11/82911858373026de5e6d269ed75ad625.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75629.html"},{"goodsId":75638,"shopPrice":"94.90","marketPrice":"102.90","goodsName":"欧美风毛衣2件套","goodsImg":"upload/goods/2017-11/5e3cb03cb71aca0114a1a029e31e3b22.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75638.html"},{"goodsId":75649,"shopPrice":"126.90","marketPrice":"136.90","goodsName":"欧美风oversize蝙蝠袖百搭棉服","goodsImg":"upload/goods/2017-11/75a40b874146fd7e07c6fa34060efd8c.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75649.html"},{"goodsId":75646,"shopPrice":"78.90","marketPrice":"84.90","goodsName":"欧美风包芯纱刺绣拉链毛衣","goodsImg":"upload/goods/2017-11/a46f0484b9e0b0dc6ef772bd08435699.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75646.html"},{"goodsId":75643,"shopPrice":"198.90","marketPrice":"214.90","goodsName":"复古丝绒短款加厚藕粉棉服","goodsImg":"upload/goods/2017-11/6f84b084a179b6f98519a4129163b6da.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75643.html"},{"goodsId":75633,"shopPrice":"96.90","marketPrice":"104.90","goodsName":"欧美风铁链丝绒卫衣","goodsImg":"upload/goods/2017-11/ad847d51afd06f12db28e1bd938b3756.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75633.html"},{"goodsId":75624,"shopPrice":"102.90","marketPrice":"110.90","goodsName":"韩版简约长款棒球棉服","goodsImg":"upload/goods/2017-11/305a3cf2238cf7d777de7e985ce5890f.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75624.html"},{"goodsId":75642,"shopPrice":"162.90","marketPrice":"175.90","goodsName":"廓形风衣","goodsImg":"upload/goods/2017-11/9623f2e1e8c32923f5d98c5ec564e910.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75642.html"},{"goodsId":75634,"shopPrice":"84.90","marketPrice":"91.90","goodsName":"欧美风钻石绒帽衫","goodsImg":"upload/goods/2017-11/331b0a0dca24e50dd381100f7de851ec.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75634.html"},{"goodsId":75631,"shopPrice":"102.90","marketPrice":"110.90","goodsName":"轻熟女风高端刺绣拉链毛衣开衫","goodsImg":"upload/goods/2017-11/dc87574d416f7bfe402494adb1d3a450.jpg","goodsUrl":"http://www.jingomall.vip/mgoods-75631.html"}]
     */

    private String result;
    private List<ValueBean> value;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ValueBean> getValue() {
        return value;
    }

    public void setValue(List<ValueBean> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GuessYouLike{" +
                "result='" + result + '\'' +
                ", value=" + value +
                '}';
    }

    public static class ValueBean {
        @Override
        public String toString() {
            return "ValueBean{" +
                    "goodsId=" + goodsId +
                    ", shopPrice='" + shopPrice + '\'' +
                    ", marketPrice='" + marketPrice + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", goodsImg='" + goodsImg + '\'' +
                    ", goodsUrl='" + goodsUrl + '\'' +
                    '}';
        }

        /**
         * goodsId : 75622
         * shopPrice : 90.90
         * marketPrice : 97.90
         * goodsName : 韩版轻熟女半高领毛衣
         * goodsImg : upload/goods/2017-11/5d101f8c03cb7de553e95e69e1918248.jpg
         * goodsUrl : http://www.jingomall.vip/mgoods-75622.html
         */

        private int goodsId;
        private String shopPrice;
        private String marketPrice;
        private String goodsName;
        private String goodsImg;
        private String goodsUrl;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getShopPrice() {
            return shopPrice;
        }

        public void setShopPrice(String shopPrice) {
            this.shopPrice = shopPrice;
        }

        public String getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(String marketPrice) {
            this.marketPrice = marketPrice;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsImg() {
            return goodsImg;
        }

        public void setGoodsImg(String goodsImg) {
            this.goodsImg = goodsImg;
        }

        public String getGoodsUrl() {
            return goodsUrl;
        }

        public void setGoodsUrl(String goodsUrl) {
            this.goodsUrl = goodsUrl;
        }
    }
}
