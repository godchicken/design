package com.godchicken.nftdiggest.core.crawler;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.godchicken.nftdiggest.core.constant.Platform;
import com.godchicken.nftdiggest.core.entity.GoodsPageInfo;
import com.godchicken.nftdiggest.core.good.NftGood;
import com.godchicken.nftdiggest.core.good.UbanQuanGood;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class UbanQuanCrawler implements PlatformCrawler<UbanQuanGood>{

    private final static String ALL_PRODUCT_REQUEST = "https://apimall.ubanquan.cn/api/client-ubq-app/auctionMarket/pageAuctionProducts";

    private final static String PRDUCT_IMG_URL_TEMPLATE = "https://obs.prod.ubanquan.cn/%s?x-image-process=image/resize,m_fill,h_600,w_600";

    private final static String HIGH_PRICE_FILTER = "high_price";

    private final static String NEWEST_FILERE = "newest";

    private final static Map<String,String> headers = new HashMap<>();

    static {
        headers.put("Content-Type","application/json");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Connection","keep-alive");
    }

    @Override
    public Platform getPlatform() {
        return Platform.U_BAN_QUAN;
    }

    @Override
    public GoodsPageInfo queryGoodList(GoodsPageInfo pageInfo) {

        //每次查询10个,并返回
        UbanQuanQueryInfo ubanQuanQueryInfo = new UbanQuanQueryInfo();
        ubanQuanQueryInfo.setPageNum(pageInfo.getPage());
        ubanQuanQueryInfo.setPageSize(pageInfo.getPageSize());

        String body = HttpRequest.post(ALL_PRODUCT_REQUEST)
                .addHeaders(headers)//头信息，多个头信息多次调用此方法即可
                .body(JSONUtil.toJsonPrettyStr(ubanQuanQueryInfo))//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();


        UbanQuanQueryRes ubanQuanQueryRes = JSONUtil.toBean(body, UbanQuanQueryRes.class);
        pageInfo.setPage(ubanQuanQueryRes.pageNum);
        pageInfo.setPageSize(ubanQuanQueryRes.pageSize);
        pageInfo.setTotal(pageInfo.getTotal());

        for (UbanQuanQueryRes.DataDTO datum : ubanQuanQueryRes.getData()) {

        }


        return null;
    }



    private UbanQuanGood buildNftGoodByDataDTO(UbanQuanQueryRes.DataDTO dataDTO){
        UbanQuanGood ubanQuanGood = new UbanQuanGood();
        ubanQuanGood.setPlatform(getPlatform().getValue());
        ubanQuanGood.setProductCode(dataDTO.getProductNo());
        ubanQuanGood.setTheme(dataDTO.getThemeName());
        ubanQuanGood.setName(dataDTO.getProductName());
        ubanQuanGood.setAuthor(dataDTO.getAuthor());
        return null;

    }


    private static class UbanQuanQueryInfo{
        private Integer pageNum;

        private String terminal = "ANDROID";

        private String productFilterEnum = NEWEST_FILERE;

        private Integer status = 1;

        private String sort = "ASC";

        private Integer pageSize = 10;

        public Integer getPageNum() {
            return pageNum;
        }

        public void setPageNum(Integer pageNum) {
            this.pageNum = pageNum;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public String getProductFilterEnum() {
            return productFilterEnum;
        }

        public void setProductFilterEnum(String productFilterEnum) {
            this.productFilterEnum = productFilterEnum;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
    }


    @NoArgsConstructor
    @Data
    private static class UbanQuanQueryRes{

        @JsonProperty("success")
        private Boolean success;
        @JsonProperty("errorMsg")
        private Object errorMsg;
        @JsonProperty("sysTime")
        private Long sysTime;
        @JsonProperty("pageNum")
        private Integer pageNum;
        @JsonProperty("pageSize")
        private Integer pageSize;
        @JsonProperty("totalPages")
        private Integer totalPages;
        @JsonProperty("totalRecords")
        private Integer totalRecords;
        @JsonProperty("data")
        private List<DataDTO> data;

        @NoArgsConstructor
        @Data
        public static class DataDTO {
            @JsonProperty("themeKey")
            private String themeKey;
            @JsonProperty("themeName")
            private String themeName;
            @JsonProperty("coverImg")
            private String coverImg;
            @JsonProperty("sourceImg")
            private Object sourceImg;
            @JsonProperty("productNo")
            private String productNo;
            @JsonProperty("productName")
            private String productName;
            @JsonProperty("author")
            private String author;
            @JsonProperty("serialNum")
            private String serialNum;
            @JsonProperty("name")
            private String name;
            @JsonProperty("nowBid")
            private Integer nowBid;
            @JsonProperty("status")
            private String status;
            @JsonProperty("storeName")
            private Object storeName;
        }
    }
}
