package com.godchicken.nftdiggest.service;

import com.godchicken.nftdiggest.entity.NftGoods;
import java.util.List;

/**
 * (NftGoods)表服务接口
 *
 * @author makejava
 * @since 2022-04-17 21:45:53
 */
public interface NftGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NftGoods queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NftGoods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param nftGoods 实例对象
     * @return 实例对象
     */
    NftGoods insert(NftGoods nftGoods);

    /**
     * 修改数据
     *
     * @param nftGoods 实例对象
     * @return 实例对象
     */
    NftGoods update(NftGoods nftGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}