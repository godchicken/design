package com.godchicken.nftdiggest.core.crawler;

import com.godchicken.nftdiggest.core.constant.Platform;
import com.godchicken.nftdiggest.core.entity.GoodsPageInfo;
import com.godchicken.nftdiggest.core.good.NftGood;

import java.util.List;

//获取挖掘平台商品
public interface PlatformCrawler<T extends NftGood> {

     Platform getPlatform();

     //全量爬取
     GoodsPageInfo queryGoodList(GoodsPageInfo pageInfo);

}
