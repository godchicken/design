package com.godchicken.nftdiggest.core.entity;

import com.godchicken.nftdiggest.core.good.NftGood;

import java.util.ArrayList;
import java.util.List;

public class GoodsPageInfo {
    private Integer total;

    //默认从1开始
    private Integer pageSize;

    private Integer page;

    private final List<NftGood> nftGoods = new ArrayList<>(16);

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<NftGood> getNftGoods() {
        return nftGoods;
    }

    public GoodsPageInfo(Integer total, Integer pageSize, Integer page) {
        this.total = total;
        this.pageSize = pageSize;
        this.page = page;
    }
}
